package com.train.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	
}
