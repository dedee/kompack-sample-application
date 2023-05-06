import com.wunderbee.kompack.mpack.coders.MessagePackEncoder
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Sample1 {

    @Serializable
    data class Entry(val name: String, val street: String, val zip: Int, val city: String)

    @Serializable
    data class AddressBook(val entries: List<Entry>)

    init {
        val addressBook = AddressBook(
            listOf(
                Entry("Heinz A. Mueller", "State St. 8", 31232, "Kalamazoo"),
                Entry("Max Mustermann", "Schlossstr. 8", 78334, "Ludwigsburg"),
            )
        )

        val encodedByteArray = MessagePackEncoder.encodeToByteArray(addressBook)
        println("Encoded address book into ${encodedByteArray.size} bytes")
        // Encoded address book into 89 bytes

        val jsonString = Json.encodeToString(addressBook)
        println("Encoded address book into ${jsonString.length} chars")
        // Encoded address book into 179 chars
    }

}
