import com.kms.katalon.core.util.KeywordUtil

import common.ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.MAV_PCT)


boolean started = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('mavpct-demarrer-telephonie.png', 20, 0.85)

if (!started) {
	KeywordUtil.markFailed "Téléphonie non démarrée"
}
