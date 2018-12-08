import org.pythonbyte.kbird.parsers.ChecklistDetailsPageParser
import org.pythonbyte.kbird.parsers.HotspotRecentVisitsPageParser

fun main(args: Array<String> ) {
    val MALDEN_PARK_WINDSOR_ONTARIO_ID = "L374235"
    fetchRecentHotspotChecklists(KBirdConfiguration.loadConfiguration(), MALDEN_PARK_WINDSOR_ONTARIO_ID)
}

fun fetchRecentHotspotChecklists(configuration: KBirdConfiguration, hotspotCode: String ) {
    val recentChecklists = HotspotRecentVisitsPageParser(hotspotCode, configuration).fetchRecentChecklists()
    Thread.sleep( 300 )
    for ( checklist in recentChecklists ) {
        println( checklist.getJson() )
        checklist.speciesEntries = ChecklistDetailsPageParser(checklist.identifier, configuration).fetchSpeciesEntries()
        println( checklist.getJson() )
        Thread.sleep( 50 )
    }
}