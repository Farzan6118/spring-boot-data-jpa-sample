package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/list")
public class TestList {

    @GetMapping("one-to-ten")
    public ResponseEntity<List<String>> listOneTowTen() {
        return ResponseEntity.ok(List.of("one two three four five six seven eight nine ten".split(" ")));
    }
}
