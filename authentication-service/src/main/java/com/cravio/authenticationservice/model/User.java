package com.cravio.authenticationservice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

public class User {

    @Id
    private String userName;
    private Long id;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userAddress;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

}