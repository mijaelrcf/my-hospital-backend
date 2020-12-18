package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.HospitalDomain;
import com.digitalharbor.myhospital.domain.service.HospitalService;
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
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping()
    @ApiOperation("Get all hospitals")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<HospitalDomain>> getAll() {
        return new ResponseEntity<>(hospitalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search hospital by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<HospitalDomain> get(@PathVariable("id") int id) {
        return hospitalService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<HospitalDomain> save (@RequestBody HospitalDomain hospital) {
        return new ResponseEntity<>(hospitalService.save(hospital), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (hospitalService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
