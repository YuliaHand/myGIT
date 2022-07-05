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

WebUI.callTestCase(findTestCase('SmallProject1_Version1/TC03_UserSuccessCheckout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('5. PopUp_OrderSummary/Button_Continue'))

WebUI.click(findTestObject('3. Payment/Payment_CC/a_CreditDebit CardPay with Visa, MasterCard, JCB, or Amexpromo'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_CC/Verify_CreditDebitCard'), 'Credit/Debit Card')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_CC/Verify_Amount'), '15,000')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_CC/Verify_OrderID_Promo'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_CC/Promo_10Rupiah'), 0)

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_CC/Promo_10Persen'), 0)

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_CC/Promo_MasterCard'), 0)

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_CC/Promo_Installment'), 0)

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_CC/Promo_Midtrans'), 0)

String placeholderemail = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/Verify_EmailPromo'), 
    'placeholder')

String placeholdernohp = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/Verify_PhonePromo'), 
    'placeholder')

//WebUI.clearText(findTestObject('3. Payment/Payment_CC/Verify_PhonePromo'))
WebUI.click(findTestObject('3. Payment/Payment_CC/Verify_PhonePromo'))

System.out.println(placeholdernohp)

WebUI.verifyEqual(placeholderemail, 'budi@utomo.com')

WebUI.verifyEqual(placeholdernohp, '+6281234567890')

String textSuccess1 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextBlack_CardNumber'), 'class')

String textSuccess2 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextBlack_ExpiryDate'), 'class')

String textSuccess3 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextBlack_CVV'), 'class')

WebUI.click(findTestObject('3. Payment/Payment_CC/Button_PayNow'))

String textFailed1 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextRed_CardNumber'), 'class')

String textFailed2 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextRed_ExpiryDate'), 'class')

String textFailed3 = WebUI.getAttribute(findTestObject('3. Payment/Payment_CC/TextRed_CVV'), 'class')

WebUI.verifyNotMatch(textSuccess1, textFailed1, false)

WebUI.verifyNotMatch(textSuccess2, textFailed2, false)

WebUI.verifyNotMatch(textSuccess3, textFailed3, false)

WebUI.scrollToElement(findTestObject('3. Payment/Payment_CC/Verify_CCField'), 5)

