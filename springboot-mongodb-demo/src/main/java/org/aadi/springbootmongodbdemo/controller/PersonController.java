package org.aadi.springbootmongodbdemo.controller;

import lombok.RequiredArgsConstructor;
import org.aadi.springbootmongodbdemo.entity.Person;
import org.aadi.springbootmongodbdemo.service.PersonService;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/save")
    public String save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping("/getPerson")
    public List<Person> getPersonStartWith(@RequestParam("name") String name){
        return personService.getPersonStartWith(name);
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge,
                                         @RequestParam Integer maxAge){
        return personService.getByPersonAge(minAge,maxAge);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id){
        personService.deletePerson(id);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(@RequestParam(required=false) String name,
                                     @RequestParam(required=false) Integer minAge,
                                     @RequestParam(required=false) Integer maxAge,
                                     @RequestParam(required=false) String city,
                                     @RequestParam(defaultValue="0") Integer page,
                                     @RequestParam(defaultValue="5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return personService.search(name,minAge,maxAge,city,pageable);
    }

    @GetMapping("/oldestPerson")
    public List<Document> getOldestPersonByCity(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopulationByCity(){
        return personService.getPopulationByCity();
    }
}