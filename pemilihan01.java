import java.util.Scanner;

public class pemilihan01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nilai = new double[4];
        for (int i = 0; i < nilai.length; i++) {
            System.out.printf("Masukkan nilai %s: ", i == 0 ? "tugas" : (i == 1 ? "kuis" : (i == 2 ? "UTS" : "UAS")));
            nilai[i] = scanner.nextDouble();
        }

        if (!validasiNilai(nilai)) {
            System.out.println("Nilai tidak valid");
            return;
        }

        double nilaiAkhir = hitungNilaiAkhir(nilai);
        String nilaiHuruf = konversiNilaiHuruf(nilaiAkhir);
        String keterangan = konversiKeterangan(nilaiHuruf);

        System.out.println("Nilai akhir: " + nilaiAkhir);
        System.out.println("Nilai huruf: " + nilaiHuruf);
        System.out.println("Keterangan: " + keterangan);
    }

    private static boolean validasiNilai(double[] nilai) {
        for (double n : nilai) {
            if (n < 0 || n > 100) {
                return false;
            }
        }
        return true;
    }

    private static double hitungNilaiAkhir(double[] nilai) {
        double[] bobot = {0.2, 0.2, 0.3, 0.4};
        double total = 0;
        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i] * bobot[i];
        }
        return total;
    }

    private static String konversiNilaiHuruf(double nilaiAkhir) {
        if (nilaiAkhir >= 80) {
            return "A";
        } else if (nilaiAkhir >= 73) {
            return "B+";
        } else if (nilaiAkhir >= 65) {
            return "B";
        } else if (nilaiAkhir >= 60) {
            return "C+";
        } else if (nilaiAkhir >= 50) {
            return "C";
        } else if (nilaiAkhir >= 39) {
            return "D";
        } else {
            return "E";
        }
    }

    private static String konversiKeterangan(String nilaiHuruf) {
        return nilaiHuruf.equals("E") ? "TIDAK LULUS" : "LULUS";
    }
}
