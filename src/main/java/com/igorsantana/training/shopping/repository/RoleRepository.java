package com.igorsantana.training.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorsantana.training.shopping.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
