package myStepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class TS23_verifGuestRate_StepDef {
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
    @Given("User access to qa.cilsy.id website")
    public void userAccessToPage() {
        driver.get("http://qa.cilsy.id:8080/en/");
        String titlePage = driver.getTitle();
        assertEquals("Title is not as Expected","Small Project QA13",titlePage);
    }

    @And("User searched a hotel")
    public void userSearchaHotel(){
        driver.findElement(By.xpath(("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span"))).click();
        driver.findElement(By.id(("email"))).sendKeys("yulia123@test.com");
        driver.findElement(By.id(("passwd"))).sendKeys("qwe123");
        driver.findElement(By.id(("SubmitLogin"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_info_acc")));
    }

    // TS23 - TC15
    @Given("^User onfocus to the guest rating box$")
    public void userOnfocusToTheGuestRatingBox() throws Throwable{
        Thread.sleep(9000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_room_submit\"]")));
        WebElement guestRating = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search_room_submit\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", guestRating);
    }

    @When("User select guest rating with {int}{int} stars")
    public void userSelectGuestRatingWithStars(int arg0, int arg1) {
        WebElement ratingOne = driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[1]/div[2]/div[5]/div"));
        WebElement ratingTwo = driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[1]/div[2]/div[4]/div"));
        WebElement ratingThree = driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[1]/div[2]/div[3]/div"));
        WebElement ratingFour = driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[1]/div[2]/div[2]/div"));
        WebElement ratingFive = driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[1]/div[2]/div[1]/div"));

        ratingOne.click();
        ratingTwo.click();
        ratingThree.click();
        ratingFour.click();
        ratingFive.click();
    }

    @Then("^Show error (.*)")
    public void showErrorMessage(String message) throws Throwable{
        String actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category_data_cont\"]/div\n"))).getText();
        System.out.println(actualMessage);

        Assert.assertTrue(actualMessage.equalsIgnoreCase(message));
    }
}
