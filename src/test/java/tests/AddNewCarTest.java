package tests;

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

    @Test
    public void addNewCarSuccess(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Car car = Car.builder()
                .address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00" + i)
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car")
                .build();

        logger.info("Tests start with car ---> "+car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("D:\\QA_TelRan\\iLCarro\\auto2.jpeg");//attach
        app.car().submitCar();
        Assert.assertEquals(app.car().checkMessageAddCar(), "Car added");
        app.car().selectSearchCar();



    }

}
