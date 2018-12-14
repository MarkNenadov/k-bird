package org.pythonbyte.kbird.base

class GpsCoordinates {
    var longitude : Float
    var latitude : Float

    constructor(longitudeLatitude: String?) {
        val cleanedValue = cleanSpaces(longitudeLatitude!!)

        if ( cleanedValue.contains(",") ) {
            val splitValues = cleanedValue.split(",")

            if ( splitValues.size != 1 ) {
                longitude = splitValues.get(0).toFloat();
                latitude = splitValues.get(1).toFloat();
            } else {
                throw GpsCoordinateFormattingException( "Value [" + longitudeLatitude + "] doesn't represent valid GPS coordinates. too many commas." );
            }
        } else {
            throw GpsCoordinateFormattingException( "Value [" + longitudeLatitude + "] doesn't represent valid GPS coordinates. ',' is missing" );
        }
    }

    override fun toString() : String {
        return longitude.toString() + "," + latitude.toString()
    }

    private fun cleanSpaces(value: String): String {
        return value.replace( " ", "")
    }
}