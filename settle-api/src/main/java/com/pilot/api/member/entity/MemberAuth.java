package com.pilot.api.member.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.pilot.api.common.entity.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data /* FIXME getter로 변경 필요 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "member_auth")
@DynamicUpdate
public class MemberAuth extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_key", updatable = false)
	private Member memberKey;
	
	@Column(name = "auth_key")
	private Long authKey;

	@Column(name = "use_yn", unique = true)
	private String useYn;

}
