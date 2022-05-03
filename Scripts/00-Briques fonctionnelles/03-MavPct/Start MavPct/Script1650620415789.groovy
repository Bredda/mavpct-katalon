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
import common.ImgRepo as ImgRepo
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.MAV_PCT)

CustomKeywords.'common.Ecran.cliquer'('mavpct_icone.png')

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('mavpct_warning_licence.png', 15, 0.85)

CustomKeywords.'common.Ecran.cliquer'('mavpct_button_ok_licence.png')

CustomKeywords.'common.Ecran.attendrePresence'('mavpct_form_login.png', 15)

CustomKeywords.'common.Ecran.renseigner'('mavpct_username.png', username)

CustomKeywords.'common.Ecran.renseigner'('mavpct_password.png', password)

CustomKeywords.'common.Ecran.cliquer'('mavpct_button_connecter.png')

CustomKeywords.'common.Ecran.attendrePresence'('mavpct_header', 20)

CustomKeywords.'common.Ecran.prendreScreenshot'('')

