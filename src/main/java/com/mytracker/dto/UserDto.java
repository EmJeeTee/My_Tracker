package com.mytracker.dto;
import com.mytracker.model.User;
import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String userName;
    private String userBodyWeight;
    private String userHeight;
    private String BMI;
    private String userPassword;

    public UserDto(User entity)
    {
        this.userId = entity.getId();
        this.userName = entity.getUserName();
        this.userBodyWeight = entity.getUserBodyWeight();
        this.userHeight = entity.getUserHeight();
        this.BMI = entity.getBMI();
        this.userPassword = entity.getUserPassword();
    }
}
