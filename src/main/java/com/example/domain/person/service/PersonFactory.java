package com.example.domain.person.service;

import com.example.domain.person.entity.Person;
import com.example.domain.person.repository.facade.PersonRepository;
import com.example.domain.person.repository.po.PersonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PersonFactory {

    @Autowired
    PersonRepository personRepository;

    public PersonPO createPersonPO(Person person) {
        PersonPO personPO = new PersonPO();
        personPO.setPersonId(person.getPersonId());
        personPO.setPersonName(person.getPersonName());
        personPO.setCreateTime(person.getCreateTime());
        personPO.setLastModifyTime(person.getLastModifyTime());
        personPO.setStatus(person.getStatus());
        return personPO;
    }

    public Person createPerson(PersonPO po) {
        Person person = new Person();
        person.setPersonId(String.valueOf(po.getPersonId()));
        person.setPersonName(po.getPersonName());
        person.setStatus(po.getStatus());
        person.setCreateTime(po.getCreateTime());
        person.setLastModifyTime(po.getLastModifyTime());
        return person;
    }

    public Person getPerson(PersonPO personPO) {
        personPO = personRepository.findById(String.valueOf(personPO.getPersonId()));
        return createPerson(personPO);
    }

}
