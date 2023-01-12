package com.example.interfaces.assembler;

import com.example.domain.person.entity.Person;
import com.example.domain.person.entity.valueobject.PersonStatus;
import com.example.infrastructure.util.DateUtil;
import com.example.interfaces.dto.PersonDTO;


import java.text.ParseException;

public class PersonAssembler {

    public static PersonDTO toDTO(Person person){
        PersonDTO dto = new PersonDTO();
        dto.setPersonId(person.getPersonId());
        dto.setPersonName(person.getPersonName());
        dto.setStatus(person.getStatus().toString());
        dto.setCreateTime(DateUtil.formatDateTime(person.getCreateTime()));
        dto.setLastModifyTime(DateUtil.formatDateTime(person.getLastModifyTime()));
        return dto;
    }

    public static Person toDO(PersonDTO dto) throws ParseException {
        Person person = new Person();
        person.setPersonId(dto.getPersonId());
        person.setPersonName(dto.getPersonName());
        person.setStatus(PersonStatus.valueOf(dto.getStatus()));
        person.setCreateTime(DateUtil.parseDateTime(dto.getCreateTime()));
        person.setLastModifyTime(DateUtil.parseDateTime(dto.getLastModifyTime()));
        return person;
    }
}
