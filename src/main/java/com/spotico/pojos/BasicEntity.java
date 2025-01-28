package com.spotico.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

public class BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;
	@CreationTimestamp
	@Column(name = "createdon")
	private LocalDate CreatedOn;
	@UpdateTimestamp
	@Column(name = "updatedon")
	private LocalDateTime UpdatedOn;
	public BasicEntity() {
		
	}
	
	
	
	
	
	public LocalDate getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		CreatedOn = createdOn;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}

	public LocalDateTime getUpdatedOn() {
		return UpdatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		UpdatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "BasicEntity [ID=" + ID + ", CreatedOn=" + CreatedOn + ", UpdatedOn=" + UpdatedOn + "]";
	}
	
	
	
	
	
}
