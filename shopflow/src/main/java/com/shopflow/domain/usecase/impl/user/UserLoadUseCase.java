package com.shopflow.domain.usecase.impl.user;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.domain.model.Users;
import com.shopflow.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

@DomainUseCase
@DomainTransactional
public class UserLoadUseCase implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Users usuario) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));
    }
}
