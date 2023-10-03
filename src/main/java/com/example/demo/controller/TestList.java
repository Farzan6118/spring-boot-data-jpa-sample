package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TestList {

    private final UserRepository userRepository;

    @GetMapping("ping")
    public ResponseEntity<String> listOfInformation() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("one-to-ten")
    public ResponseEntity<List<String>> listOneTowTen() {
        return ResponseEntity.ok(List.of("one two three four five six seven eight nine ten".split(" ")));
    }

    @GetMapping("list/user")
    public ResponseEntity<Iterable<User>> listUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
