package myStepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
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

public class TS26_verifBookRoomBySearchRooms_StepDefs {

    public WebDriver driver;
    WebDriverWait wait;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    // Background
    @Given("User navigate to Landing Page")
    public void userNavigateToLandingPage() {
        driver.get("http://qa.cilsy.id:8080/en/");
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected","Small Project QA13",titlePage);
    }

    @And("User signed in to website")
    public void userSignedInToWebsite(){
        driver.findElement(By.xpath(("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span"))).click();
        driver.findElement(By.id(("email"))).sendKeys("yulia123@test.com");
        driver.findElement(By.id(("passwd"))).sendKeys("qwe123");
        driver.findElement(By.id(("SubmitLogin"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_info_acc")));
    }

    @And("User already searched a hotel")
    public void userAlreadySearchedAHotel() throws InterruptedException{
        driver.findElement(By.xpath(("//*[@id=\"center_column\"]/ul/li/a"))).click();

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"xs_room_search_form\"]/div/div[2]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);

        driver.findElement(By.id("hotel_location")).sendKeys("Aceh");
        Thread.sleep(3000);

        // Select hotel name on 'Select Hotel'
        driver.findElement(By.id("id_hotel_button")).click();
        Thread.sleep(3000);
        WebElement hotelName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul")));
        hotelName.click();
        Thread.sleep(3000);

        // Select 'Check In Date'
        driver.findElement(By.id("check_in_time")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
        WebElement dateWidgetFrom = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(27);
        dateWidgetFrom.click();

        // Select 'Check Out Date'
        driver.findElement(By.id("check_out_time")).click();
        WebElement dateWidgetTo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-state-default"))).get(29);
        dateWidgetTo.click();

        // Click button 'Search Now'
        driver.findElement(By.id("search_room_submit")).click();

        // Verify success search a hotel
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

    // TS26 - TC25
    @Given("User onfocus to the search rooms box")
    public void userOnfocusToTheSearchRoomsPage() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://qa.cilsy.id:8080/en/6-the-hotel-prime?date_from=2022-08-28&date_to=2022-08-30";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @When("^User Choose (.*) and Input Qty of Rooms$")
    public void userChooseGeneralRoomsAndInputQtyOfRooms(String RoomName) throws Throwable {
        Thread.sleep(5000);
        String X = driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/p[1]")).getText();
        Assert.assertEquals(RoomName,X);

        driver.findElement(By.xpath("//*[@id=\"cat_rm_quantity_wanted_1\"]/div/div[2]/a[1]")).click();
    }

    @And("User Click Book Now button")
    public void userClickBookNowButton() {
        driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
    }

    @And("User Click Proceed to checkout button")
    public void userClickProceedToCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        String expectedURL = "http://qa.cilsy.id:8080/en/quick-order";
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(expectedURL.equals(actualURL));
    }

    @And("User Click Proceed button on Rooms & Price Summary")
    public void userClickProceedButtonOnRoomsPriceSummary() {
        driver.findElement(By.xpath("//*[@id=\"collapse-shopping-cart\"]/div/div[2]/div[2]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse-guest-info")));
    }

    @And("User Click Proceed button on Guest Information")
    public void userClickProceedButtonOnGuestInformation() {
        driver.findElement(By.xpath("//*[@id=\"collapse-guest-info\"]/div/div[4]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opc_payment_methods")));
    }

    @And("User Check The Terms of Service checkbox")
    public void userCheckTheTermsOfServiceCheckbox() {
        WebElement cbox = driver.findElement(By.id("cgv"));
        cbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opc_payment_methods-content")));
    }

    @And("User Select pay by bank wire")
    public void userSelectPayByBankWire() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Pay by bank wire")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/form/div")));
    }

    @And("User Click I confirm my order")
    public void userClickIConfirmMyOrder() throws InterruptedException{
        Thread.sleep(3000);
        String amount = driver.findElement(By.xpath("//*[@id=\"amount\"]")).getText();
        System.out.println("amount: " +amount);

        if (amount == "4 400,00 Rp"){
            System.out.println("Silakan membayar sebesar " +amount+ "untuk book General Rooms selama 2 hari");
        } else {
            System.out.println("Terima kasih...");
        }

        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
    }

    @Then("User Successfully book a general room")
    public void userSuccessfullyBookAGeneralRoom() {
        String expectedOrder = "Confirmed";
        String actualOrder = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p[3]/span")).getText();

        Assert.assertEquals("The amount is not as expected",expectedOrder,actualOrder);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        driver.close();
    }
}
