package parsers

import domain.Hotspot
import KBirdConfiguration

class CountyHotspotsPageParser(configuration: KBirdConfiguration, countyCode: String ): BasePageParser( configuration.baseEBirdPath + "/subnational2/" + countyCode + "/hotspots?yr=all&m=" ) {
    fun fetchHotspots(): List<Hotspot> {
        val hotspots = ArrayList<Hotspot>()

        for ( hotspotLinkTdElement in selectClass( "top-observer--subregion" ) ) {
            hotspots.add( Hotspot.createFromLinkElement( hotspotLinkTdElement.select( "a" ).first() ) )
        }

        return hotspots;
    }
}
