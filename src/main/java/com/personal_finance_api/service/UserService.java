package com.personal_finance_api.service;

import com.personal_finance_api.database.model.UserEntity;
import com.personal_finance_api.database.repository.IUserRepository;
import com.personal_finance_api.dto.UserRequest;
import com.personal_finance_api.dto.UserResponse;
import com.personal_finance_api.exception.BadRequestException;
import com.personal_finance_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public List<UserResponse> findAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    public UserResponse findUserById(Integer id) throws NotFoundException {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public void createUser(UserRequest userRequest) throws BadRequestException {

        UserEntity user = userRepository.findByEmail(userRequest.getEmail())
                .orElse(null);

        if (user != null) {
            throw new BadRequestException("Já existe um usuário com este e-mail");
        }

        userRepository.save(UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build());
    }

    public void deleteUserById(Integer id) throws NotFoundException{

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));



        userRepository.delete(user);
    }

    public void updateUser(Integer id, UserRequest userUpdate) throws NotFoundException {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        user.setName(userUpdate.getName());
        user.setEmail(userUpdate.getEmail());

        userRepository.save(user);
    }

}
