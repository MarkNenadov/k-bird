package org.pythonbyte.kbird.parsers

import KBirdConfiguration
import org.jsoup.Jsoup
import org.pythonbyte.kbird.domain.Hotspot
import org.pythonbyte.krux.mapping.GpsCoordinates

class CountyHotspotsPageParser(
    private val configuration: KBirdConfiguration,
    countyCode: String,
) : BasePageParser("${configuration.baseEBirdUrl}/subnational2/$countyCode/hotspots?yr=all&m=") {
    fun fetchHotspots(): List<Hotspot> {
        val hotspots = ArrayList<Hotspot>()

        for (hotspotLinkTdElement in selectClass("top-observer--subregion")) {
            val hotspot = hotspotLinkTdElement.select("a").first()?.let {
                Hotspot.createFromLinkElement(it)
            }
            hotspot?.let {
                println("Fetched hotspot [${it.name}]..going to sleep for 2 seconds")

                Thread.sleep(4000)
                parsePageDetails(it)

                hotspots.add(it)
            }
        }

        return hotspots
    }

    private fun parsePageDetails(hotspot: Hotspot) {
        val detailsPageDocument = Jsoup.connect(configuration.baseEBirdUrl + hotspot.url).get()

        hotspot.speciesCount = detailsPageDocument.select("span.hs-section-count")
            .firstOrNull()
            ?.text()
            ?.toLong()

        val googleMapsUrl = detailsPageDocument
            .select(".sub-nat")
            .select("a[href^=http://maps.google.com]")
            .attr("href")

        hotspot.coordinates = GpsCoordinates(
            googleMapsUrl.split("&ll=").getOrNull(1) ?: "",
        )
    }
}
