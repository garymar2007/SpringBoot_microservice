package com.gary.springboot.microservice.springboot_microservice.repo;

import com.gary.springboot.microservice.springboot_microservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    Optional<TourPackage> findTourPackageByName(String tourPackageName);
}
