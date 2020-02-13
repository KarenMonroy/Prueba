package com.karen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class loginTest {

    @Test
    public void runAllTests() {
        Class<?>[] classes = { Chrome.class, Firefox.class };
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }


    public static class Chrome {

        private WebDriver driver;

        @Before
        public void setUp() {
            String pathDriver = "/prueba/drivers";
            System.setProperty("chromedriver", pathDriver);

            driver = new ChromeDriver();

        }

        @Test
        public void login() {
            driver.navigate().to("http://automationpractice.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver.findElement(By.id("email")).sendKeys("automationpractice-test@gmail.com");
            driver.findElement(By.id("passwd")).sendKeys("automationpractice_test@123");
            driver.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver.findElement(By.xpath("//*[@id='center_column']/h1"));
            Assert.assertEquals(validateLogin.getText(), "MY ACCOUNT");
        }

        @Test
        public void loginFakeUser() {
            driver.navigate().to("http://automationpractice.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver.findElement(By.id("email")).sendKeys("automationpractice@gmail.com");
            driver.findElement(By.id("passwd")).sendKeys("automationpractice_test@123");
            driver.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
            Assert.assertEquals(validateLogin.getText(), "There is 1 error");

        }

        @Test
        public void loginFakePassword() {
            driver.navigate().to("http://automationpractice.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver.findElement(By.id("email")).sendKeys("automationpractice-test@gmail.com");
            driver.findElement(By.id("passwd")).sendKeys("automationpractice@123");
            driver.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
            Assert.assertEquals(validateLogin.getText(), "There is 1 error");
        }

        @After
        public void down() {
            driver.close();
        }

    }

    public static class Firefox {

        private WebDriver driver1;

            @Before
            public void setUp() {
                String pathDriver = "/home/karen/Documentos/IdeaProjects/prueba/drivers/geckodriver";
                System.setProperty("webdriver.gecko.driver", pathDriver);

                driver1 = new FirefoxDriver();

            }

        @Test
        public void login() {
            driver1.navigate().to("http://automationpractice.com");
            driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver1.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver1.findElement(By.id("email")).sendKeys("automationpractice-test@gmail.com");
            driver1.findElement(By.id("passwd")).sendKeys("automationpractice_test@123");
            driver1.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver1.findElement(By.xpath("//*[@id='center_column']/h1"));
            Assert.assertEquals(validateLogin.getText(), "MY ACCOUNT");
        }

        @Test
        public void loginFakeUser() {
            driver1.navigate().to("http://automationpractice.com");
            driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver1.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver1.findElement(By.id("email")).sendKeys("automationpractice@gmail.com");
            driver1.findElement(By.id("passwd")).sendKeys("automationpractice_test@123");
            driver1.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver1.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
            Assert.assertEquals(validateLogin.getText(), "There is 1 error");

        }

        @Test
        public void loginFakePassword() {
            driver1.navigate().to("http://automationpractice.com");
            driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver1.findElement(By.xpath("//*[contains(@class, \"login\")]")).click();
            driver1.findElement(By.id("email")).sendKeys("automationpractice-test@gmail.com");
            driver1.findElement(By.id("passwd")).sendKeys("automationpractice@123");
            driver1.findElement(By.id("SubmitLogin")).click();

            WebElement validateLogin = driver1.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
            Assert.assertEquals(validateLogin.getText(), "There is 1 error");
        }

        @After
        public void down() {
            driver1.close();
        }

    }

}


