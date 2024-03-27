package minggu7;

public class PencarianMhs22 {
    Mahasiswa22 listMhs[] = new Mahasiswa22[5];
    int idx;

    void tambah(Mahasiswa22 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh !!");
        }
    }

    void tampil() {
        for (Mahasiswa22 m : listMhs) {
            m.tampil();
            System.out.println("----------------------");
        }
    }

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].nim == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public void Tampilposisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("Data dengan NIM " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data dengan NIM " + x + " tidak ditemukan.");
        }
    }

    public void TampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("NIM\t : " + x);
            System.out.println("Nama\t : " + listMhs[pos].nama);
            System.out.println("Umur\t : " + listMhs[pos].umur);
            System.out.println("IPK\t : " + listMhs[pos].ipk);
        } else {
            System.out.println("Data dengan NIM " + x + " tidak ditemukan.");
        }
    }

    public int FindBinarySearch(String cari, int left, int right) {
        // Menambahkan kondisi jika right kurang dari left
        if (right < left) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (cari.compareTo(listMhs[mid].nama) == 0) {
            return mid;
        } else if (cari.compareTo(listMhs[mid].nama) > 0) {
            return FindBinarySearch(cari, mid + 1, right);  // Pencarian di bagian kanan
        } else {
            return FindBinarySearch(cari, left, mid - 1);   // Pencarian di bagian kiri
        }
    }
}
