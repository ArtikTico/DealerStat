package by.stankevich.artemiy.finalproject.dealerstat.entity;

public enum UserRole {
    ADMIN("Has full access"),
    TRADER("Registered, and approved by ADMIN");

    private String info;

    UserRole(String info) {
        this.info = info;
    }
    //TRADER -> ADMIN
}
