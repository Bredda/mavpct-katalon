import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.sikuli.script.ImagePath

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil

import common.Ecran

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
}