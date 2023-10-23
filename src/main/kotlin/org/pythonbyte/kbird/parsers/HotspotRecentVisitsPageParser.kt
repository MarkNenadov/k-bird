package org.pythonbyte.kbird.parsers

import KBirdConfiguration
import org.pythonbyte.kbird.domain.Checklist

class HotspotRecentVisitsPageParser( private val hotspotIdentifier: String, private val kBirdConfiguration: KBirdConfiguration ):
    BasePageParser(  "${kBirdConfiguration.baseEBirdUrl}/hotspot/$hotspotIdentifier/activity?yr=all&m=" ) {
    fun fetchRecentChecklists() : List<Checklist> {
        val checklists = mutableListOf<Checklist>()
        selectClass( "specLtblue" ).mapTo( checklists ) { Checklist.parseFromJsonTrElement( it ) }
        return checklists
    }
}