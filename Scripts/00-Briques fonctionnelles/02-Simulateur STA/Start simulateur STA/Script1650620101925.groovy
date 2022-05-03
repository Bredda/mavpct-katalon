import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'common.Ecran.changerDossierImage'('02-Simulateur STA')

CustomKeywords.'common.Ecran.cliquer'('chrome-icone.png')

CustomKeywords.'common.Ecran.attendrePresence'('chrome-nouvel_onglet.png', 115)

CustomKeywords.'common.Ecran.cliquer'('sta-raccourci.png')

CustomKeywords.'common.Ecran.attendrePresence'('sta_P01_P02.png', 15)

CustomKeywords.'common.Ecran.prendreScreenshot'('simulateur_sta_charge')

KeywordUtil.markPassed('Simulateur STA chargé')

