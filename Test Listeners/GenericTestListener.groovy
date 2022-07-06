import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.sikuli.basics.Settings
import org.sikuli.script.ImagePath

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil

import common.Ecran
import groovy.json.JsonOutput
import internal.GlobalVariable
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class GenericTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def setSikuliImagePath(TestCaseContext testCaseContext) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository");
		
		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("Le dossier d'image pour Sikulix n'existae pas: ${imagePath.toString()}")
		ImagePath.setBundlePath(imagePath.toString())
		
		KeywordUtil.markPassed("Dossier d'image pour Sikulix: ${imagePath.toString()}")
		
		Settings.OcrTextSearch = true
		
	}
	
	@BeforeTestCase
	def initializeSikuliScreen() {
		Ecran.initiliaze()
		KeywordUtil.markPassed("Ecran Sikulix initialisé")
	}
	
	@BeforeTestCase
	def createScreenshotFolder() {
		Path screenFolder = Paths.get(RunConfiguration.getReportFolder()).resolve("screenshots")
		Files.createDirectories(screenFolder)
		KeywordUtil.markPassed("Dossier de screenshot initialisé")
	}
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		if (testCaseContext.getTestCaseStatus().equalsIgnoreCase("FAILED")) {
			CustomKeywords.'common.Ecran.prendreScreenshot'('failed')
		}
		if (testCaseContext.getTestCaseStatus().equalsIgnoreCase("ERROR")) {
			CustomKeywords.'common.Ecran.prendreScreenshot'('error')
		}
	}
	
	/**
	 * Démarre le monitoing local si spécifié dans le profile
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		if(GlobalVariable.monitoring) {
			WSBuiltInKeywords.sendRequest(findTestObject("Object Repository/00-Requests/Mesures automatiques - Start"))
			KeywordUtil.logInfo("Monitoring started")
		}
	}

	/**
	 * Stoppe le monitoring local et enregistre les valeurs dans le dossier de rapport si spécifié dans le profil
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		if(GlobalVariable.monitoring) {
			WSBuiltInKeywords.sendRequest(findTestObject("Object Repository/00-Requests/Mesures automatiques - Stop"))
			KeywordUtil.logInfo("Monitoring stopped")
			ResponseObject resp = WSBuiltInKeywords.sendRequest(findTestObject("Object Repository/00-Requests/Mesures automatiques - Retrieve"))
			
			Path monitorFile = Paths.get(RunConfiguration.getReportFolder()).resolve("monitor.json")
			monitorFile.toFile().write JsonOutput.prettyPrint(resp.getResponseBodyContent())
			
			KeywordUtil.logInfo("Monitoring saved to ${monitorFile.toString()}")
		}
	}
	
}