package com.gicore.common.auth;

import com.gicore.common.common.user.CommonUserService;
import com.gicore.common.config.JwtService;
import com.gicore.common.token.Token;
import com.gicore.common.token.TokenRepository;
import com.gicore.common.token.TokenType;
import com.gicore.common.common.user.Role;
import com.gicore.common.common.user.User;
import com.gicore.common.common.user.CommonUserRepository;
import com.gicore.common.util.userinfo.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final CommonUserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CommonUserService commonUserService;

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        UserInfo userInfo = new UserInfo();
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        var user = User.builder()
                .user_id(request.getUser_id())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .office_code(request.getOffice_code())
                .system_create_userid(userInfo.getUserEmail())
                .system_create_date(timestamp)
                .user_name(request.getUser_name())
                .tel(request.getTel())
                .address(request.getAddress())
                .address_detail(request.getAddress_detail())
                .postal_code(request.getPostal_code())
                .build();
        var jwtToken = jwtService.generateToken(user);
        repository.save(user);

        var token = Token.builder()
                .token(jwtToken)
                .tokenType(TokenType.AUTHORIZATION)
                .user(user)
                .build();
        tokenRepository.save(token);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
