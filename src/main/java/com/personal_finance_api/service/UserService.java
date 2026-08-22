package com.personal_finance_api.service;

import com.personal_finance_api.database.model.UserEntity;
import com.personal_finance_api.database.repository.IUserRepository;
import com.personal_finance_api.dto.UserRequest;
import com.personal_finance_api.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

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

}
