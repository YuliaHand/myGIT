package TS01_verifCreateAnAccount;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TC04_userCreateAccWithoutInputData extends listener {

    @Test
    public void createWithoutInputEmail() throws InterruptedException{

        // TC04 - USER CREATE AN ACCOUNT WITHOUT INPUT EMAIL

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected","Small Project QA13",titlePage);

        //2. userClickSignInButton
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]")).click();

        //3. userIsDirectedToAccountAuthenticationPage
        String expectedURL = "http://qa.cilsy.id:8080/en/login?back=my-account";
        String actualURL = driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected",expectedURL,actualURL);

        // 4. userInputExistingEmailAddressOnCreateAnAccountAuthentication
        driver.findElement(By.id("email_create")).sendKeys(" ");

        //5. User click Create an Account button
        driver.findElement(By.id("SubmitCreate")).click();

        //6. Show error message
        Thread.sleep(3000);
        String expAlert = "Invalid email address.";
        String actAlert = driver.findElement(By.id("create_account_error")).getText();

        Assert.assertEquals("Error Message not as Expected",expAlert,actAlert);
    }

}
