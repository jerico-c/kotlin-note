Aplikasi Catatan CLI Sederhana (Kotlin)Selamat datang di repositori Aplikasi Catatan CLI! Ini adalah proyek sederhana yang dibuat untuk mendokumentasikan perjalanan belajar bahasa pemrograman Kotlin dengan membangun sesuatu yang praktis dari awal.Daftar IsiRingkasan Proyek 📝Fitur Utama ✨Prasyarat & Instalasi 🛠️Cara Penggunaan 🚀Struktur Kode 🏗️Troubleshooting 🧐Roadmap Pengembangan 🗺️Ringkasan Proyek 📝Aplikasi ini adalah sebuah program Command-Line Interface (CLI) sederhana untuk membuat, melihat, mencari, dan menghapus catatan. Tujuannya adalah untuk menerapkan konsep-konsep dasar Kotlin dalam sebuah proyek nyata yang fungsional, sehingga sangat cocok untuk pemula yang ingin mempraktikkan ilmunya.Fitur Utama ✨✅ Tambah Catatan: Menambahkan catatan baru ke dalam daftar.✅ Lihat Semua Catatan: Menampilkan semua catatan yang tersimpan beserta ID-nya.✅ Hapus Catatan: Menghapus catatan tertentu berdasarkan ID.✅ Cari Catatan: Mencari catatan yang mengandung kata kunci tertentu (tidak case-sensitive).✅ Antarmuka Interaktif: Berinteraksi dengan aplikasi melalui perintah sederhana di terminal.Prasyarat & Instalasi 🛠️Sebelum memulai, pastikan sistem Anda telah terpasang:JDK (Java Development Kit): Versi 11 atau yang lebih baru.Kotlin Compiler: Anda bisa menginstalnya melalui SDKMAN! atau mengunduhnya dari GitHub rilis Kotlin.Langkah-langkah untuk Menjalankan Aplikasi:Clone repositori ini:git clone https://github.com/NAMA_USER_ANDA/NAMA_REPO_ANDA.git
Masuk ke direktori proyek:cd NAMA_REPO_ANDA
Kompilasi kode Kotlin:Perintah ini akan mengompilasi file Main.kt menjadi sebuah file .jar yang bisa dieksekusi.kotlinc Main.kt -include-runtime -d CatatanApp.jar
Jalankan aplikasi:java -jar CatatanApp.jar
Sekarang aplikasi Anda siap digunakan!Cara Penggunaan 🚀Setelah aplikasi berjalan, Anda akan melihat pesan selamat datang dan daftar perintah yang tersedia.Contoh Sesi Penggunaan:Tampilan Awal--- Welcome to your Kotlin Note-Taking App! ---
Available commands: :add, :view, :delete, :search, :exit
----------------------------------------------
> 
Menambahkan Catatan Baru> :add
Enter your note content:
>> Belajar dasar-dasar Kotlin
Note added successfully!

> :add
Enter your note content:
>> Membuat aplikasi CLI pertama
Note added successfully!
Melihat Semua Catatan> :view
--- Your Notes ---
1. Belajar dasar-dasar Kotlin
2. Membuat aplikasi CLI pertama
------------------
Mencari Catatan> :search
Enter search term: aplikasi
--- Search Results for 'aplikasi' ---
2. Membuat aplikasi CLI pertama
------------------------------------
Menghapus Catatan> :delete
Enter the ID of the note to delete: 1
Note with ID 1 was deleted.

> :view
--- Your Notes ---
2. Membuat aplikasi CLI pertama
------------------
Keluar dari Aplikasi> :exit
Goodbye!
Struktur Kode 🏗️Kode sumber utama berada di file Main.kt. Berikut adalah penjelasan singkat dari komponen utamanya:data class Note(val id: Int, val content: String)Ini adalah data class yang berfungsi sebagai blueprint atau cetakan untuk objek catatan. Ia hanya bertugas untuk menyimpan data id dan content dari sebuah catatan.fun main()Fungsi utama tempat seluruh program dieksekusi. Di sinilah game loop aplikasi berada.val notes = mutableListOf<Note>()Sebuah MutableList (daftar yang bisa diubah) untuk menyimpan semua objek Note selama aplikasi berjalan.while (true)Sebuah infinite loop yang membuat aplikasi terus berjalan dan menunggu input dari pengguna hingga perintah :exit dimasukkan.when (input.trim().lowercase())Struktur kontrol when yang kuat di Kotlin. Ini digunakan untuk memeriksa perintah apa yang dimasukkan pengguna (:add, :view, dll.) dan menjalankan blok kode yang sesuai.Troubleshooting 🧐"command not found: kotlinc" atau "command not found: java"Masalah: Path ke Kotlin compiler atau Java tidak terdaftar di environment variables sistem Anda.Solusi: Pastikan Anda telah menginstal JDK dan Kotlin Compiler dengan benar dan path-nya sudah ditambahkan ke PATH sistem operasi Anda. Coba tutup dan buka kembali terminal Anda setelah instalasi.Aplikasi menampilkan "Error: Invalid ID" saat menghapus catatan.Masalah: Anda memasukkan teks yang bukan angka, atau ID yang Anda masukkan tidak ada di dalam daftar catatan.Solusi: Gunakan perintah :view terlebih dahulu untuk melihat ID catatan yang tersedia, lalu masukkan ID yang valid.Roadmap Pengembangan 🗺️Proyek ini akan terus dikembangkan seiring dengan pembelajaran Kotlin. Berikut adalah rencana ke depannya:[ ] Phase 3: Persistensi Data - Menyimpan catatan ke dalam sebuah file (misalnya notes.json) sehingga data tidak hilang saat aplikasi ditutup.[ ] Phase 4: Refactoring ke OOP - Mengatur ulang kode ke dalam beberapa kelas (misalnya NoteService, CommandHandler) untuk menerapkan prinsip Object-Oriented Programming.[ ] Ide Masa Depan: GUI - Mengembangkan antarmuka grafis sederhana menggunakan Jetpack Compose for Desktop.Terima kasih telah mengunjungi repositori ini. Selamat belajar Kotlin!
