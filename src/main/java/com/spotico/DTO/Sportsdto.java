package com.spotico.DTO;

import com.spotico.pojos.SportType;

public class Sportsdto {
	private String Name;
	
	
	private SportType Type;

	public Sportsdto() {
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
		return "Sportsdto [Name=" + Name + ", Type=" + Type + "]";
	}
	
	
	
	
}
