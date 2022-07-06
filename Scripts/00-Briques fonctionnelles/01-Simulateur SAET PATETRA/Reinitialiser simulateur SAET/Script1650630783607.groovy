import com.kms.katalon.core.util.KeywordUtil

import common.ImgRepo as ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

CustomKeywords.'common.Ecran.attendrePresence'('saet-start-green', 30)

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

boolean dejaOuvert = CustomKeywords.'common.Ecran.estExistant'('saet-sim-3-selected', 3)

if (!dejaOuvert) {
	CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-sim-3', 0.8)
}
CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('tetra-preuve-charge.png', 20, 0.7)
CustomKeywords.'common.Ecran.prendreScreenshot'('sta_charge')