package com.gl.GradedProject17.Model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo  extends JpaRepository<AppUser, Integer>{

	Optional<AppUser> findByName(String username);

}
