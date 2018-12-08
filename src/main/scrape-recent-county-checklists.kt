import domain.CountyCodes
import org.pythonbyte.kbird.parsers.ChecklistDetailsPageParser
import org.pythonbyte.kbird.parsers.CountyRecentVisitsPageParser

fun main( args: Array<String> ) {
    fetchRecentChecklists( KBirdConfiguration.loadConfiguration(), CountyCodes.ESSEX_ONTARIO_CANADA )
}

fun fetchRecentChecklists( configuration: KBirdConfiguration, countyCode: String ) {
    val recentChecklists = CountyRecentVisitsPageParser( countyCode ).fetchRecentChecklists()
    Thread.sleep( 300 )
    for ( checklist in recentChecklists ) {
        checklist.speciesEntries = ChecklistDetailsPageParser( checklist.identifier, configuration ).fetchSpeciesEntries()
        println( checklist.getJson() )
        Thread.sleep( 50 )
    }
}