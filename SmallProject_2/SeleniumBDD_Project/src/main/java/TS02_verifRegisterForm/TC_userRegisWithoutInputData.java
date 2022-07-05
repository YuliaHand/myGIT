package TS02_verifRegisterForm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TC_userRegisWithoutInputData extends listener {

    @Test
    public void regisWithoutInputData() throws InterruptedException {

        // TC01 - USER REGISTER WITHOUT INPUT DATA

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
        driver.findElement(By.id("email_create")).sendKeys("yuliaya@nytimes.com");

        //5. User click Create an Account button
        driver.findElement(By.id("SubmitCreate")).click();

        //6. User directed to Create an Account form
        Thread.sleep(3000);
        String actURL = driver.getCurrentUrl();
        String expURL = "http://qa.cilsy.id:8080/en/login?back=my-account#account-creation";

        Assert.assertEquals("URL not same with expected", expURL, actURL);

        //7. User leave First Name and Last Name field blank
        Thread.sleep(3000);
        driver.findElement(By.name("customer_firstname")).sendKeys("");
        driver.findElement(By.name("customer_lastname")).sendKeys("");

        //8. User leave Email field blank
        driver.findElement(By.id("email")).clear();

        //9. User leave Password field blank
        driver.findElement(By.id("passwd")).sendKeys("");

        //10. User click Register button
        driver.findElement(By.id("submitAccount")).click();

        //11. Show error message firstname is required.
        String fnAlert = "firstname is required.";
        String actAlert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[2]")).getText();

        Assert.assertTrue(actAlert.contains(fnAlert));


        //12. Show error message lastname is required.
        String lnAlert = "lastname is required.";
        String actAlert2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();

        Assert.assertTrue(actAlert2.contains(lnAlert));


        //13. Show error message email is required.
        String mailAlert = "email is required.";
        String actAlert3 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[3]")).getText();

        Assert.assertTrue(actAlert3.contains(mailAlert));


        //14. Show error message passwd is required.
        String pwdAlert = "passwd is required.";
        String actAlert4 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[4]")).getText();

        Assert.assertTrue(actAlert4.contains(pwdAlert));
    }
}