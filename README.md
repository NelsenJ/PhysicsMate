# PhysicsMate

## Fitur Utama
- Menampilkan daftar rumus fisika lengkap dengan penjelasan.
- Kalkulator rumus yang bisa menghitung nilai berdasarkan variabel yang diinput.
- User interface yang sederhana dan mudah digunakan dengan menu pilihan rumus.
- Fitur switch input/output untuk memudahkan perhitungan dari berbagai variabel.

## Cara Menjalankan Aplikasi

### Prasyarat
- Java Development Kit (JDK) sudah terinstall.
- JavaFX SDK versi 24.0.1 (atau sesuaikan dengan versi yang digunakan).

### Langkah Clone dan Jalankan

1. Clone repository ini ke komputer kamu:

   ```bash
   git clone https://github.com/NelsenJ/PhysicsMate.git
   cd PhysicsMate
   ```

2. Compile kode sumber dan salin resource dengan perintah:

   ```bash
   javac --module-path C:/javafx-sdk-24.0.1/lib --add-modules javafx.controls,javafx.fxml -d out src/main/java/physicsmate/*.java
   cp -r src/main/resources/* out/
   ```

3. Jalankan aplikasi dengan perintah:

   ```bash
   java --module-path C:/javafx-sdk-24.0.1/lib --add-modules javafx.controls,javafx.fxml -cp out physicsmate.Main
   ```

Pastikan path JavaFX SDK sesuai dengan lokasi di komputer.

