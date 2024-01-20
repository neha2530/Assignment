package com.example.village.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
    @SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize = 1)
	    private Long id;
	    private int age;
	    private String name;
	    private String personSts;
	    private String familyType;
	    
	    @ManyToOne
	    @JsonBackReference
	    private Village village;
	    
	    @JsonProperty("personSts")
		public String getPersonSts() {
			return personSts;
		}
		public String getFamilyType() {
			return familyType;
		}
		public void setFamilyType(String familyType) {
			this.familyType = familyType;
		}
		public void setPersonSts(String personSts) {
			this.personSts = personSts;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Village getVillage() {
			return village;
		}
		public void setVillage(Village village) {
			this.village = village;
		}

}
