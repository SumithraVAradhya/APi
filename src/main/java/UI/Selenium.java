package UI;

import Utilities.Browser_setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.IOException;
import Utilities.readproperty;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static WebDriver driver;

    public String UItemp() throws AWTException, IOException {
        // Setting browser driver/

        readproperty read_details = new readproperty();
        Properties Prop = read_details.fetch_property();


        // Creating chrome browser instance and launching it
        driver = Browser_setup.getDriver(Prop.getProperty("Browser"));
        //Setting implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Navigating to Base URL
        driver.get(Prop.getProperty("UI_URL"));
        driver.manage().window().maximize();
        //searching for a city
        driver.findElement(By.xpath("//input[@name='query']")).sendKeys(Prop.getProperty("CITY") + Keys.RETURN);
        //fetching the details of the city
        driver.findElement(By.xpath("//span[@class='text']")).click();
        // to automatically click on the ad
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(885, (int) 3464.310);
        actions.click().build().perform();

        String temp1 = driver.findElement(By.xpath("//div[contains(text(), '20') and @class='temp']")).getText();


        driver.quit();
        return temp1;



    }
}