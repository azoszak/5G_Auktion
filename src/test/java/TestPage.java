import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.fail;

public class TestPage extends TestBase {
    HomePage HomePage;

    @BeforeMethod
    public void setUp() {
        initialization();
        HomePage = new HomePage();
    }

    //@Test(priority=1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = HomePage.verifyHomePageTitle();
        Assert.assertTrue(homePageTitle.contains("Bundesnetzagentur"));
        String such = "//div[@class='singleview'][1]/h3[1]/text()[1]";
        System.out.printf(" Finde nexte Runde: %s ", driver.findElement(By.xpath(such)).getText());

    }


    public void lastRound() {
        //  String url_start = "https://www.bundesnetzagentur.de/DE/Sachgebiete/Telekommunikation/Unternehmen_Institutionen/Frequenzen/OeffentlicheNetze/Mobilfunknetze/mobilfunknetze-node.htm";
        String such = "//div[@class='singleview'][1]/h3[1]/text()[1]";
        //  driver.get(url_start);
        System.out.printf("\n Finde nexte Runde: %s ", driver.findElement(By.xpath(such)).getText());
    }

    @Test(priority = 2)
    public void read_HTML() {
        String such;
        Integer Start_Round;
        String str_nr;
        Start_Round = Integer.valueOf(prop.getProperty("Start_Round"));
        int n = driver.findElements(By.xpath("//*[@id='content']/div/div")).size();
        such = "//*[@class='frq_embedded']/div[1]/h3";
        System.out.printf(" Finde nächste Runde: %s \n ", driver.findElement(By.xpath(such)).getText());
        String s_1 = driver.findElement(By.xpath(such)).getText();
        String[] parts = s_1.split("\\s");
        //System.out.printf("Part: 3 %s", parts[3]);

        for (int i = Start_Round; i <= Integer.parseInt(parts[3]); i++) {
            str_nr = Utils.get_htmlnr(i);
            String url_html = "https://www.bundesnetzagentur.de/_tools/FrequenzXml/Auktion2019_XML/" + str_nr + ".html";
            System.out.println();
            System.out.println(url_html);
            Utils.get_2GData(url_html, i);
            Utils.get_3GData(url_html, i);
        }
        Start_Round = Integer.parseInt(parts[3]) + 1;
        Utils.UpdateProperty("Start_Round", String.valueOf(Start_Round));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }
}
