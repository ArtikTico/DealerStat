package by.stankevich.artemiy.finalproject.dealerstat.entity;

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
