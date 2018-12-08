import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class KBirdConfiguration {
    var baseEBirdUrl = ""
    var jsoupForHotspotDetailsSpeciesCount = ""

    companion object {
        val CONFIGURATION_FILE_PATH = "/src/main/resources/configuration.json"

        fun loadConfiguration(): KBirdConfiguration {
            return jacksonObjectMapper().readValue( File( System.getProperty( "user.dir" ) + CONFIGURATION_FILE_PATH ) )
        }
    }
}