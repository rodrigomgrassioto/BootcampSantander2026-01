package com.devrodrigo.proposal_manager.auth.infrastructure.http;

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
    public String test(@AuthenticationPrincipal UserDetails user) {
        return "Olá = " + user.getUsername();
    }

    @GetMapping("/influencer")
    @PreAuthorize("hasRole('INFLUENCER')")
    public String influencer(@AuthenticationPrincipal UserDetails user) {
        return "Está em influencer. Usuário logado é: " + user.getUsername();
    }

    @GetMapping("/brand")
    @PreAuthorize("hasRole('BRAND')")
    public String brand(@AuthenticationPrincipal UserDetails user) {
        return "Está em brand. Usuário logado é: " + user.getUsername();
    }
}
