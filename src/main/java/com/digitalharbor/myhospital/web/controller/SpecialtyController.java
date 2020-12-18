package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;
import com.digitalharbor.myhospital.domain.service.SpecialtyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping()
    @ApiOperation("Get all specialtys")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<SpecialtyDto>> getAll() {
        return new ResponseEntity<>(specialtyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search specialty by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<SpecialtyDto> get(@PathVariable("id") int id) {
        return specialtyService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<SpecialtyDto> save (@RequestBody SpecialtyDto specialtyDto) {
        return new ResponseEntity<>(specialtyService.save(specialtyDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (specialtyService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
