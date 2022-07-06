import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import common.ImgRepo as ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

KeywordUtil.logInfo('Ouverture du simulateur SAET PATETRA')

boolean simulateurVisible = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('saet-header', 3, 0.70)

if (simulateurVisible) {
    KeywordUtil.logInfo('Simulateur déjà ouvert')
} else {
    CustomKeywords.'common.Ecran.cliquer'('saet-icone.png')

    CustomKeywords.'common.Ecran.attendrePresence'('saet-header', 30)
}
CustomKeywords.'common.Ecran.prendreScreenshot'('saetpatetra_ouvert')
KeywordUtil.logInfo('Simulateur SAET PATETRA ouvert')

