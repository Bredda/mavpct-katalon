import common.ImgRepo as ImgRepo
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.MAV_PCT)

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('mavpct-alarme-baN02-levee', 10, 0.7)

boolean alarmePresente = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('mavpct-alarme-baN02-levee', 10, 0.7)

if (!(alarmePresente)) {
    KeywordUtil.markFailedAndStop('L\'alarme BA pour la Nav02 n\'a pas été trouvée')
}

CustomKeywords.'common.Ecran.cliquer'('mavpct-alarme-baN02-levee')

