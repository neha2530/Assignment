package com.example.village.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.village.Model.Person;
import com.example.village.Service.VillageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/person")
public class VillageController {

@Autowired
private VillageService villageService;

@GetMapping("/list")
public ResponseEntity<List<Person>> getVillageList(){
	List<Person> all = this.villageService.getAll();
	return ResponseEntity.ok(all);
	

}
@GetMapping("/totalPopulation")
 public long aliveCount() {
	 long count = this.villageService.count();
	return count;
	 
 }

@GetMapping("/deathCount")
public long deathCount() {
	 long count = this.villageService.deathCount();
	return count;
	 
}

@GetMapping("/newBornCount")
public long newBornCount() {
	 long count = this.villageService.newBornCount();
	return count;
	 
}

@PostMapping("/accidentalDeath/{personId}")
public long accidentalDeath(@PathVariable(name = "personId") String personId) {
	 long count = this.villageService.accidentalDeath(Integer.valueOf(personId));
	return count;
	 
}


}
