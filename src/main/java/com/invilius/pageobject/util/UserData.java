package com.invilius.pageobject.util;


import io.qameta.allure.Step;

public class UserData {
    private String userEmail;
    private String userPassword;

    public UserData (String userEmail, String userPassword) {
        this.userEmail=userEmail;
        this.userPassword=userPassword;
    }

    @Step
    public String getUserEmail() {return this.userEmail;}

    @Step
    public String getUserPassword() {return  this.userPassword;}

//    public void userDataLoginClick(String userDataEmailInput, String userDataPasswordInput) {
//        userDataEmail.click();
//        userDataEmail.clear();
//        userDataEmail.sendKeys(userDataEmailInput);
//
//        userDataPassword.click();
//        userDataPassword.clear();
//        userDataPassword.sendKeys(userDataPasswordInput);
//
//        LoginBtnClick();
//    }
//
//    public DashboardPage LoginBtnClick() {
//        getLoginBtn.click();
//        return page(DashboardPage.class);
//    }
//
////    public UserData(String userEmail, String userPassword) {
////        this.userEmail = userEmail;
////        this.userPassword = userPassword;
////    }
//
//    public String getUserEmail() {
//        return this.userEmail;
//    }
//
//    public String getUserPassword() {
//        return this.userPassword;
//    }
//
}
