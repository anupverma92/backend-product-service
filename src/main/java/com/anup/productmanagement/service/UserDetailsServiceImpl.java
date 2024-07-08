package com.anup.productmanagement.service;

import com.anup.productmanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        return userRepository.findByEmailId(emailId).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
