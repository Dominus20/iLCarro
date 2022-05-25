package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void fillSearchFormInFuture(String city, String from, String to) {
        fillInputCity(city);
        selectAnyDate(from, to);
    }

    private void selectAnyDate(String dateFrom, String dateTo) {
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        click(By.id("dates"));
        int monthDiff = from.getYear() - now.getYear()==0 ? from.getMonthValue()
                - now.getMonthValue() : 12 - now.getMonthValue() + from.getMonthValue();

        //"6/30/2022", "10/25/2022"
        //"6/30/2022", "5/22/2023"
        // "1/10/2023", "5/22/2023"
        clickNextMonth(monthDiff);
        String dataLocator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(dataLocator));

        monthDiff = to.getYear()- from.getYear()==0 ? to.getMonthValue()
                - from.getMonthValue() : 12 - from.getMonthValue() + to.getMonthValue();
        clickNextMonth(monthDiff);
        dataLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(dataLocator));

    }

    private void clickNextMonth(int count) {
        for(int i = 0;i < count; i++){
            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }
}
