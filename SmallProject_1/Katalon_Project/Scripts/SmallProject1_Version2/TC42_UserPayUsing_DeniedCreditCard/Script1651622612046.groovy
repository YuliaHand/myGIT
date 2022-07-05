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

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CardNumber'), findTestData('Denied_CardNumber').getValue(1, 1))

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_ExpireDate'), findTestData('Denied_CardNumber').getValue(2, 1))

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CVV'), findTestData('Denied_CardNumber').getValue(3, 1))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Banner_Visa_AfterInputCardNumber'))

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_MasterCard'), FailureHandling.STOP_ON_FAILURE)

String fieldSuccess = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldBlack_CardNumber'), 
    'xpath')

WebUI.click(findTestObject('5. PopUp Detail/Button_PayNow'))

WebUI.setEncryptedText(findTestObject('4. Payment/Payment_CC/a_IssuingBank/input_Password_PaRes'), '4tAN/DuJV7Y=')

WebUI.click(findTestObject('4. Payment/Payment_CC/a_IssuingBank/Button_OK'))

String fieldFailed = WebUI.getAttribute(findTestObject('Object Repository/4. Payment/Payment_CC/FieldRed_CardNumber'), 'xpath')

WebUI.verifyNotMatch(fieldSuccess, fieldFailed, false)

WebUI.scrollToElement(findTestObject('4. Payment/Payment_CC/FieldRed_CardNumber'), 8)

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/DeniedCard_WarningMessage'), 'Card got declined by the bank. Try using another card/payment method.')

WebUI.delay(3)

WebUI.closeBrowser()

