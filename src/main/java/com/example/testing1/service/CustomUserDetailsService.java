package com.example.testing1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.testing1.entities.UserEntities;
import com.example.testing1.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	  private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
          
		UserEntities u = userRepository.findByEmail(userEmail);
		System.out.println(u+" "+u.getPassword());
		if(u !=null) {
			return new User(u.getEmail(),u.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found..");
		}
		
	}

}
