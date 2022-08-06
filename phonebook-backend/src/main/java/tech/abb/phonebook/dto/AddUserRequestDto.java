package tech.abb.phonebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestDto {
    private String name;
    private String phone;
}
