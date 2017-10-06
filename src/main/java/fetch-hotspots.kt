import domain.CountyCodes
import parsers.CountyHotspotsPageParser

fun main(args: Array<String> ) {
    fetchHotspots( KBirdConfiguration.loadConfiguration(), CountyCodes.ESSEX_ONTARIO_CANADA )
}

fun fetchHotspots(configuration: KBirdConfiguration, countyCode: String) {
    val recentChecklists = CountyHotspotsPageParser( configuration, countyCode ).fetchHotspots()

    for ( checklist in recentChecklists ) {
        println( checklist.getJson() )
    }
    /*Thread.sleep( 300 )
    for ( checklist in recentChecklists ) {
        checklist.speciesEntries = ChecklistDetailsPageParser(checklist.identifier, configuration).fetchSpeciesEntries()
        println( checklist.getJson() )
        Thread.sleep( 50 )
    }*/
}
