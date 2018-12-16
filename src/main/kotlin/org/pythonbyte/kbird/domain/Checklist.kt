package org.pythonbyte.kbird.domain
import org.jsoup.nodes.Element

class Checklist: DomainObject() {
    var identifier: String = ""
    var personName: String = ""
    var location: String = ""
    var date: String = ""
    var time: String = ""
    var link: String = ""
    var speciesEntries = ArrayList<SpeciesEntry>()

    companion object {
        fun parseFromJsonTrElement( element: Element ) : Checklist {
            val checklist = Checklist()
            checklist.personName = element.select(".recent-visitor" ).text()
            checklist.location = element.select( ".obstable-location" ).text()
            checklist.time = element.select( "obstable-time").text()

            val linkElement = element.select( ".obstable-date" ).select( "a" ).first()
            checklist.link = linkElement.attr( "href" )
            checklist.identifier = checklist.link.replace( "/view/checklist/", "" )
            checklist.date = linkElement.text()

            return checklist
        }
    }
}
