package com.pixelpalace.msMarketTransactions.util;

public enum Rol {
    USER("Usuario"),
    ADMIN("Admin");

    private final String displayName;

    Rol(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
