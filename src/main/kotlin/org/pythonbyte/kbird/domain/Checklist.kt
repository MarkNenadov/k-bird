package org.pythonbyte.kbird.domain
import org.jsoup.nodes.Element

data class Checklist(
    var identifier: String = "",
    var personName: String = "",
    var location: String = "",
    var date: String = "",
    var time: String = "",
    var link: String = "",
    var speciesEntries: List<SpeciesEntry> = listOf(),
) : DomainObject() {
    companion object {
        fun parseFromJsonTrElement(element: Element): Checklist {
            return Checklist().apply {
                personName = element.select(".recent-visitor").text()
                location = element.select(".obstable-location").text()
                time = element.select("obstable-time").text()
                element.select(".obstable-date a").first()?.let { linkElement ->
                    link = linkElement.attr("href")
                    date = linkElement.text()
                    identifier = link.substringAfter("/view/checklist/")
                }
            }
        }
    }
}
