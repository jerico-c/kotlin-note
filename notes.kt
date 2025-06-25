import java.io.File
import kotlin.text.toIntOrNull
// NEW IMPORTS for JSON serialization
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.JsonDecodingException

// --- NEW ANNOTATION ---
// This tells the kotlinx.serialization library that this class can be converted to/from JSON.
@Serializable
data class Note(val id: Int, val content: String)

// Define the file where notes will be stored.
val notesFile = File("notes.json")

// Function to save the list of notes to the JSON file.
fun saveNotesToFile(notes: List<Note>) {
    // We use a try-catch block to handle potential file writing errors.
    try {
        val jsonString = Json.encodeToString(notes)
        notesFile.writeText(jsonString)
    } catch (e: Exception) {
        println("Error: Could not save notes to file. ${e.message}")
    }
}

// Function to load notes from the JSON file when the app starts.
fun loadNotesFromFile(): MutableList<Note> {
    // Check if the file exists and is not empty.
    if (!notesFile.exists() || notesFile.readText().isBlank()) {
        return mutableListOf() // Return an empty list if no file or file is empty.
    }

    try {
        // Use a stream to decode for efficiency
        return Json.decodeFromStream(notesFile.inputStream())
    } catch (e: JsonDecodingException) {
        println("Error: Could not read or parse the notes file. It might be corrupted.")
        return mutableListOf() // Return an empty list on error
    } catch (e: Exception) {
        println("Error: Could not load notes from file. ${e.message}")
        return mutableListOf()
    }
}

fun main() {
    // --- MODIFIED STARTUP ---
    // Load existing notes from the file at the start.
    val notes = loadNotesFromFile()
    // Determine the next ID by finding the highest existing ID and adding 1.
    // This prevents using the same ID twice.
    var nextId = (notes.maxOfOrNull { it.id } ?: 0) + 1

    println("--- Welcome to your Kotlin Note-Taking App! ---")
    println("Available commands: :add, :view, :delete, :search, :exit")
    println("----------------------------------------------")

    while (true) {
        print("> ")
        val input = readLine() ?: ""

        when (input.trim().lowercase()) {
            ":add" -> {
                println("Enter your note content:")
                print(">> ")
                val noteContent = readLine() ?: ""
                if (noteContent.isNotBlank()) {
                    notes.add(Note(id = nextId, content = noteContent))
                    nextId++
                    saveNotesToFile(notes) // --- SAVE after adding
                    println("Note added and saved successfully!")
                } else {
                    println("Error: Note content cannot be empty.")
                }
            }
            ":view" -> {
                if (notes.isEmpty()) {
                    println("No notes yet. Use ':add' to create one.")
                } else {
                    println("--- Your Notes ---")
                    notes.forEach { println("${it.id}. ${it.content}") }
                    println("------------------")
                }
            }
            ":delete" -> {
                if (notes.isEmpty()) {
                    println("No notes to delete.")
                } else {
                    print("Enter the ID of the note to delete: ")
                    val idToDelete = readLine()?.toIntOrNull()

                    if (idToDelete == null) {
                        println("Error: Invalid ID. Please enter a number.")
                    } else {
                        val wasRemoved = notes.removeIf { it.id == idToDelete }
                        if (wasRemoved) {
                            saveNotesToFile(notes) // --- SAVE after deleting
                            println("Note with ID $idToDelete was deleted.")
                        } else {
                            println("Error: Note with ID $idToDelete not found.")
                        }
                    }
                }
            }
            ":search" -> {
                if (notes.isEmpty()) {
                    println("No notes to search in.")
                } else {
                    print("Enter search term: ")
                    val searchTerm = readLine() ?: ""
                    if (searchTerm.isNotBlank()) {
                        val searchResults = notes.filter { it.content.contains(searchTerm, ignoreCase = true) }
                        if (searchResults.isEmpty()) {
                            println("No notes found containing '$searchTerm'.")
                        } else {
                            println("--- Search Results for '$searchTerm' ---")
                            searchResults.forEach { println("${it.id}. ${it.content}") }
                            println("------------------------------------")
                        }
                    } else {
                        println("Error: Search term cannot be empty.")
                    }
                }
            }
            ":exit" -> {
                println("Goodbye!")
                return
            }
            else -> {
                println("Unknown command. Please use one of the following: :add, :view, :delete, :search, :exit")
            }
        }
        println()
    }
}

