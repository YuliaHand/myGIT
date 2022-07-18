package TS01_verifCreateAnAccount;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TC01_userSuccessCreateAccount extends listener{

    // @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[7]")
    // private WebElement SignIN;

    @Test
    public void createValidEmail() throws InterruptedException{

        // TC01 - USER CREATE AN ACCOUNT WITH VALID EMAIL

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

        // 4. userInputValidEmailAddressOnCreateAnAccountAuthentication
        driver.findElement(By.id("email_create")).sendKeys("yulia@nytimes.com");

        //5. User click Create an Account button
        driver.findElement(By.id("SubmitCreate")).click();

        //6. User directed to Create an Account form
        Thread.sleep(3000);
        String actURL = driver.getCurrentUrl();
        String expURL = "http://qa.cilsy.id:8080/en/login?back=my-account#account-creation";

        Assert.assertEquals("URL not same with expected",expURL,actURL);

        }

}