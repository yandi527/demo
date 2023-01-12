package com.example.domain.person.repository.mapper;

import com.example.domain.person.repository.po.PersonPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonPO, String> {

    @Query(value = "select p from PersonPO  p where p.relationshipPO.personId=?1", nativeQuery = true)
    PersonPO findLeaderByPersonId(String personId);
}
