package com.example.testing1.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.testing1.service.CustomUserDetailsService;
import com.example.testing1.util.JwtUtil;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private CustomUserDetailsService customerUserDetailsService;
    @Autowired
	private JwtUtil jwtUtils;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtils.getUsernameFromToken(jwtToken);
			}catch(Exception e) {
				e.printStackTrace();
			}
			 UserDetails userDetails = this.customerUserDetailsService.loadUserByUsername(username);
			 if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
			    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
			                    userDetails, null, userDetails.getAuthorities());
			   usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			   }
			   else {
			        	System.out.println("Token is not valid !");
			     }
			   
		}
	    
		filterChain.doFilter(request, response);
	}

}
