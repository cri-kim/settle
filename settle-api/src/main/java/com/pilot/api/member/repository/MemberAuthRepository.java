package com.pilot.api.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilot.api.member.entity.MemberAuth;


@Repository
public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long>{
	public List<MemberAuth> findByMemberKey(Long memberKey);
	
	public List<MemberAuth> findByAuthKey(Long authKey);
	
	public Optional<MemberAuth> findByMemberKeyAndAuthKey(Long memberKey, Long authKey);
}
