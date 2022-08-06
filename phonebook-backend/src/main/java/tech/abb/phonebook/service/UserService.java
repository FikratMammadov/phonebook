package tech.abb.phonebook.service;

import org.apache.catalina.LifecycleState;
import tech.abb.phonebook.dto.AddUserRequestDto;
import tech.abb.phonebook.dto.EditUserRequestDto;
import tech.abb.phonebook.dto.UserResponseDto;
import tech.abb.phonebook.model.User;

import java.util.List;

public interface UserService {
    UserResponseDto add(AddUserRequestDto user);
    UserResponseDto edit(EditUserRequestDto user);
    UserResponseDto delete(Integer id);
    List<User> list();
}
