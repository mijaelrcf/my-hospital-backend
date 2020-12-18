package com.digitalharbor.myhospital.web.controller;

import com.digitalharbor.myhospital.domain.RecordDomain;
import com.digitalharbor.myhospital.domain.service.RecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping()
    @ApiOperation("Get all records")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<RecordDomain>> getAll() {
        return new ResponseEntity<>(recordService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search record by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "NOT FOUND"),
    })
    public ResponseEntity<RecordDomain> get(@PathVariable("id") int id) {
        return recordService.get(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<RecordDomain> save (@RequestBody RecordDomain recordDomain) {
        return new ResponseEntity<>(recordService.save(recordDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        if (recordService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
