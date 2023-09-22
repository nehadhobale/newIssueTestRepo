package com.restar.testCases;

import com.restar.utility.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class NewIssueTest extends BaseTestClass {

    NewIssueTest() throws IOException {
        this.properties = Utils.getProperties("NewIssueTest");
    }

    @Test
    public void verify_newIssue_functionality() {
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login.doLogin(Utils.decode(properties.getProperty("username")), Utils.decode(properties.getProperty("password")));
        dashboard.openRepositories();
        repo.doSearch("rstar-test");
        String issueTitle = "Issue" + Utils.generateIssueNumber();
        project.createNewIssue(issueTitle, "New issue is created");
        Assert.assertEquals(issueTitle, issuePage.getIssueTitle(), "Issue Title is not matching");
        Assert.assertTrue(issuePage.verifyOpenStatus(), "Issue is not opened");
    }
}
