package myStepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TS22_verifSearchHotel_StepDefs {

    private WebDriver driver;
    WebDriverWait wait;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    // Background
    @Given("^User is in qa.cilsy.id Landing Page$")
    public void userIsInQaCilsyIdLandingPage() throws Throwable{
        driver.get("http://qa.cilsy.id:8080/en/");
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected","Small Project QA13",titlePage);
    }

    @And("^User already signed in to website$")
    public void userAlreadySignedInToWebsite() throws Throwable{
        driver.findElement(By.xpath(("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span"))).click();
        driver.findElement(By.id(("email"))).sendKeys("yulia123@test.com");
        driver.findElement(By.id(("passwd"))).sendKeys("qwe123");
        driver.findElement(By.id(("SubmitLogin"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_info_acc")));
    }

    // TS22 - TC01
    @Given("^User onfocus to the searchbox$")
    public void userOnfocusToTheSearchbox() throws Throwable{
        driver.findElement(By.xpath(("//*[@id=\"center_column\"]/ul/li/a"))).click();
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"xs_room_search_form\"]/div/div[2]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);

    }

    @When("^User Input (.*) on Hotel Location field$")
    public void userInputCityNameOnHotelLocationField(String HotelLoc) throws InterruptedException {
        driver.findElement(By.id("hotel_location")).sendKeys(HotelLoc);
        Thread.sleep(6000);
    }

    @And("User Select hotel name on Select Hotel field")
    public void userSelectHotelNameOnSelectHotelField() throws InterruptedException{
        driver.findElement(By.id("id_hotel_button")).click();
        WebElement hotelName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul")));
        hotelName.click();
        Thread.sleep(3000);
    }

    @And("User Select check in and check out date")
    public void userSelectCheckInAndCheckOutDate() throws Throwable{
        driver.findElement(By.id("check_in_time")).click();
        WebElement dateWidgetFrom = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(5);
        dateWidgetFrom.click();

        driver.findElement(By.id("check_out_time")).click();
        WebElement dateWidgetTo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(7);
        dateWidgetTo.click();

    }

    @And("User Click Search Now button")
    public void userClickSearchNowButton() throws Throwable{
        driver.findElement(By.id("search_room_submit")).click();
    }

    @Then("User directed to search rooms page")
    public void userDirectedToSearchRoomsPage() throws InterruptedException{
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

    // TS22 - TC13
    @When("User does not input hotel location on Hotel Location field")
    public void userDoesNotInputHotelLocationOnHotelLocationField() {
        driver.findElement(By.id("hotel_location")).sendKeys(" ");
    }

    @And("User does not select hotel name on Select Hotel field")
    public void userDoesNotSelectHotelNameOnSelectHotelField() {
        driver.findElement(By.id("id_hotel_button")).click();
    }

    @And("User does not select check in and check out date")
    public void userDoesNotSelectCheckInAndCheckOutDate() {
        WebElement dateBox = driver.findElement(By.id("check_in_time"));
        dateBox.sendKeys(" ");

        WebElement dateBox2 = driver.findElement(By.id("check_out_time"));
        dateBox2.sendKeys(" ");
    }

    @Then("Show error, all fields color change to red")
    public void showErrorAllFieldsColorChangeToRed() {
        driver.getPageSource().contains("form-control header-rmsearch-input error_border");
        driver.getPageSource().contains("form-control header-rmsearch-input input-date hasDatepicker error_border");
    }
}
