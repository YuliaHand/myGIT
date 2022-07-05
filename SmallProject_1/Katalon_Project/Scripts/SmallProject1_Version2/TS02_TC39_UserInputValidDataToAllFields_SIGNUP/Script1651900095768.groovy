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

WebUI.callTestCase(findTestCase('SmallProject1_Version2/TS01_TC04_CheckButtonFunction_SignUp'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('2. Register/Logo_Header'))

WebUI.verifyElementText(findTestObject('2. Register/Title_Registration'), 'Registration')

WebUI.verifyElementVisible(findTestObject('2. Register/Desc_Registration'))

WebUI.setText(findTestObject('2. Register/Field_BusinessName'), 'Yulia123')

WebUI.setText(findTestObject('2. Register/Field_FullName'), 'Yulia Handayani')

WebUI.setText(findTestObject('2. Register/Field_BusinessEmail'), 'langit@gmail.com')

WebUI.setText(findTestObject('2. Register/Field_PhoneNum'), '081355353533')

WebUI.setText(findTestObject('2. Register/Field_Password'), 'Yulia12345')

WebUI.setText(findTestObject('2. Register/Field_ConfirmPwd'), 'Yulia12345')

WebUI.click(findTestObject('2. Register/Button_RegisterMidtrans'))

WebUI.verifyElementText(findTestObject('2. Register/Verify_SuccessLogin'), 'Log In')

WebUI.verifyElementVisible(findTestObject('2. Register/Desc_Login'))

WebUI.closeBrowser()

