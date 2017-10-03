package parsers

import org.jsoup.Jsoup

open class BasePageParser(url: String ) {
    var pageDocument = Jsoup.connect( url ).get();
}