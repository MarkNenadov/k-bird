import org.pythonbyte.krux.properties.PropertyReader

class KBirdConfiguration {
    var baseEBirdUrl = ""
    var jsoupForHotspotDetailsSpeciesCount = ""

    companion object {
        const val PROPERTIES_FILE = "/k-bird.properties"

        fun loadConfiguration(): KBirdConfiguration {
            val propertyReader = PropertyReader(PROPERTIES_FILE)
            val configuration = KBirdConfiguration()
            configuration.baseEBirdUrl = propertyReader.get("kbird.baseEBirdUrl")

            return configuration
        }
    }
}
