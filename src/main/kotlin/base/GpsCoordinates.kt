package base

class GpsCoordinates( longitudeLatitude: String? ) {
    var longitude: Float = longitudeLatitude!!.replace( " ", "").split( "," ).get( 0 ).toFloat();
    var latitude: Float = longitudeLatitude!!.replace( " ", "").split( "," ).get( 1 ).toFloat();

    override fun toString() : String {
        return longitude.toString() + "," + latitude.toString()
    }
}