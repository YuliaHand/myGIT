package myStepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TS01_verifRegisterForm_StefDefs {
    private WebDriver driver;
    WebDriverWait wait;

    @Before
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    // Background
    @Given("User is in qa.cilsy.id Landing Page")
    public void userIsInQaCilsyIdLandingPage(){
        driver.get("http://qa.cilsy.id:8080/en/");
    }

    @When("User click Sign In button")
    public void userClickSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]")).click();
    }

    @Then("User is directed to account Authentication page")
    public void userIsDirectedToAccountAuthenticationPage() {
        String expectedURL = "http://qa.cilsy.id:8080/en/login?back=my-account";
        String actualURL = driver.getCurrentUrl();
        assertEquals("Actual URL is not as Expected",expectedURL,actualURL);
    }

    // TS01 - TC01
    @When("User input valid email address on Create an Account authentication")
    public void userInputValidEmailAddressOnCreateAnAccountAuthentication() {
        driver.findElement(By.id("email_create")).sendKeys("yulia@nytimes.com");
    }

    @And("User click Create an Account button")
    public void userClickCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Then("User directed to Create an Account form")
    public void userDirectedToCreateAnAccountForm() throws InterruptedException {
        Thread.sleep(3000);
        String actURL = driver.getCurrentUrl();
        String expURL = "http://qa.cilsy.id:8080/en/login?back=my-account#account-creation";

        Assert.assertEquals("URL not same with expected",expURL,actURL);

        driver.quit();

    }

    // TS01 - TC03
    @When("User input existing email address on Create an Account authentication")
    public void userInputExistingEmailAddressOnCreateAnAccountAuthentication() {
        driver.findElement(By.id("email_create")).sendKeys("yulia123@test.com");
    }

    @Then("Show error message {string}")
    public void showErrorMessage(String arg0) throws InterruptedException{
        Thread.sleep(3000);
        String expAlert = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String actAlert = driver.findElement(By.id("create_account_error")).getText();

        Assert.assertEquals("Error Message not as Expected",expAlert,actAlert);

        driver.quit();
    }

    // TS02
    @When("User leave First Name and Last Name field blank")
    public void userLeaveFirstNameAndLastNameFieldBlank() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.name("customer_firstname")).sendKeys("");
        driver.findElement(By.name("customer_lastname")).sendKeys("");
    }

    @And("User leave Email field blank")
    public void userLeaveEmailFieldBlank() {
        driver.findElement(By.id("email")).clear();
    }

    @And("User leave Password field blank")
    public void userLeavePasswordFieldBlank() {
        driver.findElement(By.id("passwd")).sendKeys("");
    }

    @And("User click Register button")
    public void userClickRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("Show error message firstname is required.")
    public void showErrorMessageFN() {
        String fnAlert = "firstname is required.";
        String actAlert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[2]")).getText();

        Assert.assertTrue(actAlert.contains(fnAlert));
    }

    @And("Show error message lastname is required.")
    public void showErrorMessageLN() {
        String lnAlert = "lastname is required.";
        String actAlert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();

        Assert.assertTrue(actAlert.contains(lnAlert));
    }

    @And("Show error message email is required.")
    public void showErrorMessageMail() {
        String mailAlert = "email is required.";
        String actAlert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[3]")).getText();

        Assert.assertTrue(actAlert.contains(mailAlert));
    }

    @And("Show error message passwd is required.")
    public void showErrorMessagePwd() {
        String pwdAlert = "passwd is required.";
        String actAlert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[4]")).getText();

        Assert.assertTrue(actAlert.contains(pwdAlert));

        driver.quit();
    }

    // @TS03-TC01
    @When("^User input valid (.*) on Create an Account authentication$")
    public void userInputValidEmail(String EmailAddress) {
        driver.findElement(By.id("email_create")).sendKeys(EmailAddress);
    }

    @And("User Select Title")
    public void userSelectTitle() {
        List<WebElement> oRadioButton = driver.findElements(By.name("id_gender"));
        int z = oRadioButton.size();
        System.out.println(z);
    }

    @And("^User Input (.*) and (.*) field blank$")
    public void userInputFirstAndLastName(String FirstName, String LastName) throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.name("customer_firstname")).sendKeys(FirstName);
        driver.findElement(By.name("customer_lastname")).sendKeys(LastName);
    }

    @And("^User Input (.*) field$")
    public void userInputPwd(String pwd) throws Throwable{
        driver.findElement(By.id("passwd")).sendKeys(pwd);
    }

    @And("$User Input Date of Birth field$")
    public void userInputDoB() {
        Select dSelect = new Select(driver.findElement(By.id("days")));
        dSelect.selectByVisibleText("14  ");

        Select mSelect = new Select(driver.findElement(By.id("months")));
        mSelect.selectByVisibleText("February ");

        Select ySelect = new Select(driver.findElement(By.id("years")));
        ySelect.selectByVisibleText("2000  ");
    }

    @And("User Check Sign up for our newsletter! and Receive special offers from our partners!")
    public void userCheckPromo() throws InterruptedException {
        WebElement cbox1 = driver.findElement(By.name("newsletter"));
        WebElement cbox2 = driver.findElement(By.name("optin"));

        cbox1.click();
        cbox2.click();

        Thread.sleep(3000);
    }

    @And("User Click Register button")
    public void userClickRegisterButtoon()  {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("User Successfully registered and auto signed in to website by Sistem")
    public void userSuccessRegisterAndSignIn(){
        String mrsMessage = "Your account has been created.";
        String actMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();

        Assert.assertEquals("Message is not as expected",mrsMessage,actMessage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_info_acc\"]/span[1]")));
        driver.quit();
    }

}
