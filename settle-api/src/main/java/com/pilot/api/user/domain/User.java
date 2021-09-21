package com.pilot.api.user.domain;

import java.io.Serializable;

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
@Entity(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_key")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userKey;
	
	@Column(name="user_id", nullable = false, length = 20)
	private String userId;
	
	@Column(name="passwd", nullable = false, length = 20)
	private String passwd;
	
	private String role;
}
