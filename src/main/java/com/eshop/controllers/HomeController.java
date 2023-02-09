//package com.eshop.controllers;
//
//import com.eshop.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestMethod;
////import org.springframework.web.bind.annotation.RequestParam;
//
////import javax.servlet.http.HttpServlet;
////import java.util.HashSet;
////import java.util.Locale;
////import java.util.Set;
////import java.util.UUID;
//
//@Controller
//public class HomeController {
//
//    @Autowired
//    private UserService userService;
//
////    @Autowired
////    private UserSecurityService userSecurityService;
//
////    @Autowired
////    private JavaMailSender mailSender;
//
//
////    @Autowired
////    private MailConstructor mailConstructor;
//
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
//
//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("classActiveLogin", true);
//        return "myAccount";
//    }
//
//    @RequestMapping("/forgetPassword")
//    public String forgetPassword(
//            Model model) {
//        model.addAttribute("classActiveForgetPassword", true);
//        return "myAccount";
//    }
//
////    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
////    public String newUserPost(
////            HttpServletRequest request,
////            @ModelAttribute("email") String userEmail,
////            @ModelAttribute("username") String username,
////            Model model
////            ) throws Exception {
////        model.addAttribute("classActiveNewAccount", true);
////        model.addAttribute("email", userEmail);
////        model.addAttribute("userName", username);
////
////        if (userService.findByUsername(username) != null) {
////            model.addAttribute("usernameExists", true);
////            return "myAccount";
////        }
////        if (userService.findByEmail(userEmail) != null) {
////            model.addAttribute("email", true);
////            return "myAccount";
////        }
////        User user = new User();
////        user.setUsername(username);
////        user.setEmail(userEmail);
////
////        String password = SecurityUtility.randomPassword();
////        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
////        user.setPassword(encryptedPassword);
////
////        Role role = new Role();
////        role.setRoleId(1);
////        role.setName("ROLE_USER");
////        Set<UserRole> userRoles = new HashSet<>();
////        userRoles.add(new UserRole(user, role));
////        userService.createUser(user, userRoles);
////
////
////        String token = UUID.randomUUID().toString();
////        userService.createPasswordResetTokenForUser(user, token);
////       // String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
////
////        //SimpleMailMessage email = mailConstructor.constructorResetTokenEmail(appUrl, request.getLocale(), token, user, password);
////        //mailSender.send(email);
////        model.addAttribute("email", "true");
////        return "myAccount";
//
//
////    }
//
//
//
//
//
//
//
//    // sa tokenom, govori nam da user vec "potpisan" sign up registri page
////    @RequestMapping("/newUser")
////    public String newUser(Locale locale, @RequestParam("token") String token,Model model) {
////        PasswordResetToken passToken = userService.getPasswordResetToken(token);
////
////        if (passToken == null) {
////            String message = "Invalid Token.";
////            model.addAttribute("message", message);
////            return "redirect:/badRequest";
////        }
////        // User ce biti pronadjen pre Tokena, ako je Token null ne postoji u bazi, onda imamo username
////        User user = passToken.getUser();
////        String username = user.getUsername();
////        //63-66 login session , da budemo sigurni da je ulogovan
////        UserDetails userDetails = userSecurityService.loadUserByUsername(username);
////        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////
////        model.addAttribute("classActiveEdit", true);
////        return "myProfile";
////    }
//}
