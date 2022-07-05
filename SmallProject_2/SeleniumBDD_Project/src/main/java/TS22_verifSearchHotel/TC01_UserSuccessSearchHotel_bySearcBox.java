package TS22_verifSearchHotel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TC01_UserSuccessSearchHotel_bySearcBox extends listener{

    @Test
    public void successSearhHotel() throws InterruptedException {

        // TC01 - USER SUCCESSFULLY SEARCH HOTEL BY SEARCH BOX

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected", "Small Project QA13", titlePage);

        //2. User onfocus to the searchbox
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"xs_room_search_form\"]/div/div[2]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);

        //3 Input city name on 'Hotel Location'
        driver.findElement(By.id("hotel_location")).sendKeys("Aceh");

        Thread.sleep(6000);

        //4. User Select hotel name on Select Hotel field
        driver.findElement(By.id("id_hotel_button")).click();
        Thread.sleep(3000);
        WebElement hotelName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul")));
        hotelName.click();
        Thread.sleep(3000);

        //5. User Select check in and check out date
        driver.findElement(By.id("check_in_time")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        WebElement dateWidgetFrom = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(27);
        dateWidgetFrom.click();

        driver.findElement(By.id("check_out_time")).click();
        WebElement dateWidgetTo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(7);
        dateWidgetTo.click();

        //6. User Click Search Now button
        driver.findElement(By.id("search_room_submit")).click();

        //7. User directed to search rooms page
        Thread.sleep(7000);
        String t = "Search Rooms";
        // identify elements with text()
        List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'Search Rooms')]"));
        // verify list size
        if ( l.size() > 0){
            System.out.println("Text: " + t + " is present. ");
        } else {
            System.out.println("Text: " + t + " is not present. ");
        }

    }

}

