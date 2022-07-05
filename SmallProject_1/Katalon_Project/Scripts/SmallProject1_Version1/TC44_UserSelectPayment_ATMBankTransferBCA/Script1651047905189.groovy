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

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Button_ATMBankTransfer'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Header_ATMBankTransfer'), 'ATM/Bank Transfer')

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Button_BCA'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Header_BCAATM'), 'BCA ATM')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_AmountBCA'), '20,000')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_OrderIDBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Logo_BCA'))

WebUI.verifyElementClickable(findTestObject('3. Payment/Payment_ATMBankTransfer/Tab_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step1_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step2_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step3_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step4_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step5_ATMBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step6_ATMBCA'))

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Tab_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step1_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step2_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step3_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step4_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step5_KlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step6_KlikBCA'))

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Tab_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step1_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step2_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step3_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step4_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step5_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step6_MBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_Step7_MBCA'))

WebUI.setText(findTestObject('3. Payment/Payment_ATMBankTransfer/Field_InputYourEmail'), 'yulia@email.com')

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Button_SeeAccountNumber'))

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_PaymentTime'), 0)

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_AccountNumber'))

WebUI.verifyElementClickable(findTestObject('3. Payment/Payment_ATMBankTransfer/Button_DownloadInstrution'))

WebUI.click(findTestObject('3. Payment/Payment_ATMBankTransfer/Button_PleaseCompletePayment'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment1'), 'We\'ve booked your payment.')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment2'), 'Please continue as instructed.')

