package tests;

import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void loginSuccessAuth(){

        logger.info("Test start with data: \"noa@gmail.com\", \"Nnoa12345$\"");
        app.user().openLoginForm();
       // app.user().fillLoginForm("noa@gmail.com", "Nnoa12345$");
      //  app.user().fillLoginForm(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.user().fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        app.user().submit();

        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
        logger.info("Assert check message: \"Logged in success\"");
        app.user().clickOkButton();
    }
    @Test
    public void loginSuccessUser(){

        logger.info("Test start with data: \"noa@gmail.com\", \"Nnoa12345$\"");
        app.user().openLoginForm();
        // app.user().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        //  app.user().fillLoginForm(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.user().fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        app.user().submit();



        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
        logger.info("Assert check message: \"Logged in success\"");
        app.user().clickOkButton();
    }
}
