package com.sportico.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "sports")
public class Sports extends BasicEntity {

	@Column (name = "name")
	private String Name;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "type")
	private SportType Type;
	
	public Sports() {
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public SportType getType() {
		return Type;
	}
	public void setType(SportType type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Sports [Name=" + Name + ", Type=" + Type + "]";
	}
	
	
	
	
}
