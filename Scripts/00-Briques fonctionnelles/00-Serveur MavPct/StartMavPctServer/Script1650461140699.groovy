import org.sikuli.script.Pattern
import org.sikuli.script.Screen

import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo("Démarrage du serveur MavPct")

Screen s = new Screen()


s.click("00-Serveur MavPct\\server-icone.png")

Pattern p = new Pattern("00-Serveur MavPct\\localhost-non-charge.png").similar(0.85)

if (s.exists(p, 10)) {
	KeywordUtil.logInfo("00-Serveur MavPct\\Serveur non chargé, chargement en cours...")
	s.click("00-Serveur MavPct\\charge-button.png")
	s.wait("00-Serveur MavPct\\license-ok-button.png", 10)
	s.click("00-Serveur MavPct\\license-ok-button.png")
	
} else {
	KeywordUtil.logInfo("Serveur déjà chargé")
}
p = new Pattern("00-Serveur MavPct\\localhost-charge.png").similar(0.90)
s.wait(p, 30)
s.click("00-Serveur MavPct\\config-ok-button.png")

KeywordUtil.markPassed("Serveur MAVPCT démarré avec succès")