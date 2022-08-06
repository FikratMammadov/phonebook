package tech.abb.phonebook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.abb.phonebook.model.enums.EOperationStatus;
import tech.abb.phonebook.model.enums.EOperationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private Integer userId;
    private EOperationType operationType;
    private EOperationStatus operationStatus;
}
