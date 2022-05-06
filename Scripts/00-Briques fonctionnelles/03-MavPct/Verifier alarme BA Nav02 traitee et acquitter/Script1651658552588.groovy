import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import common.Ecran as Ecran
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

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.MAV_PCT)

boolean alarmeTraitee = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('mavpct-alarme-baN02-traitee', 10, 0.8)

if (!(alarmeTraitee)) {
    KeywordUtil.logInfo('Alrme BA NAV02 n\'est pas affichée traitée')
}

CustomKeywords.'common.Ecran.cliquerAvecSimilariteEtDecalage'('mavpct-popup-fin-traitement', 0.8, 233, 122)

CustomKeywords.'common.Ecran.cliquer2emeEcran'('mavpct-retour-arriere')

CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('1649253067653', 0.7)

CustomKeywords.'common.Ecran.cliquerDroitAvecSimilarite'('mavpct-alarme-baN02-traitee', 0.8)

CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('mavpct-acquittement', 0.9)



