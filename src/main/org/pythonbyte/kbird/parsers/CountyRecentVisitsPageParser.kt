package parsers

import org.pythonbyte.kbird.domain.Checklist
import kotlin.collections.ArrayList

class CountyRecentVisitsPageParser( countyCode: String ) : BasePageParser( "http://ebird.org/ebird/subnational2/$countyCode/activity" ) {
    fun fetchRecentChecklists() : List<Checklist> {
        val checklists = ArrayList<Checklist>()
        selectClass( "specLtblue" ).mapTo( checklists ) { Checklist.parseFromJsonTrElement( it ) }
        return checklists
    }
}