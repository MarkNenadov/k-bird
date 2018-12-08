package domain

import com.cedarsoftware.util.io.JsonWriter

open class DomainObject {
    fun getJson(): String {
        return JsonWriter.objectToJson( this )
    }
}