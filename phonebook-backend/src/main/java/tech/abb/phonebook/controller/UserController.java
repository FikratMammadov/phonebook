package tech.abb.phonebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.abb.phonebook.dto.AddUserRequestDto;
import tech.abb.phonebook.dto.EditUserRequestDto;
import tech.abb.phonebook.dto.UserResponseDto;
import tech.abb.phonebook.model.User;
import tech.abb.phonebook.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> add(@RequestBody AddUserRequestDto addUserRequestDto){
        return ResponseEntity.ok(userService.add(addUserRequestDto));
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponseDto> edit(@RequestBody EditUserRequestDto editUserRequestDto){
        return ResponseEntity.ok(userService.edit(editUserRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserResponseDto> delete(@RequestParam Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userService.list());
    }
}
