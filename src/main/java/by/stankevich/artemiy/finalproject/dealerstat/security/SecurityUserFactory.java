package by.stankevich.artemiy.finalproject.dealerstat.security;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class SecurityUserFactory {

    public static CustomUserDetails fromEntityUserToCustomUserDetails(User user) {
        return new CustomUserDetails(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getUpdatedAt(),
                user.isStatus(),
                mapToGrantedAuthorities(user.getRole().getInfo())
        );
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(String userRole) {
        List<String> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        return userRoles.stream()
                .map(s -> new SimpleGrantedAuthority(userRole))
                .collect(Collectors.toSet());
    }
}
