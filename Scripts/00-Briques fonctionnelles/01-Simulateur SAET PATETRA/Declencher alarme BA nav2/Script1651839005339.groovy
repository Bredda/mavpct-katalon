import common.ImgRepo as ImgRepo

CustomKeywords.'common.Ecran.changerDossierImage'(ImgRepo.SIM_SAET_PATETRA)

boolean dejaOuvert = CustomKeywords.'common.Ecran.estExistant'('saet-sim-3-selected', 3)

if (!dejaOuvert) {
	CustomKeywords.'common.Ecran.cliquerAvecSimilarite'('saet-sim-3', 0.8)
}


CustomKeywords.'common.Ecran.attendrePresenceAvecSimilarite'('tetra-preuve-charge.png', 20, 0.7)
CustomKeywords.'common.Ecran.cliquerAvecSimilariteEtDecalage'('tetra-nav2-button-init', 0.98, 279, 2)
CustomKeywords.'common.Ecran.cliquerAvecSimilariteEtDecalage'('tetra-bloc-nav2', 0.70, 101, -32)



