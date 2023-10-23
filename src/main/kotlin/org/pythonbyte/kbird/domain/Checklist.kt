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
            val checklist = Checklist().apply {
                personName = element.select(".recent-visitor" ).text()
                location = element.select( ".obstable-location" ).text()
                time = element.select( "obstable-time").text()
                identifier = this.link.replace( "/view/checklist/", "" )

                val linkElement = element.select( ".obstable-date" ).select( "a" ).first()

                link = linkElement?.attr( "href" ) ?: ""
                date = linkElement?.text() ?: ""
            }

            return checklist
        }
    }
}
