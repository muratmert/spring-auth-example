package com.secfi.authexample.service;

import com.secfi.authexample.model.AppUser;
import com.secfi.authexample.model.AppUserRole;
import com.secfi.authexample.repository.UserRepository;
import com.secfi.authexample.security.JwtTokenProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    public void it_should_sigIn_successfully(){
        //arrange
        AppUser user = new AppUser();
        ArrayList<AppUserRole> roles = new ArrayList<>();
        roles.add(AppUserRole.ROLE_ADMIN);
        user.setUserRoles(roles);

        given(userRepository.findByUsername("murat")).willReturn(user);
        given(jwtTokenProvider.createToken("murat",roles)).willReturn("token");
        //act
        String token = userService.signin("murat", "pass");
        //assert
        assertNotNull(token);
    }
}