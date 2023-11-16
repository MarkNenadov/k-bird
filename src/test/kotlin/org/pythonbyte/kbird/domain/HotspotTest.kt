package org.pythonbyte.kbird.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HotspotTest {
    @Test
    fun getJson() {
        val expectedJson = "{\"@type\":\"org.pythonbyte.kbird.domain.Hotspot\",\"name\":\"Sleepy Hollows\",\"url\":\"http://test.url\",\"speciesCount\":{\"@type\":\"int\",\"value\":0},\"coordinates\":null}"

        val hotspot = Hotspot("Sleepy Hollows", "http://test.url")
        assertEquals(expectedJson, hotspot.getJson())
    }

    @Test
    fun testGetAsMarkdownListItem() {
        val configuration = KBirdConfiguration.loadConfiguration()
        val hotspot = Hotspot("Sleepy Hollows", "http://test.url")
        assertEquals(
            "* [Sleepy Hollows](http://ebird.org/http://test.url) - 0 species (unknown)",
            hotspot.getAsMarkdownListItem(configuration),
        )
    }
}
