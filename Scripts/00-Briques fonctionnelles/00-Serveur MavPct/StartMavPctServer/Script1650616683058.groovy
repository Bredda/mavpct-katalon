import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'common.Ecran.changerDossierImage'('00-Serveur MavPct')

KeywordUtil.logInfo('Démarrage du serveur MavPct')

CustomKeywords.'common.Ecran.cliquer'('server-icone.png')

boolean nonCharge = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('localhost-non-charge.png', 10, 0.85)

if (nonCharge) {
    KeywordUtil.logInfo('Serveur non chargé, chargement en cours...')

    CustomKeywords.'common.Ecran.cliquer'('charge-button.png')

    CustomKeywords.'common.Ecran.attendrePresence'('license-ok-button.png', 10)

    CustomKeywords.'common.Ecran.cliquer'('license-ok-button.png')
} else {
    KeywordUtil.logInfo('Serveur déjà chargé')
}

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('localhost-charge.png', 30, 0.90)

CustomKeywords.'common.Ecran.prendreScreenshot'('serveur_mavpct_charge')

CustomKeywords.'common.Ecran.cliquer'('config-ok-button.png')

KeywordUtil.markPassed('Serveur MAVPCT démarré avec succès')

