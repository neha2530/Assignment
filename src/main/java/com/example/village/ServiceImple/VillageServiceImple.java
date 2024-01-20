package com.example.village.ServiceImple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.village.DAO.PersonDao;
import com.example.village.Model.Person;
import com.example.village.Model.Village;
import com.example.village.Repository.VillageRepository;
import com.example.village.Service.VillageService;
@Service
public class VillageServiceImple implements VillageService{
@Autowired
private PersonDao personDao;

@Autowired
private VillageRepository villageRepository;

	@Override
	public List<Person> getAll() {
		List<Person> all = this.personDao.findAll();
		List<Person> collect = all.stream().filter(e-> e.getPersonSts().equals("alive")).collect(Collectors.toList());
		return collect;
	}


	@Override
	public long count() {
		Optional<Village> villageOptional = villageRepository.findById(1L);

        if (villageOptional.isPresent()) {
            Village village = villageOptional.get();
            List<Person> personsInVillage = village.getPersons();

            long count = personsInVillage.stream()
                    .filter(person -> "alive".equals(person.getPersonSts()))
                    .count();

            return count;
        } else {
            return 0; // Village with the specified ID not found
        }
	}


	@Override
	public long deathCount() {
		// TODO Auto-generated method stub
		Village village = villageRepository.findById(1L).get();
		return village.getDeathCount();
	}

	@Override
	public long newBornCount() {
		// TODO Auto-generated method stub
		Village village = villageRepository.findById(1L).get();
		return village.getNewBornCount();
	}

	@Override
	public long accidentalDeath(int personId) {
		// TODO Auto-generated method stub
		Person person = personDao.findById(Long.valueOf(personId)).orElse(null);
		long deadPersonId = 0;
		if (person != null) {
			person.setPersonSts("dead");
			deadPersonId = person.getId();
			personDao.save(person);
		}
		villageRepository.findById(1l).ifPresent(v -> {
			v.setDeathCount(v.getDeathCount() + 1);
			villageRepository.save(v);
		});
		return deadPersonId;
	}

}
