package com.igorsantana.training.shopping.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role extends AbstractModel {

	private String name;
	
	@ManyToMany
	private List<User> users;
}
