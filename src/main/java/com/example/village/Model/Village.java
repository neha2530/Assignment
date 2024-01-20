package com.example.village.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Village {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
    @SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize = 1)
	private Long id;
	
	@OneToMany(mappedBy = "village")
	@JsonManagedReference
	private List<Person> persons;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public Long getDeathCount() {
		return deathCount;
	}
	public void setDeathCount(Long deathCount) {
		this.deathCount = deathCount;
	}
	public Long getNewBornCount() {
		return newBornCount;
	}
	public void setNewBornCount(Long newBornCount) {
		this.newBornCount = newBornCount;
	}
	private Long deathCount = 0l;
	private Long newBornCount = 0l;

}
