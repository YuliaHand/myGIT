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

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Title_BankTransfer'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Logo_BankTransfer'))

WebUI.click(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_BankTransfer'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_ATMBankTransfer/Header_BankTransfer'), 'Bank transfer')

WebUI.click(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_BRI'))

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.verifyElementText(findTestObject('4. Payment/a_Header_Details'), 'Bank BRI')

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Desc_AllBank'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/VAnumber_BRI'))

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_Copy'))

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

WebUI.verifyElementClickable(findTestObject('4. Payment/a_Button_HowToPay'))

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_HTP_ATM'))

WebUI.verifyElementPresent(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Steps_ATM'), 0)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_HTP_IB'))

WebUI.verifyElementPresent(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Steps_IB'), 0)

WebUI.verifyElementClickable(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_HTP_mBanking'))

WebUI.verifyElementPresent(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Steps_mBanking'), 0)

WebUI.click(findTestObject('4. Payment/Payment_ATMBankTransfer/Button_IHavePaid'))

WebUI.verifyElementText(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_YourTrxBeingProcess'), 'Your transaction is being processed')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Success_TotalAmount'), 'Rp20.000')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Success_TextInfo1'), 'If you make a payment using an e-wallet or a credit/debit card, you have completed your payment.')

WebUI.verifyElementText(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_Success_TextInfo2'), 'If you made a payment via bank transfer, please continue the payment process.')

WebUI.click(findTestObject('4. Payment/Payment_CC/Button_BackToMerchantsWeb'))

WebUI.verifyElementVisible(findTestObject('4. Payment/Payment_ATMBankTransfer/Verify_BookedPayment'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

