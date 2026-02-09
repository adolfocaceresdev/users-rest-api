package com.spring.system.service;

import com.spring.system.dto.UserCreateDTO;
import com.spring.system.dto.UserUpdateDTO;
import com.spring.system.dto.UserResponseDTO;
import com.spring.system.entity.User;
import com.spring.system.exception.ResourceNotFoundException;
import com.spring.system.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserResponseDTO save(UserCreateDTO dto) {
        User user = modelMapper.map(dto, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserResponseDTO.class);
    }

    public UserResponseDTO update(Long id, UserUpdateDTO dto) {
        User userDB = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        userDB.setFirstName(dto.getFirstName());
        userDB.setLastName(dto.getLastName());
        userDB.setEmail(dto.getEmail());
        userDB.setPassword(dto.getPassword());

        User updated = userRepository.save(userDB);
        return modelMapper.map(updated, UserResponseDTO.class);
    }

    public void deleteById(Long id) {
        User userDB = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        userRepository.delete(userDB);
    }
}