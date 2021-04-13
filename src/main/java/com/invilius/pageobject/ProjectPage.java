package com.invilius.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProjectPage {

    @FindBy(xpath = "//h1[.='My Projects']")
    public SelenideElement projectHeader;

    @FindBy(xpath = "//a[@class='project-name']")
    public SelenideElement projectName;

    @Step
    public void checkProjectPage() {
        projectHeader.shouldBe(Condition.visible);
    }

    @Step
    public ProjectDashboardPage openProject() {
        projectName.click();
        return Selenide.page(ProjectDashboardPage.class);

    }
}
