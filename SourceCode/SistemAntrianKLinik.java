package SourceCode;

import java.util.Scanner;

public class SistemAntrianKLinik {
    public static void main(String[] args) {
        AntrianPasien queue = new AntrianPasien();
        SingleLinkedListTransaksi riwayat = new SingleLinkedListTransaksi();
        int pilihan;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.println();
                    System.out.println("-- Antrian Pasien --");
                    System.out.print("Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIK: ");
                    String nik = scanner.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhan = scanner.nextLine();
                    Pasien infoPasien = new Pasien(nama, nik, keluhan);
                    queue.enqueue(infoPasien);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("-- Antrian Pasien --");
                    queue.tampilkanAntrian();
                    System.out.println();
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        Pasien pasien = queue.dequeue();
                        System.out.print("Masukkan ID Dokter: ");
                        String idDokter = scanner.nextLine();
                        System.out.print("Masukkan Nama Dokter: ");
                        String namaDokter = scanner.nextLine();
                        System.out.print("Masukkan Durasi Layanan (jam): ");
                        int durasi = scanner.nextInt();
                        Dokter dokter = new Dokter(idDokter, namaDokter);
                        TransaksiLayanan transaksi = new TransaksiLayanan(pasien, dokter, durasi);
                        riwayat.add(transaksi);
                        System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat");
                        
                    } else {
                        System.out.println("Tidak ada pasien dalam antrian.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Sisa pasien dalam antrian: " + queue.sisaAntrian());
                    System.out.println();
                    break;
                case 5:
                    riwayat.tampilRiwayat();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
    }

}
