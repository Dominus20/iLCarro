package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }


//    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
//        click(By.id("dates"));
//        click(By.xpath("//div[text()=' 29 ']"));
//        click(By.xpath("//div[text()=' 31 ']"));
//        pause(500);
//    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        click(By.id("dates"));
        String[] dataF = dateFrom.split("/");
        String[] dataT = dateTo.split("/");
//        click(By.xpath("//div[text()=' 29 ']"));
//        click(By.xpath("//div[text()=' 31 ']"));

        String locator = "//div[text()=' " + dataF[1] +" ']";
        click(By.xpath(locator));

        String locator2 = "//div[text()=' " + dataT[1] +" ']";
        click(By.xpath(locator2));
        pause(500);
    }

    public void fillInputCity(String city) {
        type(By.id("city"), city);
       click(By.cssSelector(".pac-item"));
       pause(500);


    }

   public boolean isListOfCarAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnToHome() {
        click(By.cssSelector(".header a[href='/']"));


    }
}
