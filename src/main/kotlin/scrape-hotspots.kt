import org.pythonbyte.kbird.domain.CountyCodes
import org.pythonbyte.kbird.parsers.CountyHotspotsPageParser
fun main(args: Array<String>) {
    fetchHotspots(KBirdConfiguration.loadConfiguration(), CountyCodes.ESSEX_ONTARIO_CANADA)
}
fun fetchHotspots(configuration: KBirdConfiguration, countyCode: String) {
    val hotspots = CountyHotspotsPageParser(
        configuration,
        countyCode,
    ).fetchHotspots()

    for (hotspot in hotspots) {
        println(hotspot.getJson())
    }
}
