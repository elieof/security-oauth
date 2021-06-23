package com.github.elieof.security.oauth.autorization.server.config;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties for UAA-based OAuth2 security.
 */
@Component
@ConfigurationProperties(prefix = "uaa", ignoreUnknownFields = false)
@Data
public class UaaProperties {

    WebClientConfiguration webClientConfiguration = new WebClientConfiguration();

    @Data
    public static class WebClientConfiguration {
        //validity of the short-lived access token in secs (min: 60), don't make it too long
        int accessTokenValidityInSeconds = 5 * 60;
        //validity of the refresh token in secs (defines the duration of "remember me")
        int refreshTokenValidityInSecondsForRememberMe = 7 * 24 * 60 * 60;
        String clientId = "web_app";
        String secret = "changeit";
    }
}
