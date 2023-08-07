package com.satya.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.satya.crm.Repository.AppUserRepository;
import com.satya.crm.models.AppUser;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserRepository.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not found register !!");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
