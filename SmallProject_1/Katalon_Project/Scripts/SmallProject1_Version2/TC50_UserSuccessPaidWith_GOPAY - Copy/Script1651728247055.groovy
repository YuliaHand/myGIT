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

WebUI.click(findTestObject('3. Payment/Payment_GOPAY/Button_GOPAY'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_GOPAY/Header_gopay'), 'GoPay')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_KlikBCA/Verify_AmountKlikBCA'), '20,000')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_KlikBCA/Verify_OrderIDKlikBCA'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Logo_Gopay'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Verify_Step1_Gopay'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Verify_Step2_Gopay'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Verify_Step3_Gopay'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Verify_Step4_Gopay'))

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_GOPAY/Verify_Step5_Gopay'))

WebUI.click(findTestObject('3. Payment/Payment_CC/Button_PayNow'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_GOPAY/Header_GopayTrxDetail'), 'GoPay/other e-Wallets')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_GOPAY/Verify_PleaseScanQR'), 'Please scan the QR code below with Gojek app.')

WebUI.verifyElementPresent(findTestObject('3. Payment/Payment_GOPAY/TimeofPayment_Gopay'), 0)

WebUI.click(findTestObject('3. Payment/Payment_GOPAY/Button_IAlreadyPaid'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_CC/Verify_TotalPrice'), 'Rp 20,000')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_CC/Verify__TransactionSuccessful'), 'Your transaction is being processed')

WebUI.verifyElementVisible(findTestObject('3. Payment/Payment_KlikBCA/Verify_YoullBeRedirected'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('3. Payment/Payment_CC/a_Done'))

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment1'), 'We\'ve booked your payment.')

WebUI.verifyElementText(findTestObject('3. Payment/Payment_ATMBankTransfer/Verify_BookedPayment2'), 'Please continue as instructed.')

