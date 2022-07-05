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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://demo.midtrans.com/')

WebUI.verifyElementVisible(findTestObject('1. Homepage/Header_MidtransPillow_Homepage'))

WebUI.verifyElementText(findTestObject('1. Homepage/Title_Homepage'), 'Midtrans Pillow')

WebUI.verifyElementText(findTestObject('1. Homepage/Desc_Price_Homepage'), 'Rp 20,000')

WebUI.verifyElementText(findTestObject('1. Homepage/Desc_Title_Homepage'), 'Get cozy with our new pillow!')

WebUI.verifyElementText(findTestObject('1. Homepage/Desc_Homepage'), 'Disclaimer: This is not a real transaction.No funds will be transfered out of your account. You should sleep with a proper pillow to refrain yourself from injury.')

WebUI.verifyElementClickable(findTestObject('2. Register/Button_Register'))

WebUI.verifyElementClickable(findTestObject('3. Checkout/a_BUY NOW'))

WebUI.verifyElementClickable(findTestObject('1. Homepage/Button_Slide_Left'))

WebUI.verifyElementClickable(findTestObject('1. Homepage/Button_Slide_Right'))

WebUI.closeBrowser()

