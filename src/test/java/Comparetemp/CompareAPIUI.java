package Comparetemp;

import API.API_weather;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import UI.Selenium;
import java.awt.*;
import java.io.IOException;

public class CompareAPIUI {
    @Test
    public void comparetemperature () throws AWTException, ParseException, IOException {
        Selenium temp_acc = new Selenium();
        String tempUI1 = temp_acc.UItemp();
        API_weather temp_open = new API_weather();
        double tempKelvin = temp_open.weather();
        int tempAPI = (int) (tempKelvin- 273.15);
        int tempUI = Integer.parseInt(tempUI1.replaceAll("[^\\d]",""));
        Reporter.log(tempAPI+";"+ tempUI);
        Assert.assertTrue(Math.abs(tempAPI-tempUI)<3);
    }
}
