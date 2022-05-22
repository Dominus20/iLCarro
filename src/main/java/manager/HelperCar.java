package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class HelperCar extends HelperBase{

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
        //click(By.cssSelector("[href='/let-car-work']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());

        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());

        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());

       /* select*/type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());

       /* select*/type(By.id("price"), car.getPrice());
       /* select*/type(By.id("distance"), car.getDistanceIncluded());
       // Features






        //fuel + gear+ wd---> select

       // type(By.id(), car.getMake());
    }

    public void select(By locator, String option) {
//        new Select(wd.findElement(By.id("fuel"))).selectByIndex(4);
//        new Select(wd.findElement(By.id("fuel"))).selectByValue("Electric");
        // new Select(wd.findElement(By.id("fuel"))).selectByVisibleText(" Electric ");
        new Select(wd.findElement(locator)).selectByValue(option);

    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        pause(500);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void submitCarForm() {
    }

    public void attachPhoto(String link){
        wd.findElement(By.id("photos")).sendKeys(link);

    }
}
