package ru.itmentor.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class PersonDetails implements UserDetails {
    private final User user;

    public PersonDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword(); // Return the password hash!
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement appropriate logic based on your needs
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement appropriate logic based on your needs
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement appropriate logic based on your needs
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement appropriate logic based on your needs
    }

    public User getUser() {
        return this.user;
    }
}
