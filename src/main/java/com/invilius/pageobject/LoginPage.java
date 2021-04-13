package com.invilius.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "user_email")
    public SelenideElement login;

    @FindBy(id = "user_password")
    public SelenideElement password;

    @FindBy(name = "commit")
    public SelenideElement loginBtn;
    @Step
    public void enterLoginAndPass(String userLogin, String userPassword) {
        login.click();
        login.clear();
        login.sendKeys(userLogin);

        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }
    @Step
    public DashboardPage clickLoginButton() {
        loginBtn.click();
        return page(DashboardPage.class);
    }




}
