package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void searchPeriodCurrentMonth() {
        // 5/29/2022-5/31/2022
        app.search().fillSearchFormCurrentMonth("Haifa Israel", "6/29/2022", "6/30/2022");
        app.user().submit();

        Assert.assertTrue(app.search().isListOfCarAppeared());

    }

    @Test
    public void searchPeriodCurrentMonth2() {
        app.search().fillSearchFormCurrentMonth("Tel Aviv Israel", "7/30/2022", "8/25/2022");
        app.search().pause(500);
        app.user().submit();
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }

    @Test
    public void searchPeriodAnyDataInFuture(){
        //"06/30/2022", "10/25/2022"
        //"06/30/2022", "05/22/2023"
        // "01/10/2023", "05/22/2023"
        app.search().fillSearchFormInFuture("Haifa", "06/30/2022","05/22/2023");
        app.user().submit();
        app.search().pause(700);

        Assert.assertTrue(app.search().isListOfCarAppeared());

    }



    @AfterMethod
    public void postCondition(){
       app.search().returnToHome();
       // app.search().clear(By.id("dates"));
    }


}
