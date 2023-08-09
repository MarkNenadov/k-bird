package org.pythonbyte.kbird.domain

import org.jsoup.nodes.Element
import KBirdConfiguration
import org.pythonbyte.krux.mapping.GpsCoordinates

class Hotspot ( val name: String, val url: String ) : DomainObject() {
    var speciesCount: Number? = 0
    var coordinates: GpsCoordinates? = null

    companion object {
        fun createFromLinkElement( element: Element ) : Hotspot {
            return Hotspot( element.text(), element.attr( "href" ).replace( "/ebird/", "" ) )
        }
    }

    fun getAsMarkdownListItem( configuration: KBirdConfiguration): String {
        val speciesCountText = speciesCount?.toString() ?: "unknown"
        val coordinatesText = coordinates?.toString() ?: "unknown"

        return "* [$name](${configuration.baseEBirdUrl}$url) - $speciesCountText species ($coordinatesText)"
    }
}
