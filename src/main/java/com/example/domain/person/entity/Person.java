package com.example.domain.person.entity;

import com.example.domain.person.entity.valueobject.PersonStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Person {

    String personId;
    String personName;
    Date createTime;
    Date lastModifyTime;
    PersonStatus status;

    public Person create(){
        this.createTime = new Date();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person enable(){
        this.lastModifyTime = new Date();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person disable(){
        this.lastModifyTime = new Date();
        this.status = PersonStatus.DISABLE;
        return this;
    }
}
