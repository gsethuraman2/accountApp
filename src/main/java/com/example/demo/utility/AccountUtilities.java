package com.example.demo.utility;

public enum AccountUtilities {

    USER_CREATED_SUCCESS("User has been registered successfully."),
    USER_UPDATED_SUCCESS("User has been updated successfully."),
    USER_DELETED_SUCCESS("User has been deleted successfully."),
    USER_NOT_FOUND("Users not found."),
    ACCOUNT_CREATED_SUCCESS("Account has been created successfully."),
    ACCOUNT_CREATED_FAILURE("Deposit at least 10000 INR to create an account."),
    ACCOUNT_UPDATED_SUCCESS("Account has been updated successfully."),
    ACCOUNT_DELETED_SUCCESS("Account has been deleted successfully."),
    ACCOUNT_NOT_FOUND("Account not found."),
    INVALID_REQUEST("Invalid request."),
    NEW_MESSAGE("New message"),
    SERVER_ERROR("An internal server error occurred. Please try again later.");

    private final String message;

    AccountUtilities(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
