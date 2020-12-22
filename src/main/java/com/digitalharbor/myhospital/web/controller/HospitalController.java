package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.dto.HospitalDto;
import com.digitalharbor.myhospital.domain.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping()
    @ApiOperation("Get all hospitals")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<HospitalDto>> getAll() {
        return new ResponseEntity<>(hospitalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search hospital by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<HospitalDto> get(@PathVariable("id") int id) {
        return hospitalService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<HospitalDto> save (@RequestBody HospitalDto hospital) {
        return new ResponseEntity<>(hospitalService.save(hospital), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HospitalDto> update (@RequestBody HospitalDto hospital) {
        return new ResponseEntity<>(hospitalService.update(hospital), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (hospitalService.delete(id)) {
            return new ResponseEntity(id, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
