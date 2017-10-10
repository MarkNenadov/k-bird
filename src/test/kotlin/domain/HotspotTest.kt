package domain

import junit.framework.TestCase

class HotspotTest: TestCase() {
    fun testGetAsMarkdownListItem() {
        val configuration = KBirdConfiguration.loadConfiguration()
        val hotspot = Hotspot("Sleepy Hollows", "http://test.url" )
        assertEquals( "* [Sleepy Hollows](http://ebird.org/ebird/http://test.url) - 0 species (null)", hotspot.getAsMarkdownListItem( configuration ) )
    }
}