import kotlin.text.toIntOrNull

// A simple data class to represent a single note.
data class Note(val id: Int, val content: String)

fun main() {
    // A mutable list to store the notes in memory while the app is running.
    val notes = mutableListOf<Note>()
    var nextId = 1 // A simple counter to assign unique IDs to new notes.

    println("--- Welcome to your Kotlin Note-Taking App! ---")
    // Updated the command list to include the new commands
    println("Available commands: :add, :view, :delete, :search, :exit")
    println("----------------------------------------------")

    // Main application loop. It will continue running until the user types ':exit'.
    while (true) {
        print("> ") // Prompt for user input.

        // readLine() reads a line of input from the standard input stream.
        val input = readLine() ?: ""

        // 'when' is Kotlin's powerful version of a switch statement.
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
                    println("Error: Note content cannot be empty.")
                }
            }
            ":view" -> {
                if (notes.isEmpty()) {
                    println("No notes yet. Use ':add' to create one.")
                } else {
                    println("--- Your Notes ---")
                    for (note in notes) {
                        println("${note.id}. ${note.content}")
                    }
                    println("------------------")
                }
            }
            // --- NEW FEATURE: DELETE A NOTE ---
            ":delete" -> {
                if (notes.isEmpty()) {
                    println("No notes to delete.")
                } else {
                    print("Enter the ID of the note to delete: ")
                    // toIntOrNull is a safe way to convert a String to an Int.
                    // It returns null if the string is not a valid number.
                    val idToDelete = readLine()?.toIntOrNull()

                    if (idToDelete == null) {
                        println("Error: Invalid ID. Please enter a number.")
                    } else {
                        // 'removeIf' removes all elements from the list that satisfy the predicate.
                        val wasRemoved = notes.removeIf { it.id == idToDelete }
                        if (wasRemoved) {
                            println("Note with ID $idToDelete was deleted.")
                        } else {
                            println("Error: Note with ID $idToDelete not found.")
                        }
                    }
                }
            }
            // --- NEW FEATURE: SEARCH FOR A NOTE ---
            ":search" -> {
                 if (notes.isEmpty()) {
                    println("No notes to search in.")
                } else {
                    print("Enter search term: ")
                    val searchTerm = readLine() ?: ""
                    if (searchTerm.isNotBlank()) {
                        // 'filter' creates a new list containing elements that match the predicate.
                        // 'ignoreCase = true' makes the search case-insensitive.
                        val searchResults = notes.filter { it.content.contains(searchTerm, ignoreCase = true) }

                        if (searchResults.isEmpty()) {
                            println("No notes found containing '$searchTerm'.")
                        } else {
                            println("--- Search Results for '$searchTerm' ---")
                            for (note in searchResults) {
                                println("${note.id}. ${note.content}")
                            }
                            println("------------------------------------")
                        }
                    } else {
                        println("Error: Search term cannot be empty.")
                    }
                }
            }
            ":exit" -> {
                println("Goodbye!")
                return // Exits the main function, thus terminating the program.
            }
            else -> {
                // Better error message for unknown commands.
                println("Unknown command. Please use one of the following: :add, :view, :delete, :search, :exit")
            }
        }
        println() // Print a blank line for better readability.
    }
}
