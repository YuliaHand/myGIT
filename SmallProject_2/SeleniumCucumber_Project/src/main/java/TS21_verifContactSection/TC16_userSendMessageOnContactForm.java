package TS21_verifContactSection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TC16_userSendMessageOnContactForm {

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
    public void sendMessageOnContactForm() throws InterruptedException {

        // TC16 - USER SEND MESSAGE ON CONTACT FORM BOX

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected", "Small Project QA13", titlePage);

        //2. User click navigation menu
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[2]/button")).click();

        //3. Click dropdown 'Contact'
        driver.findElement(By.xpath("//*[@id=\"menu_cont\"]/div/div/div[2]/ul[1]/li[8]/a")).click();

        String expURL = "http://qa.cilsy.id:8080/en/contact-us";
        String actURL = driver.getCurrentUrl();

        Assert.assertEquals(expURL,actURL);

        //4. User choose subject
        driver.findElement(By.xpath("//*[@id=\"contact_type\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/div[2]/form/div[1]/div/div/ul/li[1]")).click();
        driver.findElement(By.id("email")).sendKeys("yulia123@test.com");
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("hai kakak");
        driver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span")).click();

        //5. Success send a message
        String smessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        String expectedmess = "Your message has been successfully sent to our team.";
        System.out.println("Alert Message: " +smessage);

        Assert.assertEquals(smessage,expectedmess);

    }

}
