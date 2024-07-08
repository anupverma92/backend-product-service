package com.anup.productmanagement.service;

import com.anup.productmanagement.entity.Role;
import com.anup.productmanagement.entity.User;
import com.anup.productmanagement.model.AuthenticationRequest;
import com.anup.productmanagement.model.AuthenticationResponse;
import com.anup.productmanagement.model.RegistrationRequest;
import com.anup.productmanagement.repository.RoleRepository;
import com.anup.productmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register(RegistrationRequest request) {
        Role role = roleRepository.findByName("USER")
                //TODO: Better exception Handling
                .orElseThrow(() -> new IllegalStateException("Role USER not found"));

        User user = User.builder()
                .fullName(request.getFullName())
                .emailId(request.getEmailId())
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                //.password(request.getPassword())
                .roles(List.of(role))
                .build();

        userRepository.save(user);
        //video from 2:25:00 - https://www.youtube.com/watch?v=WuPa_XoWlJU
        //sendValidationEmail(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmailId(), request.getPassword()));

        HashMap<String, Object> claims = new HashMap<>();
        User user = (User) authenticate.getPrincipal();
        claims.put("fullName", user.getFullName());
        String jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
