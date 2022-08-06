package tech.abb.phonebook.mapper.impl;

import org.springframework.stereotype.Component;
import tech.abb.phonebook.dto.AddUserRequestDto;
import tech.abb.phonebook.dto.EditUserRequestDto;
import tech.abb.phonebook.mapper.UserMapper;
import tech.abb.phonebook.model.User;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User addUserRequestDtoToUser(AddUserRequestDto addUserRequestDto) {
        if (addUserRequestDto ==null){
            return null;
        }

        User user = new User();
        user.setName(addUserRequestDto.getName());
        user.setPhone(addUserRequestDto.getPhone());
        return user;
    }

    @Override
    public User editUserRequestDtoToUser(EditUserRequestDto editUserRequestDto) {
        if (editUserRequestDto ==null){
            return null;
        }

        User user = new User();
        user.setUserId(editUserRequestDto.getUserId());
        user.setName(editUserRequestDto.getName());
        user.setPhone(editUserRequestDto.getPhone());
        return user;
    }
}
