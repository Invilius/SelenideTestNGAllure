import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.invilius.pageobject.*;
import com.invilius.pageobject.util.CardData;
import com.invilius.pageobject.util.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.*;


public class Test {

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser = "chrome";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @org.testng.annotations.Test
    public void loginAsRegisteredUser() {
            LoginPage login = open("https://app.geteasyqa.com/users/sign_in", com.invilius.pageobject.LoginPage.class);
        UserData UserData = new UserData("runtasagley@gmail.com","Runtasforeasyqa");
        login.enterLoginAndPass(UserData.getUserEmail(), UserData.getUserPassword());
        DashboardPage dashboardPage = login.clickLoginButton();
        dashboardPage.checkUserAuthorized();


    }

    @org.testng.annotations.Test
    public void openProjects() {
        LoginPage LoginPage = open("https://app.geteasyqa.com/users/sign_in", com.invilius.pageobject.LoginPage.class);
        LoginPage.enterLoginAndPass("runtasagley@gmail.com", "Runtasforeasyqa");
        DashboardPage dashboardPage = LoginPage.clickLoginButton();
        dashboardPage.checkUserAuthorized();
        ProjectPage projectPage = dashboardPage.openMyProjects();
        projectPage.checkProjectPage();
    }

    @org.testng.annotations.Test
    public void createCard() {
        CardData issue = new CardData("Newcardname1", "test description1");
        UserData UserData = new UserData("runtasagley@gmail.com","Runtasforeasyqa");
        LoginPage LoginPage = open("https://app.geteasyqa.com/users/sign_in", com.invilius.pageobject.LoginPage.class);
        LoginPage.enterLoginAndPass(UserData.getUserEmail(), UserData.getUserPassword());
        DashboardPage dashboardPage = LoginPage.clickLoginButton();
        dashboardPage.checkUserAuthorized();
        ProjectPage projectPage = dashboardPage.openMyProjects();
        projectPage.checkProjectPage();
        ProjectDashboardPage projectDashboardPage = projectPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickAddNewIssue();
        issuesPage.addNewIssue(issue.getCardName(), issue.getCardDescription(), "Medium");
        issuesPage.checkIssueAdded(issue.getCardName());




    }


    @AfterMethod
    public void tearDown() throws Exception {
        close();
    }

}
