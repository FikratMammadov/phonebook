package tech.abb.phonebook.mapper;


import tech.abb.phonebook.dto.AddUserRequestDto;
import tech.abb.phonebook.dto.EditUserRequestDto;
import tech.abb.phonebook.model.User;

public interface UserMapper {
    User addUserRequestDtoToUser(AddUserRequestDto addUserRequestDto);
    User editUserRequestDtoToUser(EditUserRequestDto editUserRequestDto);
}
