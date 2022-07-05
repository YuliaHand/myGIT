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

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/Header_CreditDebitCard'), 'Credit/debit card')

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_Installment'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_10Persen'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_Midtrans'))

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_MasterCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_10Rupiah'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/No_Promo'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CardNumber'), findTestData('Success_CardNumber').getValue(1, 1))

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_ExpireDate'), findTestData('Success_CardNumber').getValue(2, 1))

WebUI.setText(findTestObject('4. Payment/Payment_CC/Field_CVV'), findTestData('Success_CardNumber').getValue(3, 1))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Banner_Visa_AfterInputCardNumber'))

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/Promo_Installment'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/Promo_10Persen'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/Promo_Midtrans'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('4. Payment/Payment_CC/Promo_MasterCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_CC/Promo_10Rupiah'), FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('4. Payment/Payment_CC/No_Promo'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Down'))

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_AmountMidtransPillow'), 'Rp20.000')

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Name_Summary'), GlobalVariable.Name)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Addess_Summary'), GlobalVariable.Address_2)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Phone_Summary'), GlobalVariable.Phone_2)

String total1 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_PopUp'), 'Rp20.000')

String total2 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_Summary'), 'Rp20.000')

//System.out.print(total1)
//System.out.print(total2)
WebUI.verifyEqual(total1, total2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Up'))

WebUI.click(findTestObject('5. PopUp Detail/Button_PayNow'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/a_IssuingBank/Verify_Amount_IssuingBank'), '20000.00')

WebUI.setEncryptedText(findTestObject('4. Payment/Payment_CC/a_IssuingBank/input_Password_PaRes'), '4tAN/DuJV7Y=')

WebUI.click(findTestObject('4. Payment/Payment_CC/a_IssuingBank/Button_OK'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/Verify_Success_TextPaymentSuccessful'), 'Payment successful')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_CC/Verify_Success_TotalPrice'), 'Rp20.000')

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Verify_Success_OrderID'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Verify_Success_Redirectingbackautomatically_in1second'))

WebUI.click(findTestObject('4. Payment/Payment_CC/Button_BackToMerchantsWeb'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_CC/Verify_ThankYou'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

