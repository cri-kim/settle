package com.pilot.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.user.domain.User;

@Repository
public interface UserAccessLogRespository extends JpaRepository<User, Long> {

}
