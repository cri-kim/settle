package com.pilot.api.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;


/**
 * ref : https://velog.io/@swchoi0329/Spring-Boot%EC%97%90%EC%84%9C-JPA-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
 * */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
	@CreatedDate
	private LocalDateTime regDtm;
	
	@LastModifiedDate
	private LocalDateTime modDtm;
}
