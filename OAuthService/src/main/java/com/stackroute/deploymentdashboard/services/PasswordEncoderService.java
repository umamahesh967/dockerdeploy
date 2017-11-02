package com.stackroute.deploymentdashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.configuration.CustomUserDetails;
import com.stackroute.deploymentdashboard.model.UserInfo;
import com.stackroute.deploymentdashboard.model.UserRole;

@Service
public class PasswordEncoderService {
	@Bean
	public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
