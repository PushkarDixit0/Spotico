package com.sportico.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Basedto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long ID;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate CreatedOn;
	@JsonProperty(access = Access.READ_ONLY)
	
	private LocalDateTime UpdatedOn;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public LocalDate getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		CreatedOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return UpdatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		UpdatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "Basedto [ID=" + ID + ", CreatedOn=" + CreatedOn + ", UpdatedOn=" + UpdatedOn + "]";
	}
	
	
}
