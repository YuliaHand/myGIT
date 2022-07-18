package TS22_verifSearchHotel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TC13_userSearchHotelWithoutInputData extends listener{

    @Test
    public void searchWithoutInputData() throws InterruptedException {

        // TC13 - USER SEARCH HOTEL WITHOUT INPUT DATA

        //0. Navigate Webapp
        driver.get("http://qa.cilsy.id:8080/en/");

        //1. Verify URL
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected", "Small Project QA13", titlePage);

        //2. User onfocus to the searchbox
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"xs_room_search_form\"]/div/div[2]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);

        //3 Input not input city name on 'Hotel Location'
        driver.findElement(By.id("hotel_location")).sendKeys("");

        Thread.sleep(6000);

        //4. User not input hotel name on Select Hotel field
        driver.findElement(By.id("id_hotel_button")).click();

        //5. User not Select check in and check out date
        WebElement dateBox = driver.findElement(By.id("check_in_time"));
        dateBox.sendKeys(" ");

        WebElement dateBox2 = driver.findElement(By.id("check_out_time"));
        dateBox2.sendKeys(" ");

        //6. User Click Search Now button
        driver.findElement(By.id("search_room_submit")).click();

        //7. Show error, all fields color change to red
        driver.getPageSource().contains("form-control header-rmsearch-input error_border");
        driver.getPageSource().contains("form-control header-rmsearch-input input-date hasDatepicker error_border");
    }

}
