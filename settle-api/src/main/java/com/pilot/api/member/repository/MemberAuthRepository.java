package com.pilot.api.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.member.entity.MemberAuth;


@Repository
public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long>{
	public List<MemberAuth> findByMemberKey(String memberKey);
}
