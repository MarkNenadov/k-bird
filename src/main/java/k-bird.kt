import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.CountyCodes
import domain.KbirdConfiguration
import parsers.ChecklistDetailsPageParser
import parsers.CountyRecentVisitsPageParser
import java.io.File

fun main( args: Array<String> ) {
    val configuration = loadConfiguration()

    fetchRecentChecklists( configuration )
}

fun fetchRecentChecklists( configuration: KbirdConfiguration ) {
    val recentChecklists = CountyRecentVisitsPageParser( CountyCodes.ESSEX_ONTARIO_CANADA ).fetchRecentChecklists()
    Thread.sleep( 300 )
    for ( checklist in recentChecklists ) {
        checklist.speciesEntries = ChecklistDetailsPageParser( checklist.identifier, configuration ).fetchSpeciesEntries()
        println( checklist.getJson() )
        Thread.sleep( 50 )
    }
}

fun loadConfiguration(): KbirdConfiguration {
    val mapper = jacksonObjectMapper()
    return  mapper.readValue( File( System.getProperty( "user.dir" ) + "/src/main/resources/configuration.json" ) )
}
