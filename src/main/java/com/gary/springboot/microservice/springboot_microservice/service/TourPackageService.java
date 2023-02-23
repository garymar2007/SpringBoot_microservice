package com.gary.springboot.microservice.springboot_microservice.service;

import com.gary.springboot.microservice.springboot_microservice.domain.TourPackage;
import com.gary.springboot.microservice.springboot_microservice.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code code of the package
     * @param name name of the package
     *
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {
        return this.tourPackageRepository.findById(code)
                .orElse(this.tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     * Lookup All Tour packages
     *
     * @return all tour packages
     */
    public Iterable<TourPackage> lookup(){
        return this.tourPackageRepository.findAll();
    }

    public long total() {
        return this.tourPackageRepository.count();
    }
}
