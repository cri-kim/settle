package com.pilot.api.owner;

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
@Entity(name = "owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long ownerKey;
	private String ownerId;
	private String ownerNm;
	private String state;
	private String regDtm;
	private String modDtm;
}
