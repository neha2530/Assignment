package com.example.village.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.village.Model.Person;
import com.example.village.Model.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{

}
