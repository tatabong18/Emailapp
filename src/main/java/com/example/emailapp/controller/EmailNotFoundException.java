package com.example.emailapp.controller;

public final class EmailNotFoundException extends Throwable {
    public EmailNotFoundException() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "EmailNotFoundException[]";
    }

}
