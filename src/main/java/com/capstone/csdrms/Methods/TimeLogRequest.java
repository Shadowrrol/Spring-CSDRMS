package com.capstone.csdrms.Methods;


public class TimeLogRequest {
	 private Long userId;
	    private Long timelogId;  // For logout
	    private String loginTime;
	    private String logoutTime;

	    // Getters and setters

	    public Long getUserId() {
	        return userId;
	    }
	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public Long getTimelogId() {
	        return timelogId;
	    }
	    public void setTimelogId(Long timelogId) {
	        this.timelogId = timelogId;
	    }

	    public String getLoginTime() {
	        return loginTime;
	    }
	    public void setLoginTime(String loginTime) {
	        this.loginTime = loginTime;
	    }

	    public String getLogoutTime() {
	        return logoutTime;
	    }
	    public void setLogoutTime(String logoutTime) {
	        this.logoutTime = logoutTime;
	    }
}
