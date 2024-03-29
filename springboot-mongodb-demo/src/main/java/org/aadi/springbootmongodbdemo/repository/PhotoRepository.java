package org.aadi.springbootmongodbdemo.repository;

import org.aadi.springbootmongodbdemo.entity.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
