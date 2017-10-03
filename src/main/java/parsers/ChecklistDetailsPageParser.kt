package parsers

import domain.KbirdConfiguration
import domain.SpeciesEntry
import org.jsoup.nodes.Element

class ChecklistDetailsPageParser( checklistIdentifier: String, configuration: KbirdConfiguration ) : BasePageParser( configuration.baseEBirdPath + "view/checklist/" + checklistIdentifier ) {
    fun fetchSpeciesEntries() : ArrayList<SpeciesEntry> {
        val speciesEntries = ArrayList<SpeciesEntry>()
        for( speciesEntryElement in selectClass( "spp-entry" ) ) {
            speciesEntries.add( parseSpeciesEntry( speciesEntryElement ) )
        }

        return speciesEntries;
    }

    fun parseSpeciesEntry( element: Element ) : SpeciesEntry {
        return SpeciesEntry( element.select(".se-name").text(), element.select(".se-count" ).text() )
    }

}