package com.pilot.api.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "auth")
@DynamicUpdate
public class Auth extends BaseTimeEntity{
	@Id
	@Column(name = "auth_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authKey;

	@Column(name = "use_yn", unique = true)
	private String useYn;
	
	@Column(name = "auth_nm", unique = true)
	private String authNm;

}
