package com.project.store.controller;

import com.project.store.exceptions.ResourceNotFoundException;
import com.project.store.model.User;
import com.project.store.repository.UserRepository;
import com.project.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") // Retorna o caminho URI/URL do objeto criado no Header da resposta.
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody User user) {
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
