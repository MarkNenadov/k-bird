package org.pythonbyte.kbird.parsers

import KBirdConfiguration
import org.jsoup.nodes.Element
import org.pythonbyte.kbird.domain.SpeciesEntry

class ChecklistDetailsPageParser( checklistIdentifier: String, configuration: KBirdConfiguration ) : BasePageParser( configuration.baseEBirdUrl + "view/checklist/" + checklistIdentifier ) {
    fun fetchSpeciesEntries() : ArrayList<SpeciesEntry> {
        val speciesEntries = ArrayList<SpeciesEntry>()
        selectClass( "spp-entry" ).mapTo( speciesEntries ) { parseSpeciesEntry( it ) }

        return speciesEntries
    }

    private fun parseSpeciesEntry( element: Element ) : SpeciesEntry {
        return SpeciesEntry( element.select(".se-name").text(), element.select(".se-count" ).text() )
    }

}