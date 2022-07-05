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

WebUI.callTestCase(findTestCase('SmallProject1_Version2/TC32_UserSuccessCheckout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_eWallet/Title_Octo'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_eWallet/Logo_Octo'))

WebUI.click(findTestObject('4. Payment/Payment_eWallet/Button_Octo'))

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.verifyElementText(findTestObject('4. Payment/a_Header_Details'), 'OCTO Clicks')

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Desc_AllBank'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Down'))

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_AmountMidtransPillow'), 'Rp20.000')

String total1 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_PopUp'), 'Rp20.000')

String total2 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_Summary'), 'Rp20.000')

WebUI.verifyEqual(total1, total2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Name_Summary'), GlobalVariable.Name)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Addess_Summary'), GlobalVariable.Address_2)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Phone_Summary'), GlobalVariable.Phone_2)

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Up'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step1_eWallet'), 'Tap Pay now and you will be redirected to OCTO Clicks page.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step2_eWallet'), 'Login to your OCTO Clicks account.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step3_eWallet'), 'Follow the instruction on the website and complete your payment.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step4_eWallet'), 'Once confirmed, your transaction will be processed online and your CIMB account balance will be deducted automatically.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step5_eWallet'), 'Transaction will be cancelled if the payment is not completed within 2 hours.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_Step6_eWallet'), 'Please make sure that there is no pop-up blocker on your browser.')

WebUI.click(findTestObject('4. Payment/Payment_eWallet/Button_PayNow'))

WebUI.delay(3)

def url = WebUI.getUrl()

WebUI.verifyEqual(url, 'https://simulator.sandbox.midtrans.com/cimb/clicks/index')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_eWallet/Verify_TotalTrx'), '20000.00')

WebUI.setText(findTestObject('4. Payment/Payment_eWallet/Field_AccID'), GlobalVariable.AccountID)

WebUI.click(findTestObject('4. Payment/Payment_eWallet/Button_Bayar'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Trx_Success'), 'Transaksi Sukses')

WebUI.closeBrowser()

