package org.pythonbyte.kbird.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HotspotTest {
    @Test
    fun testGetAsMarkdownListItem() {
        val configuration = KBirdConfiguration.loadConfiguration()
        val hotspot = Hotspot("Sleepy Hollows", "http://test.url" )
        assertEquals( "* [Sleepy Hollows](http://ebird.org/http://test.url) - 0 species (unknown)", hotspot.getAsMarkdownListItem( configuration ) )
    }
}