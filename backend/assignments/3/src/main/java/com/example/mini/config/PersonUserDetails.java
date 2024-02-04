package com.example.mini.config;


import com.example.mini.DAO.UserDAO;
import com.example.mini.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonUserDetails implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public PersonUserDetails(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUserModel = userDAO.findByUserName(username);
        User user = null;
        if(optionalUserModel.isPresent())   user = optionalUserModel.get();
        String personUserName;
        String personPassword;
        List<GrantedAuthority> authorities;

        if (user == null) {
            throw new UsernameNotFoundException("User details not found for user: ".concat(username).concat(". Please register first."));
        } else {
            personUserName = user.getUserName();
            personPassword = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return (UserDetails) new User(personUserName, personPassword, authorities);
    }
}
