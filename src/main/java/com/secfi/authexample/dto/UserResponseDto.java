package com.secfi.authexample.dto;

import com.secfi.authexample.model.AppUserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    @ApiModelProperty()
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    List<AppUserRole> appUserRoles;
}
