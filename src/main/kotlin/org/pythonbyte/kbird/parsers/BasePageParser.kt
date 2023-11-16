package org.pythonbyte.kbird.parsers

import org.jsoup.Jsoup
import org.jsoup.select.Elements

open class BasePageParser(url: String) {
    private var pageDocument = Jsoup.connect(url).get()

    fun selectClass(className: String): Elements {
        return pageDocument.select(".$className")
    }
}
