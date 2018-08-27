package com.sap.devx.helloauthworld;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping(value = "/token")
	public @ResponseBody String root() {
		return getClientOAuthToken();
	}

	@GetMapping(value = "/me")
	public String me(Principal principal) {
		return principal.getName();
	}

	private String getClientOAuthToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
		return details.getTokenValue();
	}
}
