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

CustomKeywords.'common.Ecran.changerDossierImage'('02-Simulateur STA')

boolean p1Attente = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('sta-P01-enattente', 10, 0.90)

if (!(p1Attente)) {
    KeywordUtil.markFailedAndStop('Aucun appel en attente sur P1')
}

CustomKeywords.'common.Ecran.cliquerAvecSimilariteEtDecalage'('sta-P01-enattente', 0.9, -37, 63)


boolean p1Encours = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('sta-P01-encours', 10, 0.85)

if (!(p1Encours)) {
    KeywordUtil.markFailedAndStop('Aucun appel en cours sur P1')
}

CustomKeywords.'common.Ecran.cliquerAvecSimilariteEtDecalage'('sta-P01-encours', 0.9, 0, 60)

boolean p1Libre = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('sta-P01-libre', 10, 0.85)

if (!(p1Libre)) {
    KeywordUtil.markFailedAndStop('Poste P1 n\'a pas été libéré')
}



