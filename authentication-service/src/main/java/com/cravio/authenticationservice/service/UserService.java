package com.cravio.authenticationservice.service;


import com.cravio.authenticationservice.dto.UserRegistrationRequest;
import com.cravio.authenticationservice.model.Role;
import com.cravio.authenticationservice.model.User;
import com.cravio.authenticationservice.repository.RoleRepository;
import com.cravio.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private KitchenStaffRepository kitchenStaffRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role: Top Priority");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role: Restricted Priority");
        roleRepository.save(userRole);

        Role kitchenStaffRole = new Role();
        kitchenStaffRole.setRoleName("KitchenStaff");
        kitchenStaffRole.setRoleDescription("KitchenStaff Role: Specialized Priority");
        roleRepository.save(kitchenStaffRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("password"));
        adminUser.setUserFirstName("admin_first");
        adminUser.setUserLastName("admin_last");
        adminUser.setUserAddress("Not Applicable");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);
    }

    public User registerNewUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUserName(userRegistrationRequest.getUserName());
        user.setUserFirstName(userRegistrationRequest.getUserFirstName());
        user.setUserLastName(userRegistrationRequest.getUserLastName());
        user.setUserPassword(getEncodedPassword(userRegistrationRequest.getUserPassword()));
        user.setUserAddress(userRegistrationRequest.getUserAddress());
        Role userRole = roleRepository.findById("User").orElseThrow(() -> new RuntimeException("User role not found"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);

        return userRepository.save(user);
    }

    public User registerNewKitchenStaff(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUserName(userRegistrationRequest.getUserName());
        user.setUserFirstName(userRegistrationRequest.getUserFirstName());
        user.setUserLastName("Restuarent");
        user.setUserPassword(getEncodedPassword(userRegistrationRequest.getUserPassword()));
        user.setUserAddress("Not Applicable");
        Role userRole = roleRepository.findById("KitchenStaff").orElseThrow(() -> new RuntimeException("KitchenStaff role not found"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);

        return userRepository.save(user);
    }




    private String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
