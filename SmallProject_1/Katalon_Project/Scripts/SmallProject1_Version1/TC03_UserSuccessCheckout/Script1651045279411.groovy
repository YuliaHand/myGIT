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

WebUI.click(findTestObject('2. Checkout/a_BUY NOW'))

WebUI.verifyElementText(findTestObject('2. Checkout/Verify_ShoppingCart'), 'Shopping Cart  ')

WebUI.verifyElementText(findTestObject('2. Checkout/Verify_TotalAmount'), '20,000')

WebUI.verifyElementText(findTestObject('2. Checkout/Verify_CustomerDetail'), 'Customer Details')

WebUI.setText(findTestObject('2. Checkout/Field_Name'), GlobalVariable.Name)

WebUI.setText(findTestObject('2. Checkout/Field_Email'), GlobalVariable.Email)

WebUI.setText(findTestObject('2. Checkout/Field_Phone'), GlobalVariable.Phone)

WebUI.setText(findTestObject('2. Checkout/Field_City'), GlobalVariable.City)

WebUI.setText(findTestObject('2. Checkout/Field_Address'), GlobalVariable.Address)

WebUI.setText(findTestObject('2. Checkout/Field_PostalCode'), GlobalVariable.PostalCode)

WebUI.click(findTestObject('2. Checkout/Button_Checkout'))

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/a_Verify_OrderSummaryDetails'), 'Order Summary')

WebUI.verifyElementPresent(findTestObject('5. PopUp_OrderSummary/a_Verify_OrderID'), 0)

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_OrderDetails/Verify_ItemName'), 'Midtrans Pillow')

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_OrderDetails/Verify_ItemAmount'), '20,000')

WebUI.click(findTestObject('5. PopUp_OrderSummary/Tab_ShippingDetails/a_shipping details'))

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_ShippingDetails/Verify_Name'), GlobalVariable.Name)

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_ShippingDetails/Verify_PhoneNumber'), GlobalVariable.Phone_2)

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_ShippingDetails/Verify_Email'), GlobalVariable.Email)

WebUI.verifyElementText(findTestObject('5. PopUp_OrderSummary/Tab_ShippingDetails/Verify_Address'), GlobalVariable.Address_2)

