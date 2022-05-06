package common

import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil

import org.apache.commons.io.FilenameUtils
import org.sikuli.script.App
import org.sikuli.script.ImagePath
import org.sikuli.script.KeyModifier
import org.sikuli.script.Match
import org.sikuli.script.Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen
import org.sikuli.script.ScreenImage

public class Ecran {

	public static Screen screen = null
	public static Screen screen2 = null
	
	public static void initiliaze() {
		screen = new Screen()
		int nbScreen = screen.getNumberScreens()
		if (nbScreen == 2)
			screen2 = screen.getScreen(1)
		KeywordUtil.logInfo "Sikulix initialisé avec ${nbScreen} écrans"
	}

	@Keyword(keywordObject="Sikulix")
	def static changerDossierImage(String nouveauDossier) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository").resolve(nouveauDossier);

		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("Le dossier d'image pour Sikulix n'existae pas: ${imagePath.toString()}")
		ImagePath.setBundlePath(imagePath.toString())
	}

	@Keyword(keywordObject="Sikulix")
	def static changerDossierImage(ImgRepo imgRepo) {
		Path imagePath = Paths.get(RunConfiguration.getProjectDir()).resolve("Image Repository").resolve(imgRepo.dossier);

		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("Le dossier d'image pour Sikulix n'existae pas: ${imagePath.toString()}")
		ImagePath.setBundlePath(imagePath.toString())
	}

	/**
	 * Clic sur une image donnée (Taux de similarité standard de 70%)
	 * @param folder Dossier de image (depuis l'image repository)
	 * @param image Nom du fichier image (avec extension)
	 */
	@Keyword(keywordObject="Sikulix")
	def static cliquer(String image) {
		cliquerAvecSimilarite image, 0.7
	}
	
	@Keyword(keywordObject="Sikulix")
	def static cliquer2emeEcran(String image) {
		String imageName = sanitizeImage image
		Pattern p = new Pattern(imageName).similar(0.7)
		if (screen2 == null)
			KeywordUtil.markErrorAndStop "Pas de deuxième écran de détecté"
		screen2.click(p)
	}
	
	
	@Keyword(keywordObject="Sikulix")
	def static cliquerText(String texte) {

		List<Match> matches = screen.findAllText(texte)

		KeywordUtil.logInfo "Size matches: ${matches.size()}"
	}


	/**
	 * Clic sur une image donnée avec un taux de similarité spécifique
	 * @param image Nom du fichier ilage (avec extension)
	 * @param similar Taux de similarité. Par défaut 0.7 (70%)
	 */
	@Keyword(keywordObject="Sikulix")
	def static cliquerAvecSimilarite(String image, float similar) {
		String imageName = sanitizeImage image
		Pattern p = new Pattern(imageName).similar(similar)

		screen.click(p)
	}

	@Keyword(keywordObject="Sikulix")
	def static cliquerDroitAvecSimilarite(String image, float similar) {
		String imageName = sanitizeImage image
		Pattern p = new Pattern(imageName).similar(similar)

		screen.rightClick(p)
	}

	@Keyword(keywordObject="Sikulix")
	def static cliquerAvecDecalage(String image, int dx, int dy) {
		String imageName = sanitizeImage image
		Pattern p = new Pattern(imageName).similar(0.7)

		screen.click(p.targetOffset(dx, dy))
	}

	@Keyword(keywordObject="Sikulix")
	def static cliquerAvecSimilariteEtDecalage(String image, float similar, int dx, int dy) {
		String imageName = sanitizeImage image
		Pattern p = new Pattern(imageName).similar(similar)

		screen.click(p.targetOffset(dx, dy))
	}

	/**
	 * Vérifie si une image donnée existe (Taux de similarité standard de 70%)
	 * @param image Nom du fichier ilage (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition
	 * @return un objet Match si existant, null sinon
	 */
	@Keyword(keywordObject="Sikulix")
	def static estExistant(String image, int timeout) {
		return estExistantAvecSimilarite(image, timeout, 0.7)
	}

	/**
	 * Vérifie si une image donnée existe  avec un taux de similarité spécifique
	 * @param image Nom du fichier ilage (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition
	 * @param similar Taux de similarité.
	 * @return un objet Match si existant, null sinon
	 */
	@Keyword(keywordObject="Sikulix")
	def static estExistantAvecSimilarite(String image, int timeout, float similar) {
		String imageName = sanitizeImage image

		Pattern p = new Pattern(imageName).similar(similar)

		return screen.exists(p, timeout)
	}

	/**
	 * Attend qu'une image donnée soit présente à l'écran  (Taux de similarité standard de 70%)
	 * @param image Nom du fichier image (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition. Par défaut 10 secondes
	 */
	@Keyword(keywordObject="Sikulix")
	def static attendrePresence(String image, int timeout) {
		attendrePresenceAvecSimilarite image, timeout, 0.7
	}

	/**
	 * Attend qu'une image donnée soit présente à l'écran  avec un taux de similarité spécifique
	 * @param image Nom du fichier image (avec extension)
	 * @param timeout Temps d'attente max en secondes de son apparition
	 * @param similar Taux de similarité
	 */
	@Keyword(keywordObject="Sikulix")
	def static attendrePresenceAvecSimilarite(String image, int timeout, float similar) {
		String imageName = sanitizeImage image

		Pattern p = new Pattern(imageName).similar(similar)

		Match m = screen.wait(p, timeout)

		KeywordUtil.logInfo("Match: $m")
	}

	@Keyword(keywordObject="Sikulix")
	def static prendreScreenshot(String screenshotName) {
		Region appRegion = App.focusedWindow()
		ScreenImage shot = screen.capture(appRegion)
		Path reportImage = Paths.get(RunConfiguration.getReportFolder()).resolve("screenshots").resolve("${System.currentTimeMillis()}_${screenshotName}.png");
		KeywordUtil.logInfo "Screen dans ${reportImage.toString()}"
		ImageIO.write(shot.getImage(), "png", reportImage.toFile())
	}

	@Keyword(keywordObject="Sikulix")
	def static renseigner(String image, String texte) {
		renseignerAvecSimilarite image, texte, 0.7
	}

	@Keyword(keywordObject="Sikulix")
	def static renseignerAvecSimilarite(String image, String texte, float similar) {
		String imageName = sanitizeImage image

		Pattern p = new Pattern(imageName).similar(similar)
		screen.type(p, texte)
	}

	@Keyword(keywordObject="Sikulix")
	def static altTab() {
		screen.type("\t", KeyModifier.ALT)
	}

	private static String sanitizeImage(String image) {
		String imageName = image;
		if (FilenameUtils.getExtension(image).isEmpty())
			imageName = "${image}.png"

		Path imagePath = Paths.get(ImagePath.getBundlePath()).resolve(imageName)
		if (!imagePath.toFile().exists())
			KeywordUtil.markErrorAndStop("L'image nommée ${image} n'existe pas dans: ${imagePath.toString()}")

		return imageName
	}
}
