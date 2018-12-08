package org.pythonbyte.kbird.domain

import junit.framework.TestCase.assertEquals
import org.junit.Test

class HotspotTest {
    @Test
    fun testGetAsMarkdownListItem() {
        val configuration = KBirdConfiguration.loadConfiguration()
        val hotspot = Hotspot("Sleepy Hollows", "http://test.url" )
        assertEquals( "* [Sleepy Hollows](http://ebird.org/ebird/http://test.url) - 0 species (null)", hotspot.getAsMarkdownListItem( configuration ) )
    }
}