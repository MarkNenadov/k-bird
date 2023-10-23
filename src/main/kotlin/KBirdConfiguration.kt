import org.pythonbyte.krux.properties.PropertyReader

const val PROPERTIES_FILE = "/k-bird.properties"

class KBirdConfiguration {
    var baseEBirdUrl = ""
    var jsoupForHotspotDetailsSpeciesCount = ""

    companion object {
        fun loadConfiguration(): KBirdConfiguration {
            val configuration = KBirdConfiguration().apply {
                baseEBirdUrl = PropertyReader(PROPERTIES_FILE).get("kbird.baseEBirdUrl")
            }

            return configuration
        }
    }
}
