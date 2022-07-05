package TS12_verifBookingCart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TC03_userSuccessCheckoutRoom extends listener {

    @Test
    public void checkoutRoom() throws InterruptedException {

        // TC03 - USER CHECKOUT THE ITEM ON BOOKING CART
        // User ALready sign in to website

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

        //7. User onfocus to the searchbox
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a")).click();
        WebElement searchBox = driver.findElement(By.id("hotel_location"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);

        //8 Input city name on 'Hotel Location'
        driver.findElement(By.id("hotel_location")).sendKeys("Aceh");

        Thread.sleep(6000);

        //9. User Select hotel name on Select Hotel field
        driver.findElement(By.id("id_hotel_button")).click();
        Thread.sleep(3000);
        WebElement hotelName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul")));
        hotelName.click();
        Thread.sleep(3000);

        //10. User Select check in and check out date
        driver.findElement(By.id("check_in_time")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();

        WebElement dateWidgetFrom = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(27);
        dateWidgetFrom.click();

        driver.findElement(By.id("check_out_time")).click();
        WebElement dateWidgetTo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(28);
        dateWidgetTo.click();

        //11. User Click Search Now button
        driver.findElement(By.id("search_room_submit")).click();

        //12. User directed to search rooms page
        Thread.sleep(7000);
        String t = "Search Rooms";
        // identify elements with text()
        List<WebElement> l = driver.findElements(By.xpath("//*[contains(text(),'Search Rooms')]"));
        // verify list size
        if (l.size() > 0) {
            System.out.println("Text: " + t + " is present. ");
        } else {
            System.out.println("Text: " + t + " is not present. ");
        }

        //13. userOnfocusToTheSearchRoomsPage
        String actualURL4 = driver.getCurrentUrl();
        System.out.println("Search Room Page URL adalah :" +actualURL4);

       //14. User Click Book Now button
        driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[3]/div/div[2]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));

        //15. User Click Booking Cart
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[4]/div/a/span[1]")).click();
        String expectedURL2 = "http://qa.cilsy.id:8080/en/quick-order";
        String actualURL2 = driver.getCurrentUrl();

        Assert.assertTrue(expectedURL2.equals(actualURL2));

        //16. User Click Proceed button on Rooms & Price Summary
        driver.findElement(By.xpath("//*[@id=\"collapse-shopping-cart\"]/div/div[2]/div[2]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse-guest-info")));

        //17. User Click Proceed button on Guest Information
        driver.findElement(By.xpath("//*[@id=\"collapse-guest-info\"]/div/div[4]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opc_payment_methods")));

        //18. User Check The Terms of Service checkbox
        WebElement cbox = driver.findElement(By.id("cgv"));
        cbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opc_payment_methods-content")));

        //19. User Select payment
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Pay by bank wire")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/form/div")));

        //20. User Click I confirm my order
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();

        //21. User Successfully book a room By Booking cart
        String expectedOrder = "Your order on Small Project QA13 is complete.";
        String actualOrder = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p[1]")).getText();

        Assert.assertEquals(expectedOrder,actualOrder);

    }
}
