package com.secfi.authexample.controller;

import com.secfi.authexample.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;
}
