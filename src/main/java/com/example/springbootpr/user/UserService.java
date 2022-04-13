package com.example.springbootpr.user;

import com.example.springbootpr.security.ProviderType;
import com.example.springbootpr.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public int signUp(UserEntity userEntity) {
        String hashedPw = passwordEncoder.encode(userEntity.getPw());
        userEntity.setPw(hashedPw);
        userEntity.setProvider(ProviderType.LOCAL.toString());
        return mapper.insUser(userEntity);
    }
}
