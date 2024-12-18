package com.turtlesoup.backend.service.impl;

import com.turtlesoup.backend.config.security.PrincipalDetails;
import com.turtlesoup.backend.entity.enums.OAuthMethodEnum;
import com.turtlesoup.backend.entity.UserEntity;
import com.turtlesoup.backend.repository.UserRepository;
import com.turtlesoup.backend.service.OAuthProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("google")
@RequiredArgsConstructor
public class GoogleOAuthProviderServiceImpl implements OAuthProviderService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(Map<String, Object> attributes) {
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);

        if(userEntityOptional.isEmpty()){
            UserEntity userEntity = new UserEntity(email, OAuthMethodEnum.GOOGLE, null, name);
            userRepository.save(userEntity);
        }
    }

    @Override
    public OAuth2User createOAuth2User(Map<String, Object> attributes) {
        //attributes.put("ownKey", OAuthMethodEnum.GOOGLE.toString()+attributes.get("sub"));

        String email = (String) attributes.get("email");
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error in createGoogleAuthProvider")
        );

        return new PrincipalDetails(userEntity, attributes);
    }
}
