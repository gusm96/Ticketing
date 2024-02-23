package com.ticketez.customerservice.domain;

public enum RoleType {
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    private String value;

    RoleType(String value) {
        this.value = value;

    }

    public String getValue() {
        return this.value;
    }
}

