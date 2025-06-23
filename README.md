Kotlin Journey: Command-Line Note-Taking App
This repository documents my learning progress in the Kotlin programming language by building a practical command-line application from scratch.

Project Concept: Simple Note Taker
The goal is to create a functional note-taking application that runs in the terminal. Users can add, view, and delete notes. This project serves as a practical way to apply fundamental Kotlin concepts.

Core Learning Objectives
Variables & Data Types: Storing note content and IDs.

Control Flow: Using when, if/else, and loops to manage user commands.

Collections: Using MutableList to hold the notes in memory.

Functions: Organizing code into reusable blocks for adding, viewing, and deleting notes.

User Input: Reading commands and note text from the console.

Data Classes: Creating a simple Note class to structure the data.

Phase 1: The Basics (Complete)
This is the first version of the application, covering the essential features.

Features:
Welcome Message: Displays a welcome message and available commands.

Add a Note: A command (:add) to add a new note.

View All Notes: A command (:view) to display all notes.

Exit: A command (:exit) to gracefully exit the application.

Example Usage Flow:
Welcome to your Note-Taking App!
Commands: :add, :view, :exit

> :add
Enter your note: Learn Kotlin data classes
Note added!

> :add
Enter your note: Build the first version of my app
Note added!

> :view
1. Learn Kotlin data classes
2. Build the first version of my app

> :exit
Goodbye!

Future Phases: Expanding Your Skills
As I learn more Kotlin, I plan to enhance this project with new features.

Planned Enhancements:
Phase 2: Improved Functionality

Delete a Note: Add a :delete command that removes a note by its ID.

Search Notes: Implement a :search command to find notes containing a specific keyword.

Error Handling: Add checks for invalid commands or inputs.

Phase 3: Data Persistence

File I/O: Save notes to a file (e.g., notes.json) so they persist between sessions.

Phase 4: Advanced Concepts

OOP Refactoring: Restructure the code into classes like a NoteService to better manage logic.

GUI: Potentially build a simple graphical user interface using Jetpack Compose for Desktop.
