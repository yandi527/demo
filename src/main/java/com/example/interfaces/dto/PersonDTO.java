package com.example.interfaces.dto;

import lombok.*;

@Data
public class PersonDTO {

    private String personId;
    private String personName;
    private String createTime;
    private String lastModifyTime;
    private String status;

    public PersonDTO(String personName) {
        this.personName = personName;
    }

    public PersonDTO(String personId, String personName, String createTime, String lastModifyTime, String status) {
        this.personId = personId;
        this.personName = personName;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.status = status;
    }

    public PersonDTO() {
    }
}
