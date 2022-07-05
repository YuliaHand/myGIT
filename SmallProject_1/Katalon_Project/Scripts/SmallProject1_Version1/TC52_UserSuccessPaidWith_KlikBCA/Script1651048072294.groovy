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

WebUI.verifyElementText(findTestObject('3. Payment/a_SelectPaymentHeader'), 'Select Payment')

WebUI.click(findTestObject('3. Payment/Payment_KlikBCA/Button_KlikBCA'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_KlikBCA/Header_KlikBCA'), 'KlikBCA')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_KlikBCA/Verify_AmountKlikBCA'), '20,000')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_KlikBCA/Verify_OrderIDKlikBCA'))

WebUI.setText(findTestObject('3. Payment/Payment_KlikBCA/Field_KlikBCAUserID'), '12345')

WebUI.verifyElementClickable(findTestObject('3. Payment/Payment_KlikBCA/Button_SeeInstructionKlikBCA'))

WebUI.click(findTestObject('3. Payment/Payment_CC/Button_PayNow'))

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_KlikBCA/TimeOfPayment'), 0)

WebUI.click(findTestObject('3. Payment/Payment_KlikBCA/Button_CompletePayment'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_KlikBCA/Verify_TotalRp 20,000'), 'Rp 20,000')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_KlikBCA/Verify_FinishYourTransaction'), 'Finish your transaction by opening www.klikbca.com in a new tab')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_KlikBCA/Verify_YoullBeRedirected'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('3. Payment/Payment_CC/a_Done'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment1'), 'We\'ve booked your payment.')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment2'), 'Please continue as instructed.')

