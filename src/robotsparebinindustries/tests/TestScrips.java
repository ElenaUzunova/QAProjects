package robotsparebinindustries.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import robotsparebinindustries.pages.LoginPage;

public class TestScrips extends BaseTestClass{

    @Test
    public void LoginWithValidCredentials(){
        LoginPage login = new LoginPage(driver, wait);
        login.NavigateToUrl();
        login.Login("maria","thoushallnotpass");

        Assert.assertEquals(" ", login.AssertErrorValidationMessage());
    }


    @Test
        public void LoginWithInValidCredentials(String username){
            try {
                LoginPage login = new LoginPage(driver, wait);
                login.NavigateToUrl();
                login.Login(username, "thoushallnotpa"); // we have entered invalid password

                String expectedUrl = "https://robotsparebinindustries.com/#/";
                if (username.equals("invalid password")) {
                    Assert.assertEquals("Invalid username or password.", login.AssertErrorValidationMessage());

                }
                else if(username.equals("mari") || username.equals("thoushallnotpa")){
                    Assert.assertEquals("Invalid username or password", login.AssertErrorValidationMessage());
                }
                else {
                    Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
                }

            }
            catch (Exception e){
                //???
            }


    }
    @Test
    public void LoginWithEmptyCredentials(){
        LoginPage login = new LoginPage(driver, wait);
        login.NavigateToUrl();
        login.Login("",""); // we have entered invalid user

        Assert.assertEquals(" ", login.AssertErrorValidationMessage());
    }

    //@Tests from statistics SalesPage ????

}

