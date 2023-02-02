package com.project.store.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable("id") Long id) {
        return null;
    }
}
