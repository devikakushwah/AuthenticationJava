package com.example.testing1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing1.entities.CountryEntities;
import com.example.testing1.entities.UserEntities;
import com.example.testing1.model.JwtRequest;
import com.example.testing1.model.JwtResponse;
import com.example.testing1.service.CountryServiceInt;
import com.example.testing1.service.CustomUserDetailsService;
import com.example.testing1.service.UserServiceInt;
import com.example.testing1.util.JwtUtil;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationManager;
   @Autowired
	private CustomUserDetailsService customerUserDetailsService;
   @Autowired
 	 private UserServiceInt userServiceInt;
 	
  	@RequestMapping(value = "user-add", method = RequestMethod.POST)
 	public UserEntities saveUser(@RequestBody UserEntities user) {
        System.out.println("comin");
 		
 		userServiceInt.userSave(user);
 		return user;
 	}
  	
   @Autowired
   private JwtUtil jwtUtil;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(),jwtRequest.getPassword()));
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		UserDetails userDetails = this.customerUserDetailsService.loadUserByUsername(jwtRequest.getEmail());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("Jwt"+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
}
