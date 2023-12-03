package com.pixelpalace.msMarketTransactions.dto.response;


public class LoginResponse {

    String message;
    Boolean status;
    Long UserId;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LoginResponse(String message, Boolean status, Long UserId) {
        this.message = message;
        this.status = status;
        this.UserId = UserId;
    }

}

