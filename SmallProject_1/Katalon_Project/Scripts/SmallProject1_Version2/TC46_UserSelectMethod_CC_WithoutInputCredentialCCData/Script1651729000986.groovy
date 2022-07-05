import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.xpath.XPath as XPath
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

WebUI.callTestCase(findTestCase('SmallProject1_Version2/TC32_UserSuccessCheckout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Title_CC'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Logo_CC'))

WebUI.click(findTestObject('4. Payment/Payment_CC/a_CreditDebit CardPay with Visa, MasterCard, JCB, or Amexpromo'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/Header_CreditDebitCard'), 'Credit/debit card')

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_Installment'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_10Persen'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_Midtrans'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_MasterCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_10Rupiah'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/No_Promo'), FailureHandling.STOP_ON_FAILURE)

String fieldSuccess1 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldBlack_CardNumber'), 
    'xpath')

String fieldSuccess2 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldBlack_ExpirationDate'), 
    'xpath')

String fieldSuccess3 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldBlack_CVV'), 'xpath')

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CardNumber'), ' ')

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_ExpireDate'), ' ')

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CVV'), ' ')

WebUI.click(findTestObject('4. Payment/Payment_CC/Click_Random'))

String fieldFailed1 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldRed_CardNumber'), 
    'xpath')

String fieldFailed2 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldRed_ExpirationDate'), 
    'xpath')

String fieldFailed3 = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldRed_CVV'), 'xpath')

WebUI.verifyNotMatch(fieldSuccess1, fieldFailed1, false)

WebUI.verifyNotMatch(fieldSuccess2, fieldFailed2, false)

WebUI.verifyNotMatch(fieldSuccess3, fieldFailed3, false)

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/TextFailed_CardNumber'), 'Make sure your card number are correct.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/TextFailed_ExpirationDate'), 'Invalid expiration detail.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/TextFailed_CVV'), 'Invalid CVV.')

WebUI.verifyElementNotVisibleInViewport(findTestObject('5. PopUp Detail/Button_PayNow'), 0)

WebUI.closeBrowser()

