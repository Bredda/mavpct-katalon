import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

KeywordUtil.logInfo('Ouverture du simulateur STA')

CustomKeywords.'common.Ecran.changerDossierImage'('02-Simulateur STA')

boolean chromeOuvertStaCharge = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('sta-chrome-url', 3, 0.7)


if (!chromeOuvertStaCharge) {
	boolean chromeOuvertStaNonCharge = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('chrome-nouvel_onglet.png', 3, 0.7)
	if (!chromeOuvertStaNonCharge) {
		CustomKeywords.'common.Ecran.cliquer'('chrome-icone.png')
	}
	CustomKeywords.'common.Ecran.attendrePresence'('sta-raccourci', 15)
	chromeOuvertStaCharge = CustomKeywords.'common.Ecran.estExistantAvecSimilarite'('sta-chrome-url', 3, 0.7)
	
	if (!chromeOuvertStaCharge) {
		CustomKeywords.'common.Ecran.cliquer'('sta-raccourci.png')
	}
	
	CustomKeywords.'common.Ecran.attendrePresence'('sta_P01_P02.png', 15)
} 

KeywordUtil.markPassed "Simulateur STA ouvert"