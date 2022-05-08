package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest {
    @BeforeMethod
    public void precondition(){
//        if(not_logged){
//            login(new User().withEmail("ddd").withPassword("fgdfgdf"));
//        }
    }

    @Test
    public void addNewCarSuccess(){
        Car car = Car.builder()
                .address("Tel Aviv")
                .build();

    }

}
