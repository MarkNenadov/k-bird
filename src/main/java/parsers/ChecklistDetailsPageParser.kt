package parsers

import KBirdConfiguration
import domain.SpeciesEntry
import org.jsoup.nodes.Element

class ChecklistDetailsPageParser( checklistIdentifier: String, configuration: KBirdConfiguration ) : BasePageParser( configuration.baseEBirdPath + "view/checklist/" + checklistIdentifier ) {
    fun fetchSpeciesEntries() : ArrayList<SpeciesEntry> {
        val speciesEntries = ArrayList<SpeciesEntry>()
        selectClass( "spp-entry" ).mapTo( speciesEntries ) { parseSpeciesEntry( it ) }

        return speciesEntries
    }

    private fun parseSpeciesEntry( element: Element ) : SpeciesEntry {
        return SpeciesEntry( element.select(".se-name").text(), element.select(".se-count" ).text() )
    }

}