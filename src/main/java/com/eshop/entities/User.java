package com.eshop.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "USERNAME", unique = true)
//    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
//    @Size(min = 3, max = 50)
    private String password;

    @NotBlank
//    @Size(min = 2, max = 40)
    private String firstName;

    @NotBlank
//    @Size(min = 2, max = 40)
    private String lastName;

//    @Size(min = 5, max = 30)
    private String phone;
    private boolean enabled=true;

//    jedan User moze da ima 1 rolu
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "user")
    private ShoppingCart shoppingCart;
}
