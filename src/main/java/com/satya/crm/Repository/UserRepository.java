package com.satya.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.crm.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
