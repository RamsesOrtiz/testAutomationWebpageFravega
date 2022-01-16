package com.fravega.test.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestBase {

    private WebDriver driver;

    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver geckoDriverConnection() {
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public List<WebElement> itemList(By locator){
        return driver.findElements(locator);
    }

    public int sizeList(By locator) {
        return driver.findElements(locator).size();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String URL) {
        driver.get(URL);
    }
}
