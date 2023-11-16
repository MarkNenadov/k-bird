package org.pythonbyte.kbird.parsers

import org.pythonbyte.kbird.domain.Checklist

class CountyRecentVisitsPageParser(
    countyCode: String,
) : BasePageParser("http://ebird.org/ebird/subnational2/$countyCode/activity") {
    fun fetchRecentChecklists(): List<Checklist> {
        return selectClass("specLtblue").map {
            Checklist.parseFromJsonTrElement(it)
        }
    }
}
