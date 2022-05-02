package manager;


import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openRegistrationForm(){
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void submit() {
        click(By.cssSelector("button[type='submit']"));
    }
    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffSet= rect.getWidth()/2;
        int yOffSet = rect.getHeight()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).moveByOffset(-xOffSet,-yOffSet).click().release().perform();


    }


}
