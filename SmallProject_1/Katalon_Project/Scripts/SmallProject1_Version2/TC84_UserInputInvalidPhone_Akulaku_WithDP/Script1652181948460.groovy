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

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Akulaku/Title_Akulaku'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Akulaku/Logo_Akulaku'))

WebUI.click(findTestObject('4. Payment/Payment_Akulaku/Button_Akulaku'))

WebUI.verifyElementText(findTestObject('4. Payment/a_Header_Details'), 'Akulaku')

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

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Step1_Akulaku'), 'Click Pay Now, then you will be directed to the Akulaku Payment Center page.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Step2_Akulaku'), 'Select the desired installment tenor.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Step3_Akulaku'), 'Login to your Akulaku account.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Step4_Akulaku'), 'Enter the verification code (OTP) that has been sent to your mobile number, then click Next.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Step5_Akulaku'), 'Confirm and finish your payment.')

WebUI.click(findTestObject('4. Payment/Payment_eWallet/Button_PayNow'))

WebUI.setText(findTestObject('4. Payment/Payment_Akulaku/Field_Phone_Akulaku'), '081555555555')

WebUI.click(findTestObject('4. Payment/Payment_Akulaku/Button_Next'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Akulaku/Verify_Trx_Failed'), 'Phone Number Invalid, please use 08122222222 or 08133333333')

WebUI.closeBrowser()

