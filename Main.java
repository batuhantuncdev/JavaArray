public class Main {

    static int array[][] = {
            {18060311,40},
            {20060045,50},
            {19061091,75},
            {20060134,90},
            {20060678,40},
            {18061086,75},
            {20060032,50},
            {20060067,60},
            {19060456,60},
            {18060245,75},
            {20060110,40},
            {20060234,90},
            {20060141,60},
            {20060011,50},
            {20060012,60}
    };


    public static void main(String[] args) {

        System.out.println("Sıralanmış Index Tablosu: ");
        sirala(array);
        System.out.println("\t");
        yazdir(array, 65);  // yazdır fonksiyonu örnek
        System.out.println("\t");
        ekle(array, 12312111, 85);  // ekle fonksiyonu örnek
        System.out.println("\t");
        degistir(array, 20060012, 10); // değiştir fonksiyonu örnek

    }

    // Sırala
    static void sirala(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j += 2) {

                indexTablosuSirala(a);
                System.out.print("Ders Notu: " + a[i][j]);
                System.out.println(" Öğrenci No: " + a[i][j-1]);
            }
        }
    }

    // Girilenden yüksek not alan öğrencileri gösteren fonksiyon
    static void yazdir(int[][] a, int not){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length; j += 2) {

                if (a[i][j] > not) {
                    System.out.println("Girilen Not: " +not + " Girilenden Yüksek Not: " + a[i][j] + " Ögrenci No: " + a[i][j - 1]);
                }
            }
        }

    }

    // Girilen Indexi Ekleyip  Sıralar
    static void ekle(int[][] a, int ogrenciNo, int dersNotu){

        a[a.length - 1][0] = ogrenciNo;
        a[a.length - 1][1] = dersNotu;

        System.out.println("Yeni Eklenen Ogrenciden Sonraki Sıralama: ");
        sirala(a);
    }

    // Ders notu değiştirilen Ogrencinin Tablodaki yerini güncelleyen fonksiyon
    static void degistir(int[][] a, int ogrenciNo, int dersNotu){
        System.out.println("Ogrenci Notu Değiştirildikten Sonraki Sıralama: ");

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j += 2) {
                if(ogrenciNo == a[i][j-1]) {
                    a[i][j] = dersNotu;

                }
            }
        }
        sirala(a);

    }

    // Verilen indeksi index tablosundan silen fonksiyon
    static void sil(int[][] a, int d[], int ind){
        int i = 0,j = 0;
        while (i<array.length){
            d[i] = d[j];
            if(d[j] != ind){
                i++;
            }
            j++;
        }
    }



    // Verilen Koşullara Göre Sıralama Yapan Fonksiyon
    static void indexTablosuSirala(int[][] a) {
        boolean sorted = false;
        int tempDersNotu;
        int tempOgrenciNo;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                for(int j = 1; j<array[i].length; j+=2){

                    if (a[i][j] < a[i+1][j]) {

                        tempOgrenciNo = a[i][j-1];
                        a[i][j-1] = a[i+1][j-1];
                        a[i+1][j-1] = tempOgrenciNo;

                        tempDersNotu = a[i][j];
                        a[i][j] = a[i+1][j];
                        a[i+1][j] = tempDersNotu;

                        sorted = false;

                    }

                    if(a[i][j] == a[i+1][j]){
                        if(a[i][j-1] > a[i+1][j-1]){
                            tempOgrenciNo = a[i][j-1];
                            a[i][j-1] = a[i+1][j-1];
                            a[i+1][j-1] = tempOgrenciNo;

                            tempDersNotu = a[i][j];
                            a[i][j] = a[i+1][j];
                            a[i+1][j] = tempDersNotu;

                            sorted = false;
                        }
                    }

                }

            }
        }

    }

}