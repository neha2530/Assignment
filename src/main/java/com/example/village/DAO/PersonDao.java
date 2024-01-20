package com.example.village.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.village.Model.Person;

public interface PersonDao extends JpaRepository<Person, Long> {
	public List<Person> findByPersonSts(String personSts);

}
