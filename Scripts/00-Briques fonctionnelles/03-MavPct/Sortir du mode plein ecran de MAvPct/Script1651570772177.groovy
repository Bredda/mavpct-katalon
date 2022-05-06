import common.ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.MAV_PCT)

CustomKeywords.'common.Ecran.altTab'()

boolean taskbar = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('mavpct-preuve-taskbar-visible.png', 2, 0.7)

if(!taskbar) {
		CustomKeywords.'common.Ecran.altTab'()
}
	

