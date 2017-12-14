package com.example.contact;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue
	Long id;
	String name;

	public Contact(String name) {
		this.name = name;
	}
}
