package SourceCode;

public class SingleLinkedListTransaksi {
    NodeTransaksi head;
    NodeTransaksi tail;

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(TransaksiLayanan input) {
        NodeTransaksi ndInput = new NodeTransaksi(input, null);

        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void tampilRiwayat(){
        NodeTransaksi tmp = head;
        System.out.println("-- Riwayat Transaksi --");
        System.out.println("Daftar Transaksi: ");
        if (isEmpty()) {
            System.out.println("Data transaksi kosong.");
        } else {
            while (tmp != null) {
                System.out.println(tmp.data.pasien.nama + " (" + tmp.data.durasiLayanan + ") " + ": Rp" + tmp.data.biaya);
                tmp = tmp.next;
            }
        }
    }
}
