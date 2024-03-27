package minggu7;

import java.util.Scanner;

public class MahasiswaMain22 {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            try (Scanner sl = new Scanner(System.in)) {
                PencarianMhs22 data = new PencarianMhs22();

                System.out.print("Masukkan jumlah mahasiswa: ");
                int jumMhs = s.nextInt();

                System.out.println("-------------------------------------------------------");
                System.out.println("Masukkan data mahasiswa secara Urut dari Nim Terkecil :");
                for (int i = 0; i < jumMhs; i++) {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Nim\t : ");
                    int nim = s.nextInt();
                    System.out.println("Nama\t :");
                    String nama = sl.nextLine();
                    System.out.println("Umur\t :");
                    int umur = s.nextInt();
                    System.out.println("IPK\t :");
                    double ipk = s.nextDouble();

                    Mahasiswa22 m = new Mahasiswa22(nim, nama, umur, ipk);
                    data.tambah(m);
                }

                System.out.println("--------------------------------------");
                System.out.println("Data keseluruhan Mahasiswa : ");
                data.tampil();

                System.out.println("______________________________________");
                System.out.println("______________________________________");
                System.out.println("Pencarian Data : ");
                System.out.println("Masukkan Nama Mahasiswa yang dicari: ");
                System.out.println("Nama: ");
                String cariNama = sl.nextLine();

                System.out.println("===============================");
                System.out.println("Menggunakan Binary Search");
                int posisi = data.FindBinarySearch(cariNama, 0, jumMhs - 1);

                if (posisi != -1) {
                    // Mengecek jika terdapat hasil duplikat
                    int duplicateCount = 1;
                    int left = posisi - 1;
                    while (left >= 0 && data.listMhs[left].nama.equals(cariNama)) {
                        duplicateCount++;
                        left--;
                    }

                    int right = posisi + 1;
                    while (right < jumMhs && data.listMhs[right].nama.equals(cariNama)) {
                        duplicateCount++;
                        right++;
                    }

                    if (duplicateCount > 1) {
                        System.out.println("Ditemukan lebih dari 1 hasil dengan nama '" + cariNama + "'.");
                    } else {
                        System.out.println("Mahasiswa dengan nama '" + cariNama + "' ditemukan pada indeks " + posisi);
                        data.TampilData(data.listMhs[posisi].nim, posisi);
                    }
                } else {
                    System.out.println("Mahasiswa dengan nama '" + cariNama + "' tidak ditemukan.");
                }
            }
        }
    }
}
