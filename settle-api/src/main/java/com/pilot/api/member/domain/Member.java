package com.pilot.api.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "member")
public class Member {
	@Id
	@Column(name = "member_key")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long memberKey;
	
	@Column(name = "member_id")
	private String memberId;
	
	private String passwd;
	
	private String role;
	
	@Column(name = "member_nm")
	private String memberNm;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "reg_dtm")
	private String regDtm;
	
	@Column(name = "mod_dtm")
	private String modDtm;
}
