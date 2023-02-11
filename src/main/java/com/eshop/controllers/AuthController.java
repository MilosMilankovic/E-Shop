package com.eshop.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.eshop.controllers.auth.JwtResponse;
import com.eshop.controllers.auth.LoginRequest;
import com.eshop.controllers.auth.MessageResponse;
import com.eshop.controllers.auth.SignupRequest;
import com.eshop.entities.Role;
import com.eshop.entities.User;
import com.eshop.entities.UserRole;
import com.eshop.repositories.RoleRepository;
import com.eshop.repositories.UserRepository;
import com.eshop.security.ERole;
import com.eshop.security.JwtUtils;
import com.eshop.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setToken(jwt);
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setRoles(roles);
        jwtResponse.setType("Bearer");

    return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @PostMapping("/signout")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> signout(HttpServletRequest request) {

        try {
            request.logout();
        } catch (ServletException e) {
            return new ResponseEntity<>("Signout error!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Signout successful!", HttpStatus.OK);
    }

    @PostMapping("/signup")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = User.builder().username(signUpRequest.getUsername()).password(encoder.encode(signUpRequest.getPassword())).build();


        String role = signUpRequest.getRole();
        Role r = null;
        if (role == null) {
            r = roleRepository.findByName(ERole.ROLE_USER.name())
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else {
            switch (role) {
                case "admin":
                    r = roleRepository.findByName(ERole.ROLE_ADMIN.name())
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

                    break;
                default:
                    r = roleRepository.findByName(ERole.ROLE_USER.name())
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            }
        }

		Set<UserRole> userRoleSet = new HashSet<>();

        UserRole userRole = new UserRole();
        userRole.setRole(r);
		userRole.setUser(user);
		userRoleSet.add(userRole);

        user.setUserRoles(userRoleSet);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}