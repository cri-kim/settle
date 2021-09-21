package com.pilot.api.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUserIdAndPasswd(String userId, String passwd);
	
	public Optional<User> findByUserId(String userId);
}
