import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

CustomKeywords.'common.Ecran.altTab'()

dejaOuvert = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('saet-header.png', 3, 85)

if (dejaOuvert) {
    KeywordUtil.logInfo('Simulateur déjà ouvert')
} else {
    CustomKeywords.'common.Ecran.cliquer'('saet-icone.png')

    CustomKeywords.'common.Ecran.attendrePresence'('saet-header.png', 30)
}

dejaSelectionne = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('saet-list-2.png', 3, 85)

if (dejaSelectionne) {
    KeywordUtil.logInfo('Simulateur SAET déjà selectionné')
} else {
    KeywordUtil.logInfo('Sélection du simulateur SAET')

    CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-sim-2.png', 0.9)
}

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('saet-sim-2-header.png', 10, 0.8)

CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-button-import.png', 0.88)

CustomKeywords.'common.Ecran.cliquer'('saet-l14-reinit')

CustomKeywords.'common.Ecran.cliquer'('saet-dialog-ouvrir')

CustomKeywords.'common.Ecran.cliquerAvecDecalage'('saet-start-green', -50, -4)

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('saet-log-deco', 10, 0.85)

