import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{


    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    //driver.findElement(By.linkText("Runde 2")).click();

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    /*
    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public void clickOnNewContactLink(){
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();

    }
    */
}
