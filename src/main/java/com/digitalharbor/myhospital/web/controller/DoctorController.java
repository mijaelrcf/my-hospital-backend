package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.DoctorDomain;
import com.digitalharbor.myhospital.domain.PatientDomain;
import com.digitalharbor.myhospital.domain.service.DoctorService;
import com.digitalharbor.myhospital.domain.service.PatientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    @ApiOperation("Get all doctors")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<DoctorDomain>> getAll() {
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search doctor by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<DoctorDomain> get(@PathVariable("id") int id) {
        return doctorService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<DoctorDomain> save (@RequestBody DoctorDomain doctorDomain) {
        return new ResponseEntity<>(doctorService.save(doctorDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (doctorService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
