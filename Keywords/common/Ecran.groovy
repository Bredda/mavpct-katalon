package common

import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil

import org.sikuli.script.App
import org.sikuli.script.Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen
import org.sikuli.script.ScreenImage

public class Ecran {

	private static Screen screen = null

	public static void initiliaze() {
		screen = new Screen()
	}

	/**
	 * Clic sur une image donnée
	 * @param folder Dossier de l'ilage (depuis l'image repository)
	 * @param image Nom du fichier ilage (avec extension)
	 * @param similar Taux de similarité. Par défaut 0.7 (70%)
	 */
	@Keyword
	def static cliquerSur(String folder, String image, float similar = 0.7) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository").resolve(folder).resolve(image)
		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("L'image nommée ${image} n'existe pas dans: ${imagePath.toString()}")

		Pattern p = new Pattern(imagePath.toString()).similar(similar)
		screen.click(p)
	}

	/**
	 * Vérifie si une image donnée existe
	 * @param folder Dossier de l'ilage (depuis l'image repository)
	 * @param image Nom du fichier ilage (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition. Par défaut 10 secondes
	 * @param similar Taux de similarité. Par défaut 0.7 (70%)
	 * @return un objet Match si existant, null sinon
	 */
	@Keyword
	def static estExistant(String folder, String image, int timeout = 10, float similar = 0.7) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository").resolve(folder).resolve(image)
		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("L'image nommée ${image} n'existe pas dans: ${imagePath.toString()}")

		Pattern p = new Pattern(imagePath.toString()).similar(similar)

		return screen.exists(p, timeout)
	}

	/**
	 * Attend qu'une image donnée soit présente à l'écran
	 * @param folder Dossier de l'image (depuis l'image repository)
	 * @param image Nom du fichier image (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition. Par défaut 10 secondes
	 * @param similar Taux de similarité. Par défaut 0.7 (70%)
	 */
	@Keyword
	def static attendrePresence(String folder, String image, int timeout = 10, float similar = 0.7) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository").resolve(folder).resolve(image)
		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("L'image nommée ${image} n'existe pas dans: ${imagePath.toString()}")

		Pattern p = new Pattern(imagePath.toString()).similar(similar)

		return screen.exists(p, timeout)
	}
	
	@Keyword
	def static prendreScreenshot(String screenshotName) {
		Region appRegion = App.focusedWindow()
		ScreenImage shot = screen.capture(appRegion)
		Path reportImage = Paths.get(RunConfiguration.getReportFolder()).resolve("screenshots").resolve("${System.currentTimeMillis()}_${screenshotName}.png");
		KeywordUtil.logInfo "Screen dans ${reportImage.toString()}"
		ImageIO.write(shot.getImage(), "png", reportImage.toFile())
	}
}
