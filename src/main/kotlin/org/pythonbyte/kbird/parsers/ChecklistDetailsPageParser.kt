package org.pythonbyte.kbird.parsers

import KBirdConfiguration
import org.jsoup.nodes.Element
import org.pythonbyte.kbird.domain.Checklist
import org.pythonbyte.kbird.domain.SpeciesEntry

class ChecklistDetailsPageParser(
    checklistIdentifier: String,
    configuration: KBirdConfiguration
) : BasePageParser("${configuration.baseEBirdUrl}view/checklist/$checklistIdentifier") {
    fun fetchSpeciesEntries() : List<SpeciesEntry> {
        return selectClass( "spp-entry" ).map {
            parseSpeciesEntry(it)
        }
    }

    private fun parseSpeciesEntry( element: Element ) : SpeciesEntry {
        return SpeciesEntry(
            element.select(".se-name").text(),
            element.select(".se-count" ).text()
        )
    }

}