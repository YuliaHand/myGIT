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

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Mart/Title_Alfa'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Mart/Logo_Alfa'))

WebUI.click(findTestObject('4. Payment/Payment_Mart/Button_Alfa'))

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.verifyElementText(findTestObject('4. Payment/a_Header_Details'), 'Alfa Group')

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Desc_AllBank'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Mart/PaymentCode_IndoAlfaMart'))

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_Copy'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_Mart/IMG_PaymentBarcode'))

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Down'))

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_AmountMidtransPillow'), 'Rp20.000')

String total1 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_PopUp'), 'Rp20.000')

String total2 = WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_TotalAmount_Summary'), 'Rp20.000')

WebUI.verifyEqual(total1, total2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Name_Summary'), GlobalVariable.Name)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Addess_Summary'), GlobalVariable.Address_2)

WebUI.verifyElementText(findTestObject('5. PopUp Detail/Verify_Phone_Summary'), GlobalVariable.Phone_2)

WebUI.click(findTestObject('5. PopUp Detail/Button_Float_Up'))

WebUI.click(findTestObject('4. Payment/a_Button_HowToPay'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step1_Mart'), 'Tap Download payment info to get a copy of your unique payment details.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step2_Mart'), 'Go to the nearest Alfamart/Alfamidi/Dan+Dan store near you and show your barcode/payment code to the cashier.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step3_Mart'), 'The cashier will confirm your transaction details.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step4_Mart'), 'Confirm your payment with the cashier.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step5_Mart'), 'Once your transaction is successful, you\'ll receive the payment confirmation e-mail.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_Mart/Verify_Step6_Mart'), 'Please keep your Alfamart payment receipt in case you\'ll need further help via support.')

WebUI.click(findTestObject('4. Payment/Payment_Mart/Button_CloseThisPage'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_BookedPayment'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

