package com.pilot.api.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.member.domain.Member;

@Repository
public interface MemberAccessLogRespository extends JpaRepository<Member, Long> {

}
