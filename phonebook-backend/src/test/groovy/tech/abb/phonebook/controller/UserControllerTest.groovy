package tech.abb.phonebook.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import tech.abb.phonebook.dto.AddUserRequestDto
import tech.abb.phonebook.dto.EditUserRequestDto
import tech.abb.phonebook.dto.UserResponseDto
import tech.abb.phonebook.model.enums.EOperationStatus
import tech.abb.phonebook.model.enums.EOperationType
import tech.abb.phonebook.service.UserService

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put

class UserControllerTest extends Specification {
    private UserService userService
    private UserController controller
    private MockMvc mockMvc
    def mapper = new ObjectMapper()

    def setup(){
        userService = Mock()
        controller = new UserController(userService)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def "add"(){
        given:
        def url = "/user/add"
        def addUserRequestDto = new AddUserRequestDto("Fikrat","0556667788")

        when:
        def result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(addUserRequestDto)))
                .andReturn()

        then:
        result.response.status == HttpStatus.OK.value()
    }

    def "edit"(){
        given:
        def url = "/user/edit"
        def editUserRequestDto = new EditUserRequestDto(1,"Fikrat","0556667788")

        when:
        def result = mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(editUserRequestDto)))
                .andReturn()

        then:
        result.response.status == HttpStatus.OK.value()
    }

    def "delete"(){
        given:
        def url = "/user/delete"
        def id = 12

        when:
        def result = mockMvc.perform(delete(url)
                .param("id", id.toString()))
                .andReturn()
        then:
        result.response.status == HttpStatus.OK.value()
    }

    def "list"(){
        given:
        def url = "/user/list"

        when:
        def result = mockMvc.perform(get(url))
                .andReturn()
        then:
        result.response.status == HttpStatus.OK.value()
    }
}
