package com.satya.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.satya.crm.models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	@Query("SELECT u from AppUser u WHERE u.email = :email")
	public AppUser getUserByUserName(@Param("email")String email);
}
