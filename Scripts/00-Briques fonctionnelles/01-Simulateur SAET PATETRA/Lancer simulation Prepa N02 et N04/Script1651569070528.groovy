import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import common.ImgRepo as ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

pasSelectionne = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('saet-sim-2', 3, 0.7)

if (pasSelectionne) {
	KeywordUtil.logInfo('Sélection du simulateur SAET')
	CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-sim-2.png', 0.7)

} else {
	KeywordUtil.logInfo('Simulateur SAET déjà selectionné')
	CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-sim-2-selectionne', 0.7)
}

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('saet-sim-2-header.png', 10, 0.8)

CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-button-import.png', 0.88)

CustomKeywords.'common.Ecran.cliquer'('saet-sim-n02n04')

CustomKeywords.'common.Ecran.cliquer'('saet-dialog-ouvrir')

CustomKeywords.'common.Ecran.cliquerAvecDecalage'('saet-start-green', -50, -4)

WebUiBuiltInKeywords.delay(50)

CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('saet-stopped', 95, 0.9)

