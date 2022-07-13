package com.example.testing1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testing1.entities.ProductEntities;
import com.example.testing1.entities.UserEntities;
import com.example.testing1.repository.UserRepository;

@Service
public class UserService implements UserServiceInt {
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
  private UserRepository userRepository;
     public UserService() {
    	  this.passwordEncoder = new BCryptPasswordEncoder();
     }
	@Override
	public void userSave(UserEntities user) {
	String encodePassword = 	this.passwordEncoder.encode(user.getPassword());
	user.setPassword(encodePassword);
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	

//	@Override
//	public String loginUser(UserEntities user) {
//		// TODO Auto-generated method stub
//	
//		UserEntities u = userRepository.findByEmail(user.getEmail());
//		if(u ==null) {
//			return "Email Is Wrong Try Later";
//		}
//		else {
//		boolean flag =	this.passwordEncoder.matches(user.getPassword(),u.getPassword());
//        System.out.println("Output"+flag);
//        if(flag!= false) {
//        	return "Login Successfully";
//        }
//        else {
//			return "Password is wrong Try Again";
//		}
//		}
		
	
	
}