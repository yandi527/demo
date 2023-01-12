package com.example.domain.person.repository.facade;

import com.example.domain.person.repository.po.PersonPO;


public interface PersonRepository {

    void insert(PersonPO personPO);

    void update(PersonPO personPO);

    PersonPO findById(String id);

    PersonPO findLeaderByPersonId(String personId);

}
