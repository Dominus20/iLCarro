package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
       // 5/29/2022-5/31/2022
        app.search().fillSearchFormCurrentMonth("Haifa Israel", "5/29/2022", "5/31/2022");
        app.user().submit();

        Assert.assertTrue(app.search().isListOfCarAppeared());

    }

    @Test
    public void searchPeriodCurrentMonth2(){
        app.search().fillSearchFormCurrentMonth("Tel Aviv Israel", "5/30/2022", "5/31/2022");
        app.search().pause(500);
        app.user().submit();
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }

    @Test
    public void searchPeriodDataUnFuture(){
      //  app.search().fillSearchFormInFuture("Haifa", "7/30/2022","04/22/2023");
        app.user().submit();
        app.search().pause(700);

        Assert.assertTrue(app.search().isListOfCarAppeared());

    }

    @AfterMethod
    public void postCondition(){
        app.search().returnToHome();
    }


}
