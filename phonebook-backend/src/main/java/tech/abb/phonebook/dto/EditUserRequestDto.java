package tech.abb.phonebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditUserRequestDto {
    private Integer userId;
    private String name;
    private String phone;
}
