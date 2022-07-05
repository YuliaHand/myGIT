import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://demo.midtrans.com/')

WebUI.click(findTestObject('3. Checkout/a_BUY NOW'))

WebUI.verifyElementPresent(findTestObject('3. Checkout/Verify_ShoppingCart'), 0)

WebUI.verifyElementText(findTestObject('3. Checkout/Verify_TotalAmount'), '20,000')

WebUI.verifyElementText(findTestObject('3. Checkout/Verify_CustomerDetail'), 'Customer Details')

WebUI.setText(findTestObject('3. Checkout/Field_Name'), GlobalVariable.Name)

WebUI.setText(findTestObject('3. Checkout/Field_Email'), GlobalVariable.Email)

WebUI.setText(findTestObject('3. Checkout/Field_Phone'), GlobalVariable.Phone)

WebUI.setText(findTestObject('3. Checkout/Field_City'), GlobalVariable.City)

WebUI.setText(findTestObject('3. Checkout/Field_Address'), GlobalVariable.Address)

WebUI.setText(findTestObject('3. Checkout/Field_PostalCode'), GlobalVariable.PostalCode)

WebUI.click(findTestObject('3. Checkout/Button_Checkout'))

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.verifyElementVisible(findTestObject('5. PopUp Detail/Time_PayWithin'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('5. PopUp Detail/Verify_OrderID_PopUp'))

WebUI.verifyElementVisible(findTestObject('3. Checkout/Verify_MethodList'))

