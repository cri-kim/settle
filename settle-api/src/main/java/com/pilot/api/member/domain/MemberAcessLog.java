package com.pilot.api.member.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "member_access_log")
public class MemberAcessLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long seq;
	
	@Column(name = "member_key")
	private String memberKey;
	
	private String device;
	
	@Column(name = "coonect_ip")
	private String connectIp;
	
	@Column(name = "reg_dtm")
	private String regDtm;
}
