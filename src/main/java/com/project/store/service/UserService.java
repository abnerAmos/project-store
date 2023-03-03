package com.project.store.service;

import com.project.store.model.User;
import com.project.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
        User request = userRepository.getReferenceById(id); /* Similar a uma classe "userRequest",
                                                             *  ao monta um objeto com get e set para armazenar os dados que recebemos externamente. */
        updateData(request, user);
        return userRepository.save(user);
    }

    private void updateData(User request, User user) {
        request.setName(user.getName());
        request.setEmail(user.getEmail());
        request.setPhone(user.getPhone());
    }
}
