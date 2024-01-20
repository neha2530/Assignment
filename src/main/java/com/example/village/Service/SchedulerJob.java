package com.example.village.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.village.DAO.PersonDao;
import com.example.village.Model.Person;
import com.example.village.Model.Village;
import com.example.village.Repository.VillageRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class SchedulerJob {
	
	@Autowired
	private VillageService villageService;
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private PersonDao personDao;
	
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Autowired
    private  ResourceLoader resourceLoader;
	
	@Transactional
	@Scheduled(fixedRate = 60000)
	public void afterEveryMin() {
		System.out.print("Current Time: "+System.currentTimeMillis());
		
		
		 Village village = villageRepository.findById(1L).orElse(null);

	        if (village != null) {
	            villageService.getAll().forEach(person -> {
	                person.setAge(person.getAge() + 1);

	                if (person.getAge() >= 80) {
	                    person.setPersonSts("dead");
	                    Long deathCount = village.getDeathCount() == null ? 0 : village.getDeathCount();
	                    village.setDeathCount(deathCount + 1);
	                }

	                if (person.getAge() >= 30 && person.getAge() <= 33) {
	                    Long newBornCount = village.getNewBornCount() == null ? 0 : village.getNewBornCount();
	                    village.setNewBornCount(newBornCount + 1);

	                    Person p = new Person();
	                    p.setName("Baby" + Math.random());
	                    p.setAge(0);
	                    p.setFamilyType(person.getFamilyType());
	                    p.setPersonSts("alive");
	                    // Uncomment the line below if you want to associate the new person with the village
	                     p.setVillage(village);
	                    personDao.save(p);
	                }

	                personDao.save(person); // Save the changes to the existing person
	            });

	            villageRepository.save(village); // Save the changes to the village
	        }
	    }
	
	
	@PostConstruct
	 public void initializeDatabase() {
	        try {
	            // Load SQL script from the resource folder
	            Resource resource = resourceLoader.getResource("classpath:init.sql");
	            String sqlScript = new BufferedReader(new InputStreamReader(resource.getInputStream()))
	                    .lines()
	                    .collect(Collectors.joining("\n"));

	            // Execute SQL script
	            jdbcTemplate.execute(sqlScript);
	        } catch (IOException e) {
	            throw new RuntimeException("Error loading SQL script", e);
	        }
	    }
}