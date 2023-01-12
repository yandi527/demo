package com.example.leave.domain.person.repository.persistence;

import com.example.leave.domain.person.repository.facade.PersonRepository;

import com.example.leave.domain.person.repository.mapper.PersonDao;
import com.example.leave.domain.person.repository.po.PersonPO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {


    @Autowired
    PersonDao personDao;

    @Override
    public void insert(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public void update(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public PersonPO findById(String id) {
        var byId = personDao.findById(id);
        if (byId.isPresent()) {
            var personPO = byId.get();
            return personPO;
        } else {
            return null;
        }
    }

    @Override
    public PersonPO findLeaderByPersonId(String personId) {
        return personDao.findLeaderByPersonId(personId);
    }

}
