package com.example.leave.domain.person.repository.facade;

import com.example.leave.domain.person.repository.po.PersonPO;
import org.springframework.stereotype.Repository;


public interface PersonRepository {

    void insert(PersonPO personPO);

    void update(PersonPO personPO);

    PersonPO findById(String id);

    PersonPO findLeaderByPersonId(String personId);

}
