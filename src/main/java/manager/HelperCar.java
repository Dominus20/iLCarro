package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperCar extends HelperBase{

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
        //click(By.cssSelector("[href='/let-car-work']"));
    }

    public void fillCarForm(Car car) {
        type(By.id(), car.getMake());
        type(By.id(), car.getModel());
        type(By.id(), car.getYear());
        type(By.id(), car.Engine());

        //fuel + gear+ wd---> select

        type(By.id(), car.getMake());
    }

    public void submitCarForm() {
    }
}
