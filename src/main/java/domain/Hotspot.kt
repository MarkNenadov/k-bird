package domain

import org.jsoup.nodes.Element

class Hotspot ( var name: String, var url: String ) : DomainObject() {
    companion object {
        fun createFromLinkElement( element: Element ) : Hotspot {
            return Hotspot( element.text(), element.attr( "href" ) )
        }
    }
}
