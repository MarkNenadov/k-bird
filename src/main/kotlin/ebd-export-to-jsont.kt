import java.io.File
import java.io.PrintWriter

fun main(args: Array<String> ) {
    val edbFilePath = "C:\\java\\k-bird\\aebd_CA-ON-ES_relAug-2017\\ebd_CA-ON-ES_relAug-2017.txt"
    val outputJsonFile = "C:\\java\\k-bird\\aebd_CA-ON-ES_relAug-2017\\output.json"
    exportToJson( edbFilePath, outputJsonFile )
}
fun exportToJson(edbFilePath: String, outputJsonFile: String) {
    val writer = PrintWriter( outputJsonFile )

    val bufferedReader = File( edbFilePath ).bufferedReader()
    val fieldNames = bufferedReader.readLine().split("\t")

    for (line in bufferedReader.readLines()) {
        val lineValues = line.split("\t")
        writer.append("{\n\t")
        for ((index,value) in lineValues.withIndex() ) {
            if ( value != "" ) {
                writer.append("\"${fieldNames[index]}\": \"$value\"")
                if (index < lineValues.size - 2) {
                    writer.append(",")
                }
                writer.append("\n")
            }
        }
        writer.append("\n}")
    }
    writer.close()
    bufferedReader.close()
}
