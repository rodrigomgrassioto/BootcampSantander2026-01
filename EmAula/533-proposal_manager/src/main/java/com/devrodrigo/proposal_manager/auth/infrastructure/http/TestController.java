package com.devrodrigo.proposal_manager.auth.infrastructure.http;

import com.devrodrigo.proposal_manager.auth.infrastructure.persistence.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {
    @GetMapping
    public String test(@AuthenticationPrincipal User user) {
        return "Olá  " + user.getUsername() + " seu id é:  " + user.getId();
    }

    @GetMapping("/influencer")
    @PreAuthorize("hasRole('ROLE_INFLUENCER')") // aqui no controller aceita tanto com prefixo ROLE_ quanto sem
    public String influencer(@AuthenticationPrincipal UserDetails user) {
        return "Está em influencer. Usuário logado é: " + user.getUsername();
    }

    @GetMapping("/brand")
    @PreAuthorize("hasRole('ROLE_BRAND')") // aqui no controller aceita tanto com prefixo ROLE_ quanto sem
    public String brand(@AuthenticationPrincipal UserDetails user) {
        return "Está em brand. Usuário logado é: " + user.getUsername();
    }
}
