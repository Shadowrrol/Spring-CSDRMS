package com.capstone.csdrms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.csdrms.Entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
