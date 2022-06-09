package tests;

import manager.MyDataProvider;
import models.Auth;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(!app.user().isLogOutPresent()){
            app.user().login(Auth.builder()
                    .email("noa@gmail.com").password("Nnoa12345$").build());

        }
    }

 @Test(dataProvider = "carValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void addNewCarSuccess(Car car){

     int i = (int) (System.currentTimeMillis() / 1000) % 3600;
     car.setCarRegNumber("345-35-"+i);

        logger.info("Tests start with car ---> "+car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("D:\\QA_TelRan\\iLCarro\\auto2.jpeg");//attach
        app.car().submitCar();
        Assert.assertEquals(app.car().checkMessageAddCar(), "Car added");
        app.car().selectSearchCar();



    }

}
