import java.util.Scanner;

public class Fungsi01 {

    public static final String[] Cabang = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};
    public static final String[] Jenis = {"Aglonema", "Keladi", "Alocasia", "Mawar"};
    public static final int[][] Stock_Bunga = {{10, 6, 2, 5}, {5, 11, 10, 7}, {15, 9, 10, 12}, {7, 12, 12, 9}};
    public static final int[] Harga_Bunga = {75000, 50000, 60000, 10000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pendapatan setiap Cabang jika semua bunga habis terjual:");
        for (int i = 0; i < Cabang.length; i++) {
            int pendapatanCabang = 0;
            for (int j = 0; j < Jenis.length; j++) {
                pendapatanCabang += Stock_Bunga[i][j] * Harga_Bunga[j];
            }
            System.out.printf("%s: Rp %,d\n", Cabang[i], pendapatanCabang);
        }

        System.out.println("\nJumlah stock setiap jenis bunga pada Cabang RoyalGarden:");
        for (int i = 0; i < Jenis.length; i++) {
            int totalStock = 0;
            for (int j = 0; j < Cabang.length; j++) {
                totalStock += Stock_Bunga[j][i];
            }
            System.out.printf("%s: %d\n", Jenis[i], totalStock);
        }

        System.out.println("\nPengurangan stock bunga karena bunga mati:");
        for (int i = 0; i < Jenis.length; i++) {
            int penguranganStock = 0;
            switch (i) {
                case 0:
                    penguranganStock = 1;
                    break;
                case 1:
                    penguranganStock = 2;
                    break;
                case 3:
                    penguranganStock = 5;
                    break;
            }
            Stock_Bunga[0][i] -= penguranganStock;
            System.out.printf("%s: %d\n", Jenis[i], penguranganStock);
        }

        System.out.println("\nStock bunga setelah pengurangan:");
        for (int i = 0; i < Cabang.length; i++) {
            for (int j = 0; j < Jenis.length; j++) {
                System.out.printf("%d ", Stock_Bunga[i][j]);
            }
            System.out.println();
        }
    }
}
