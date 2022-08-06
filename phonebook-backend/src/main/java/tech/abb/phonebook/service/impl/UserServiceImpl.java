package tech.abb.phonebook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.abb.phonebook.constants.Messages;
import tech.abb.phonebook.dto.AddUserRequestDto;
import tech.abb.phonebook.dto.EditUserRequestDto;
import tech.abb.phonebook.dto.UserResponseDto;
import tech.abb.phonebook.exception.UserNotFoundException;
import tech.abb.phonebook.mapper.UserMapper;
import tech.abb.phonebook.model.User;
import tech.abb.phonebook.model.enums.EOperationStatus;
import tech.abb.phonebook.model.enums.EOperationType;
import tech.abb.phonebook.repository.UserRepository;
import tech.abb.phonebook.service.UserService;

import java.util.List;



@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto add(AddUserRequestDto addUserRequestDto) {
        User user = userRepository.save(userMapper.addUserRequestDtoToUser(addUserRequestDto));
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .operationType(EOperationType.add)
                .operationStatus(EOperationStatus.success)
                .build();
    }

    @Override
    public UserResponseDto edit(EditUserRequestDto editUserRequestDto) {
        User user = userRepository.findByUserId(editUserRequestDto.getUserId())
                .orElseThrow(()->new UserNotFoundException(Messages.USER_NOT_FOUNT));
        user = userMapper.editUserRequestDtoToUser(editUserRequestDto);
        userRepository.save(user);
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .operationType(EOperationType.edit)
                .operationStatus(EOperationStatus.success)
                .build();
    }

    @Override
    public UserResponseDto delete(Integer id) {
        User user = userRepository.findByUserId(id)
                .orElseThrow(()->new UserNotFoundException(Messages.USER_NOT_FOUNT));
        userRepository.deleteUserByUserId(id);

        return UserResponseDto.builder()
                .userId(user.getUserId())
                .operationType(EOperationType.delete)
                .operationStatus(EOperationStatus.success)
                .build();
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
