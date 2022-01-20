package com.fravega.test.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PageTest {

    private WebDriver driver;

    String URL = "https://www.fravega.com";

    public static String _PRODUCT() {
        return "Heladera";
    }

    FindPage findPage;

    @BeforeTest
    public void start() throws InterruptedException {
        findPage = new FindPage(driver);
        driver = findPage.chromeDriverConnection();
        findPage.visit(URL);
        driver.manage().window().maximize();
        findPage.closePostalCodeBox();
        findPage.searchProduct();
        findPage.filterProduct();
    }

    @Test
    public void testBrandExists() throws InterruptedException {
        findPage.productList();
        findPage.brandName();
        findPage.checkTitle();
        System.out.println("First brand located: " + findPage.brandName());
        System.out.println("Items in page: " + findPage.productList().size());
        Assert.assertEquals(findPage.checkTitle().booleanValue(), true);
    }

    @Test
    public void testListAsserts() throws InterruptedException {
        System.out.println("Actual: " + findPage.sizeList() + ", Expected: " + findPage.productList().size());
        Assert.assertEquals(findPage.sizeList(), findPage.productList().size());
    }

    @Test
    public void testBreadcrumb() throws InterruptedException {
        System.out.println("Breadcrumb located: " + findPage.breadcrumb());
        Assert.assertEquals(findPage.breadcrumb(), "Heladeras");
    }

    @AfterTest
    public void end() {
        driver.quit();
    }
}
