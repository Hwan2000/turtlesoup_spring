package com.turtlesoup.backend.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public interface OAuthProviderService {
    // 유저 등록
    void registerUser(Map<String, Object> attributes);
    // OAuth 인증 객체 생성
    OAuth2User createOAuth2User(Map<String, Object> attributes);
}
