package parsers

import domain.Hotspot
import KBirdConfiguration
import base.GpsCoordinates
import org.jsoup.Jsoup

class CountyHotspotsPageParser( var configuration: KBirdConfiguration, countyCode: String ): BasePageParser( configuration.baseEBirdUrl + "/subnational2/" + countyCode + "/hotspots?yr=all&m=" ) {
    fun fetchHotspots(): List<Hotspot> {
        val hotspots = ArrayList<Hotspot>()

        for ( hotspotLinkTdElement in selectClass( "top-observer--subregion" ) ) {
            val hotspot = Hotspot.createFromLinkElement( hotspotLinkTdElement.select("a").first() )
            println( "Fetched hotspot [" + hotspot.name +  "]..going to sleep for 2 seconds" )
            Thread.sleep( 4000 )
            parsePageDetails( hotspot )

            hotspots.add(hotspot)
        }

        return hotspots;
    }

    private fun parsePageDetails(hotspot: Hotspot) {
        val detailsPageDocument = Jsoup.connect( configuration.baseEBirdUrl + hotspot.url ).get()

        hotspot.speciesCount = detailsPageDocument.select( "span.hs-section-count" ).first().text().toLong();

        var googleMapsUrl = detailsPageDocument.select( ".sub-nat" ).select( "a[href^=http://maps.google.com]" ).attr( "href" );
        hotspot.coordinates = GpsCoordinates( googleMapsUrl.split( "&ll=" ).get( 1 ) )
    }
}
