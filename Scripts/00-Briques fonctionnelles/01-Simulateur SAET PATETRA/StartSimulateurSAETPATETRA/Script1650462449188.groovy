import com.kms.katalon.core.util.KeywordUtil

import common.ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

KeywordUtil.logInfo('Démarrage du simulateur SAET PATETRA')

CustomKeywords.'common.Ecran.cliquer'('saet-icone.png')

CustomKeywords.'common.Ecran.attendrePresence'('saet-header.png', 15)

CustomKeywords.'common.Ecran.prendreScreenshot'('simulateur_saet_patetra_demarre')

KeywordUtil.logInfo('Simulateur SAET PATETRA démarré')



