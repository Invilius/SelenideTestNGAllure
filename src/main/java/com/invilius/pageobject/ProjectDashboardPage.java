package com.invilius.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProjectDashboardPage {
    @FindBy(xpath = "//h2[.='Project Overview']")
    public SelenideElement projectOverview;

    @FindBy(xpath = "//span[@class='icon-issues-icon']")
    public SelenideElement issuesLink;

    @Step
    public void checkProjectDashboardPage() {
        projectOverview.shouldBe(Condition.visible);
    }

    @Step
    public IssuesPage openIssues() {
        issuesLink.click();
        return Selenide.page(IssuesPage.class);
    }
}
