public class AntrianPasien {
     int maxSize = 5;  
     Pasien[] antrian;
     int front;
     int rear;

    public AntrianPasien() {
        antrian = new Pasien[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize;
    }

    public void enqueue(Pasien pasien) {
        if (!isFull()) {
            antrian[rear++] = pasien;
            System.out.println("Pasien " + pasien.nama + " masuk antrian.");
        } else {
            System.out.println("Antrian penuh!");
        }
    }

    public Pasien dequeue() {
        if (!isEmpty()) {
            Pasien pasienKeluar = antrian[front];
            // Geser elemen ke depan
            for (int i = front; i < rear - 1; i++) {
                antrian[i] = antrian[i + 1];
            }
            rear--;
            return pasienKeluar;
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
        } else {
            System.out.println("Daftar Pasien dalam Antrian:");
            for (int i = front; i < rear; i++) {
                System.out.println((i - front + 1) + ". " + antrian[i].nama + " (" + antrian[i].nik + ") - Keluhan: " + antrian[i].keluhan);
            }
        }
    }

    public int sisaAntrian() {
        return rear - front;
    }
}
