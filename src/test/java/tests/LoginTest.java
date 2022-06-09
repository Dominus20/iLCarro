package tests;

import manager.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }

    }

    @Test(dataProvider = "loginValidDataSTR", dataProviderClass = MyDataProvider.class)
    public void loginSuccessAuth(String email, String password){


        logger.info("Name of method is loginSuccessAuth: ");
        logger.info("Test start with data: " + email + "     "+ password);
        app.user().openLoginForm();
         app.user().fillLoginForm(Auth.builder().email(email).password(password).build());
      //  app.user().fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        app.user().submit();

        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
        logger.info("Assert check message: \"Logged in success\"");
        app.user().clickOkButton();
    }


    @Test(dataProvider = "loginValidDataAuth", dataProviderClass = MyDataProvider.class, groups = {"one","web", "smoke"})
    public void loginSuccessUser(Auth auth){

        logger.info("Test start with data: \"noa@gmail.com\", \"Nnoa12345$\"");
        app.user().openLoginForm();
        app.user().fillLoginForm(auth);
       // app.user().fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        app.user().submit();



        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
        logger.info("Assert check message: \"Logged in success\"");
        app.user().clickOkButton();
    }


}
