package tech.abb.phonebook.mapper.impl

import spock.lang.Specification
import tech.abb.phonebook.dto.AddUserRequestDto
import tech.abb.phonebook.dto.EditUserRequestDto
import tech.abb.phonebook.model.User

class UserMapperImplTest extends Specification {
    private UserMapperImpl mapper

    def setup(){
        mapper = new UserMapperImpl()
    }

    def "addUserRequestDtoToUser"(){
        given:
        def addUserRequestDto = new AddUserRequestDto("Fikrat","0556667788")
        def user = new User()
        user.setName(addUserRequestDto.getName())
        user.setPhone(addUserRequestDto.getPhone())

        when:
        def result = mapper.addUserRequestDtoToUser(addUserRequestDto)

        then:
        result == user
    }

    def "addUserRequestDtoToUser when dto is null"(){
        when:
        def result = mapper.addUserRequestDtoToUser(null)

        then:
        result == null
    }

    def "editUserRequestDtoToUser"(){
        given:
        def editUserRequestDto = new EditUserRequestDto(1,"Fikrat","0556667788")
        def user = new User()
        user.setUserId(editUserRequestDto.getUserId())
        user.setName(editUserRequestDto.getName())
        user.setPhone(editUserRequestDto.getPhone())

        when:
        def result = mapper.editUserRequestDtoToUser(editUserRequestDto)

        then:
        result == user
    }

    def "editUserRequestDtoToUser when dto is null"(){
        when:
        def result = mapper.editUserRequestDtoToUser(null)

        then:
        result == null
    }
}
