package TS04_TS05_verifSignIn_SignOut;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TC01_TC16_userSignIn_SignOut {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void userSignIn() throws InterruptedException {

        // TC01 - USER SIGN IN WITH REGISTERED EMAIL ADDRESS AND VALID PASSWORD

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected", "Small Project QA13", titlePage);

        //2. userClickSignInButton
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]")).click();

        //3. userIsDirectedToAccountAuthenticationPage
        String expectedURL = "http://qa.cilsy.id:8080/en/login?back=my-account";
        String actualURL = driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected", expectedURL, actualURL);

        //4. User Input registered email
        driver.findElement(By.id("email")).sendKeys("yulia123@test.com");

        //5. User Input valid password
        driver.findElement(By.id("passwd")).sendKeys("qwe123");

        //6. Click login button
        driver.findElement(By.id("SubmitLogin")).click();

        //7. User success sign in and directed to 'My Account' dashboard
        String expectedURL2 = "http://qa.cilsy.id:8080/en/my-account";
        String actualURL2= driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected", expectedURL2, actualURL2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_info_acc\"]/span[1]")));
    }


    @Test
    public void userSignOut() throws InterruptedException {

        // TC16 - USER SUCCESS SIGN OUT

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected", "Small Project QA13", titlePage);

        //2. userClickSignInButton
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]")).click();

        //3. userIsDirectedToAccountAuthenticationPage
        String expectedURL = "http://qa.cilsy.id:8080/en/login?back=my-account";
        String actualURL = driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected", expectedURL, actualURL);

        //4. User Input registered email
        driver.findElement(By.id("email")).sendKeys("yulia123@test.com");

        //5. User Input valid password
        driver.findElement(By.id("passwd")).sendKeys("qwe123");

        //6. Click login button
        driver.findElement(By.id("SubmitLogin")).click();

        //7. User success sign in and directed to 'My Account' dashboard
        String expectedURL2 = "http://qa.cilsy.id:8080/en/my-account";
        String actualURL2= driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected", expectedURL2, actualURL2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_info_acc\"]/span[1]")));

        //8. User success sign out
        driver.findElement(By.xpath("//*[@id=\"user_info_acc\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/ul/li[3]/a\n")).click();

        String expectedURL3 = "http://qa.cilsy.id:8080/en/login?back=my-account";
        String actualURL3= driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected", expectedURL3, actualURL3);

    }

}