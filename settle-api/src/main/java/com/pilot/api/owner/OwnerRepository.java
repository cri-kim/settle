package com.pilot.api.owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

	public List<Owner> findByOwnerId(String ownerId);
}
