package parsers

import domain.KbirdConfiguration
import domain.SpeciesEntry

class ChecklistDetailsPageParser( checklistIdentifier: String, configuration: KbirdConfiguration ) : BasePageParser( configuration.baseEBirdPath + "view/checklist/" + checklistIdentifier ) {
    fun fetchSpeciesEntries() : ArrayList<SpeciesEntry> {
        val speciesEntries = ArrayList<SpeciesEntry>()
        for( speciesEntryElement in pageDocument.select( ".spp-entry" ) ) {
            val speciesEntry = SpeciesEntry(speciesEntryElement.select(".se-name").text(), speciesEntryElement.select(".se-count").text())
            speciesEntries.add( speciesEntry );
        }

        println( speciesEntries.size )

        return speciesEntries;
    }
}