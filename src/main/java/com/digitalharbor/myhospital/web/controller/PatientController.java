package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.PatientDomain;
import com.digitalharbor.myhospital.domain.service.PatientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping()
    @ApiOperation("Get all patients")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<PatientDomain>> getAll() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search patient by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<PatientDomain> get(@PathVariable("id") int id) {
        return patientService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<PatientDomain> save (@RequestBody PatientDomain patientDomain) {
        return new ResponseEntity<>(patientService.save(patientDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (patientService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
