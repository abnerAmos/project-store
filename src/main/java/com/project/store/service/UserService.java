package com.project.store.service;

import com.project.store.exceptions.DatabaseException;
import com.project.store.exceptions.ResourceNotFoundException;
import com.project.store.model.User;
import com.project.store.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User user) {
        try {
            User request = userRepository.getReferenceById(id); /* Similar a uma classe "userRequest",
             *  ao monta um objeto com get e set para armazenar os dados que recebemos externamente. */
            updateData(request, user);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User request, User user) {
        request.setName(user.getName());
        request.setEmail(user.getEmail());
        request.setPhone(user.getPhone());
    }
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
