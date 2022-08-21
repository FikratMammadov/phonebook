package tech.abb.phonebook.service.impl

import spock.lang.Specification
import tech.abb.phonebook.dto.AddUserRequestDto
import tech.abb.phonebook.dto.EditUserRequestDto
import tech.abb.phonebook.dto.UserResponseDto
import tech.abb.phonebook.mapper.UserMapper
import tech.abb.phonebook.model.User
import tech.abb.phonebook.model.enums.EOperationStatus
import tech.abb.phonebook.model.enums.EOperationType
import tech.abb.phonebook.repository.UserRepository

class UserServiceImplTest extends Specification {
    private UserRepository userRepository
    private UserMapper userMapper
    private UserServiceImpl service

    def setup(){
        userRepository = Mock()
        userMapper = Mock()
        service = new UserServiceImpl(userRepository,userMapper)
    }

    def "add"(){
        given:
        def addUserRequestDto = new AddUserRequestDto("Fikrat","0556667788")
        def user = new User(1,"Fikrat","0556667788")
        def response = UserResponseDto.builder()
                .userId(user.getUserId())
                .operationType(EOperationType.add)
                .operationStatus(EOperationStatus.success)
                .build()

        when:
        def result = service.add(addUserRequestDto)

        then:
        1 * userRepository.save(_) >> user
        1 * userMapper.addUserRequestDtoToUser(addUserRequestDto) >> user
        result == response
    }

    def "edit"(){
        given:
        def editUserRequestDto = new EditUserRequestDto(1,"Fikrat","0556667788")
        def user = java.util.Optional.of(new User(1,"Fikrat","0556667799"))
        def editedUser = new User(1,"Fikrat","0556667788")
        def response = UserResponseDto.builder()
                .userId(editedUser.getUserId())
                .operationType(EOperationType.edit)
                .operationStatus(EOperationStatus.success)
                .build()

        when:
        def result = service.edit(editUserRequestDto)

        then:
        1 * userRepository.findByUserId(editUserRequestDto.getUserId()) >> user
        1 * userMapper.editUserRequestDtoToUser(editUserRequestDto) >> editedUser
        result == response
    }

    def "delete"(){
        given:
        def id = 12
        def user = new User(12,"Fikrat","0556667788")
        def userOptional = Optional.of(user)
        def response = UserResponseDto.builder()
                .userId(user.getUserId())
                .operationType(EOperationType.delete)
                .operationStatus(EOperationStatus.success)
                .build()

        when:
        def result = service.delete(12)

        then:
        1 * userRepository.findByUserId(id) >> userOptional
        result == response
    }

    def "list"(){
        given:
        def users = List.of(new User(12,"Fikrat","0556667788"))

        when:
        def result = service.list()

        then:
        1 * userRepository.findAll() >> users
        result == users
    }
}
