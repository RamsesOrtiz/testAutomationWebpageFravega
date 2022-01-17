package com.fravega.test.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindPage extends TestBase {

    public FindPage(WebDriver driver) {
        super(driver);
    }

    By postalCodeBoxLocator = By.className("sc-gkdBiK");
    By searchBoxLocator = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[2]/form/fieldset/div[1]/input");
    By filterByTypeLocator = By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[2]/ul/li[1]/h4/a");
    By firstBrandListLocator = By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[2]/ul/li[1]");
    By getFirstBrandName = By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[3]/ul/li[1]");
    By breadcrumbPageLocator = By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/ol/li[5]/a/span");
    By resultsList = By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[5]/ul/li");

    public String PRODUCT = PageTest._PRODUCT();

    public void closePostalCodeBox() throws InterruptedException {
        Thread.sleep(2000);
        if (isDisplayed(postalCodeBoxLocator)) {
            click(postalCodeBoxLocator);
        }
    }

    public void searchProduct() throws InterruptedException {
        Thread.sleep(2000);
        if (isDisplayed(searchBoxLocator)) {
            click(searchBoxLocator);
            type(PRODUCT, searchBoxLocator);
            submit(searchBoxLocator);
        } else {
            System.out.println("Search Box was not found");
        }
    }

    public void filterProduct() throws InterruptedException {
        Thread.sleep(2000);
        if (isDisplayed(filterByTypeLocator)) {
            click(filterByTypeLocator);
            Thread.sleep(1000);
            if (isDisplayed(firstBrandListLocator)) {
                click(firstBrandListLocator);
            } else {
                System.out.println("List of Brands was not found");
            }
        } else {
            System.out.println("Filter Product was not found");
        }
    }

    public List<WebElement> productList() {
        return itemList(resultsList);
    }

    public int sizeList() throws InterruptedException {
        Thread.sleep(1000);
        return sizeList(resultsList);
    }

    public String breadcrumb() throws InterruptedException {
        Thread.sleep(500);
        return getText(breadcrumbPageLocator);
    }

    public String brandName() throws InterruptedException {
        Thread.sleep(500);
        return getText(getFirstBrandName).substring(0, 7);
    }

    public Boolean checkTitle() throws InterruptedException {
        Boolean result = null;
        int j = 0;
        for (int i = 0; i < productList().size(); i++) {
            if (getText(productList().get(i)).contains(brandName())) {
                j++;
            }
        }
        if (j == productList().size()) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(j);
        return result;
    }
}
