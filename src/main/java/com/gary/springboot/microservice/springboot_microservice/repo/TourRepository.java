package com.gary.springboot.microservice.springboot_microservice.repo;

import com.gary.springboot.microservice.springboot_microservice.domain.Difficulty;
import com.gary.springboot.microservice.springboot_microservice.domain.Region;
import com.gary.springboot.microservice.springboot_microservice.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    @Query("select t from Tour t where t.tourPackage.code=?1 and t.difficulty=?2 and t.region = ?3 and t.price <= ?4")
    List<Tour> lookupTour(String code, Difficulty difficulty, Region region, Integer maxPrice);

    //Alternatively
    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceIsLessThan(String code, Difficulty difficulty, Region region, Integer maxPrice);

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
