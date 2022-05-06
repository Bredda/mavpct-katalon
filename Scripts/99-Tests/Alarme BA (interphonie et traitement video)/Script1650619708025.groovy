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

'Charger le serveur MAVPCT'

//WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/00-Serveur MavPct/Charger Serveur MavPct'), [:], FailureHandling.STOP_ON_FAILURE)
'Ouvrir le simulateur STA'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/02-Simulateur STA/Ouvrir simulateur STA'), [:], FailureHandling.STOP_ON_FAILURE)

'Ouvrir le simulateur SAETPATETRA'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Ouvrir Simulateur SAETPATETRA'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Réinitialiser le simulateur'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Reinitialiser simulateur SAET'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Ouvrir et se connecter à MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Ouvrir MavPct'), [('username') : 'SPE', ('password') : 'SPE'], 
    FailureHandling.STOP_ON_FAILURE)

'Sortir du mode plein écran de MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Sortir du mode plein ecran de MAvPct'), [:], FailureHandling.STOP_ON_FAILURE)

'Retourner sur le simulateur SAETPATETRA'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Ouvrir Simulateur SAETPATETRA'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Laner la simulation pour la Nav02'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Lancer simulation Prepa N02 et N04'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Retourner sur MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Basculer sur MavPct ouvert'), [:], FailureHandling.STOP_ON_FAILURE)

'Attendre que la navette arrive à St Lazarre'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Attendre Nav2 St Lazare'), [:], FailureHandling.STOP_ON_FAILURE)

'Sortir du mode plein écran de MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Sortir du mode plein ecran de MAvPct'), [:], FailureHandling.STOP_ON_FAILURE)

'Retourner sur le simulateur SAETPATETRA'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Ouvrir Simulateur SAETPATETRA'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Déclencher une alarme BA sur NAV02'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/01-Simulateur SAET PATETRA/Declencher alarme BA nav2'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Retourner sur MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Basculer sur MavPct ouvert'), [:], FailureHandling.STOP_ON_FAILURE)

'Démarrer le traitement de l\'alarme pour la NAV02'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Lancer le traitement alarme BA Nav2'), [:], FailureHandling.STOP_ON_FAILURE)

'Vérifier démarrage sonorisation'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Verifier demarrage sonorisation'), [:], FailureHandling.STOP_ON_FAILURE)

'Vérifier la présence du flux vidéo'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Verifier presence flux video'), [:], FailureHandling.STOP_ON_FAILURE)

'Sortir du mode plein écran de MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Sortir du mode plein ecran de MAvPct'), [:], FailureHandling.STOP_ON_FAILURE)

'Retourner sur le simulateur STA'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/02-Simulateur STA/Ouvrir simulateur STA'), [:], FailureHandling.STOP_ON_FAILURE)

'Traiter l\'appel en attente sur la poste P1'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/02-Simulateur STA/Traiter appel en attente sur P1'), [:], FailureHandling.STOP_ON_FAILURE)

'Retourner sur MAVPCT'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Basculer sur MavPct ouvert'), [:], FailureHandling.STOP_ON_FAILURE)

'Vérifier que l\'alarme a été traitée et acquitter son traitement'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/03-MavPct/Verifier alarme BA Nav02 traitee et acquitter'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Vérifier que l\'alrme a bien été inscrite en base'
WebUI.callTestCase(findTestCase('00-Briques fonctionnelles/04-Bdd/Verifier nouvelle alarme en base'), [('label') : 'BA', ('name') : '/MAVPCT/Shuttles/L14_NAV02/Coach1/Alarms/BA'], 
    FailureHandling.STOP_ON_FAILURE)

