package TS02_verifRegisterForm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TC29_userRegisterWithTitleMr extends listener{
    @Test
    public void regisWithoutInputData() throws InterruptedException {

        // TC29 - USER REGISTER AND SELECT TITLE MR. WITH VALID DATA

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

        // 4. userInputValidEmailAddressOnCreateAnAccountAuthentication
        driver.findElement(By.id("email_create")).sendKeys("Jaya53@nytimes.com");

        //5. User click Create an Account button
        driver.findElement(By.id("SubmitCreate")).click();

        //6. User directed to Create an Account form
        Thread.sleep(3000);
        String actURL = driver.getCurrentUrl();
        String expURL = "http://qa.cilsy.id:8080/en/login?back=my-account#account-creation";

        Assert.assertEquals("URL not same with expected", expURL, actURL);

        //7. User Select Title
        List<WebElement> oRadioButton = driver.findElements(By.name("id_gender"));
        oRadioButton.get(0).click();


        //7. User Input First Name and Last Name field blank
        Thread.sleep(3000);
        driver.findElement(By.name("customer_firstname")).sendKeys("Jaya");
        Thread.sleep(3000);
        driver.findElement(By.name("customer_lastname")).sendKeys("Vijaya");


        //8. Verify Email
        WebElement emailAct = driver.findElement(By.id("email"));
        Assert.assertNotNull(emailAct);


        //9. User leave Password field blank
        driver.findElement(By.id("passwd")).sendKeys("asd123");


        //10. User click Register button
        driver.findElement(By.id("submitAccount")).click();


        //11. Successfully registered with title Mr. and directed to 'My Account' dashboard
        String mrMessage = "Your account has been created.";
        String actMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();

        Assert.assertEquals("Message is not as expected",mrMessage,actMessage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_info_acc\"]/span[1]")));

    }
}
