package com.javaBean;

public class ManagerInfoBean {
	private String managerID;				//π‹¿Ì‘±ID
    private String managerPassword;			//√‹¬Î
    
    public ManagerInfoBean() {
    	managerID = "";
    	managerPassword = "";
    }

    public ManagerInfoBean(String managerID, String managerPassword) {
        this.managerID = managerID;
        this.managerPassword = managerPassword;
    }

    public String getManagerId() {
        return managerID;
    }
    
    public String getManagerPassword() {
        return managerPassword;
    }
    
    public void setManagerId(String managerID) {
    	this.managerID = managerID;
    }

    public void setvPassword(String managerPassword) {
    	this.managerPassword = managerPassword;
    }

}
