package com.example.village.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.village.Model.Person;


public interface VillageService  {
	public List<Person> getAll();


	public long count();
	
	public long deathCount();
	public long newBornCount();
	public long accidentalDeath(int personId);
}
