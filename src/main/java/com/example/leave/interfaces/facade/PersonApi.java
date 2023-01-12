package com.example.leave.interfaces.facade;

import com.example.leave.application.service.PersonApplicationService;
import com.example.leave.domain.person.entity.Person;
import com.example.leave.infrastructure.common.api.Response;
import com.example.leave.interfaces.assembler.PersonAssembler;
import com.example.leave.interfaces.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/person")
@Slf4j

public class PersonApi {

    @Autowired
    PersonApplicationService personApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@RequestBody PersonDTO personDTO) {
        try {
            personApplicationService.create(PersonAssembler.toDO(personDTO));
            return Response.ok();
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
    }

    @PutMapping
    public Response update(@RequestBody PersonDTO personDTO) {
        try {
            personApplicationService.update(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
        return Response.ok();
    }

    @DeleteMapping("/{personId}")
    public Response delete(@PathVariable String personId) {
        personApplicationService.deleteById(personId);
        return Response.ok();
    }

    @GetMapping("/{personId}")
    public Response get(@PathVariable String personId) {
        Person person = personApplicationService.findById(personId);
        return Response.ok(PersonAssembler.toDTO(person));
    }


}
