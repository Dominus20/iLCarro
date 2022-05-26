package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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

       type(By.id("fuelConsumption"), car.getFuelConsumption());
//type(By.cssSelector("input[class='ng-pristine ng-invalid ng-touched']"), car.getCarRegNumber());
       type(By.id("serialNumber"), car.getCarRegNumber());
       type(By.id("price"), car.getPrice());
       type(By.id("distance"), car.getDistanceIncluded());
  //   type(By.cssSelector("input[class='feature-input']"), car.getFeatures());
       type(By.cssSelector("input[placeholder='Type feature']"), car.getFeatures());
       type(By.id("about"), car.getAbout());
////


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

    public void submitCar() {
        new WebDriverWait(wd,15).until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[text()='Submit']"))));
        click(By.xpath("//button[text()='Submit']"));
    }

    public void attachPhoto(String link){
        wd.findElement(By.id("photos")).sendKeys(link);

    }
    public String checkMessageAddCar() {
        // pause(1000);
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container h1")).getText();
    }

    public void selectSearchCar() {
        click(By.xpath("//*[text()='Search cars']"));
    }
}
