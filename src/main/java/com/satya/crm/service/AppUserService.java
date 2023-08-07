package com.satya.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.crm.Repository.AppUserRepository;
import com.satya.crm.models.AppUser;

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	public AppUser saveAppUser(AppUser appUser) {
		return appUserRepository.save(appUser);
	}
}
