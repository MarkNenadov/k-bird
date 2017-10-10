package parsers

import KBirdConfiguration
import domain.Checklist

class HotspotRecentVisitsPageParser( hotspotIdentifier: String, kBirdConfiguration: KBirdConfiguration ): BasePageParser(  kBirdConfiguration.baseEBirdUrl + "/hotspot/" + hotspotIdentifier + "/activity?yr=all&m=" ) {
    fun fetchRecentChecklists() : List<Checklist> {
        val checklists = ArrayList<Checklist>()
        selectClass( "specLtblue" ).mapTo( checklists ) { Checklist.parseFromJsonTrElement( it ) }
        return checklists
    }
}