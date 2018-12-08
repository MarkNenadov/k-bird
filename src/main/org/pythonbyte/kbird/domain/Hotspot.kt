package org.pythonbyte.kbird.domain

import org.jsoup.nodes.Element
import KBirdConfiguration
import domain.DomainObject
import org.pythonbyte.kbird.base.GpsCoordinates

class Hotspot ( var name: String, var url: String ) : DomainObject() {
    var speciesCount: Number? = 0
    var coordinates: GpsCoordinates? = null

    companion object {
        fun createFromLinkElement( element: Element ) : Hotspot {
            return Hotspot( element.text(), element.attr( "href" ).replace( "/ebird/", "" ) )
        }
    }

    fun getAsMarkdownListItem( configuration: KBirdConfiguration): String {
        return "* [" + name + "](" + configuration.baseEBirdUrl + url + ") - " + speciesCount + " species (" + coordinates.toString() + ")"
    }
}
