package org.pythonbyte.kbird.domain

import com.cedarsoftware.util.io.JsonWriter

open class DomainObject {
    fun getJson() = JsonWriter.objectToJson( this )
}