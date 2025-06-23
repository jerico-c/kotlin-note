// A simple data class to represent a single note.
// 'val' properties are read-only.
data class Note(val id: Int, val content: String)

fun main() {
    // A mutable list to store the notes in memory while the app is running.
    val notes = mutableListOf<Note>()
    var nextId = 1 // A simple counter to assign unique IDs to new notes.

    println("--- Welcome to your Kotlin Note-Taking App! ---")
    println("Available commands: :add, :view, :exit")
    println("----------------------------------------------")

    // Main application loop. It will continue running until the user types ':exit'.
    while (true) {
        print("> ") // Prompt for user input.

        // readLine() reads a line of input from the standard input stream.
        // The '?: ""' part is the Elvis operator, which provides an empty string
        // if readLine() returns null (e.g., if the input stream is closed).
        val input = readLine() ?: ""

        // 'when' is Kotlin's powerful version of a switch statement.
        // We use it here to handle the different user commands.
        when (input.trim().lowercase()) {
            ":add" -> {
                println("Enter your note content:")
                print(">> ")
                val noteContent = readLine() ?: ""
                if (noteContent.isNotBlank()) {
                    notes.add(Note(id = nextId, content = noteContent))
                    nextId++ // Increment the ID for the next note.
                    println("Note added successfully!")
                } else {
                    println("Note content cannot be empty.")
                }
            }
            ":view" -> {
                if (notes.isEmpty()) {
                    println("No notes yet. Use ':add' to create one.")
                } else {
                    println("--- Your Notes ---")
                    // Iterate over the 'notes' list and print each one.
                    for (note in notes) {
                        println("${note.id}. ${note.content}")
                    }
                    println("------------------")
                }
            }
            ":exit" -> {
                println("Goodbye!")
                return // Exits the main function, thus terminating the program.
            }
            else -> {
                // This block is executed if the input doesn't match any of the commands.
                println("Unknown command. Please use one of the following: :add, :view, :exit")
            }
        }
        println() // Print a blank line for better readability.
    }
}
