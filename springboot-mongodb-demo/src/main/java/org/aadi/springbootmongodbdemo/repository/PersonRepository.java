package org.aadi.springbootmongodbdemo.repository;

import org.aadi.springbootmongodbdemo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);

    //List<Person> findByAgeBetween(Integer min, Integer max); //we can do this as well, but we want to use Query.

    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1 } }" , fields = "{addresses : 0}")
    List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
