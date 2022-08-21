package tech.abb.phonebook.handler

import spock.lang.Specification
import tech.abb.phonebook.exception.UserNotFoundException


class WebExceptionHandlerTest extends Specification {
    private WebExceptionHandler handler

    def setup(){
        handler = new WebExceptionHandler()
    }

    def "handleNotFoundException"(){
        given:
        def ex = new UserNotFoundException("msg")

        when:
        def result = handler.handleNotFoundException(ex)

        then:
        result == "msg"
    }
}
