package com.demogatalea.galateademo.repository;

import com.demogatalea.galateademo.model.Modelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManuscriptRepository extends MongoRepository<Modelo, String> {
    boolean existsByManuscript(java.util.List<String> manuscript);
}