import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String dossier = "00-Serveur MavPct"

KeywordUtil.logInfo('Démarrage du serveur MavPct')


CustomKeywords.'common.Ecran.cliquerSur'(dossier, "server-icone.png")

boolean nonCharge = CustomKeywords.'common.Ecran.estExistant'(dossier, "localhost-non-charge.png", 20, 0.85)

if (nonCharge) {
	KeywordUtil.logInfo("00-Serveur MavPct\\Serveur non chargé, chargement en cours...")
	CustomKeywords.'common.Ecran.cliquerSur'(dossier, "charge-button.png")
	CustomKeywords.'common.Ecran.attendrePresence'(dossier, "license-ok-button.png")
	CustomKeywords.'common.Ecran.cliquerSur'(dossier, "license-ok-button.png")
} else {
	KeywordUtil.logInfo("Serveur déjà chargé")
}

CustomKeywords.'common.Ecran.attendrePresence'(dossier, "localhost-charge.png", 30, 0.90)
CustomKeywords.'common.Ecran.prendreScreenshot'("serveur_mavpct_charge")
CustomKeywords.'common.Ecran.cliquerSur'(dossier, "config-ok-button.png")



KeywordUtil.markPassed("Serveur MAVPCT démarré avec succès")
