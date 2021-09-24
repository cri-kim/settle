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
@Data /* FIXME getter로 변경하고 memgerDetail 별도로 추출 필요 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "member")
@DynamicUpdate
public class Member extends BaseTimeEntity{
	@Id
	@Column(name = "member_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberKey;

	@Column(name = "member_id", unique = true)
	private String memberId;

	private String passwd;

	private String role;

	@Column(name = "member_nm")
	private String memberNm;

	@Column(name = "state")
	private String state;

}
