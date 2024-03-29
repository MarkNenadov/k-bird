package org.pythonbyte.kbird.domain

import KBirdConfiguration
import org.jsoup.nodes.Element
import org.pythonbyte.krux.mapping.GpsCoordinates

class Hotspot(
    val name: String,
    val url: String,
    var speciesCount: Number? = 0,
    var coordinates: GpsCoordinates? = null,
) : DomainObject() {
    companion object {
        fun createFromLinkElement(element: Element): Hotspot {
            return Hotspot(
                name = element.text(),
                url = element.attr("href").replace("/ebird/", ""),
            )
        }
    }

    fun getAsMarkdownListItem(configuration: KBirdConfiguration): String {
        val speciesCountText = speciesCount?.toString() ?: "unknown"
        val coordinatesText = coordinates?.toString() ?: "unknown"

        return "* [$name](${configuration.baseEBirdUrl}$url) - $speciesCountText species ($coordinatesText)"
    }
}
