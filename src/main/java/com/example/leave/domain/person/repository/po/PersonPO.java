package com.example.leave.domain.person.repository.po;

import com.example.leave.domain.person.entity.valueobject.PersonStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonPO {

    @Id
    private String personId;
    private String personName;
    private Date createTime;
    private Date lastModifyTime;
    @Enumerated(EnumType.STRING)
    private PersonStatus status;
}
