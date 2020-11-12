package by.stankevich.artemiy.finalproject.dealerstat.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    TRADER("ROLE_TRADER");

    private String info;

    UserRole(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
    //TRADER -> ADMIN
}
