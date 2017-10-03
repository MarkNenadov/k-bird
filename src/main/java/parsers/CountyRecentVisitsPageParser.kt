package parsers

import domain.Checklist
import kotlin.collections.ArrayList

class CountyRecentVisitsPageParser( countyCode: String ) : BasePageParser( "http://ebird.org/ebird/subnational2/" + countyCode + "/activity" ) {
    fun fetchRecentChecklists() : List<Checklist> {
        val checklists = ArrayList<Checklist>();
        for ( element in selectClass( "specLtblue" ) ) {
            checklists.add( Checklist.parseFromJsonTrElement( element ) );
        }
        return checklists;
    }
}