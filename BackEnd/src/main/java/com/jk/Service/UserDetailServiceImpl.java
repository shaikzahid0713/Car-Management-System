package com.jk.Service;

import com.jk.Model.User;
import com.jk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        User currentUser = userRepository.findByUserName(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, currentUser.getUserPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getUserRole()));
        return userDetails;
    }

}
