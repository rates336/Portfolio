package gameHub.ludo;

import java.util.Random;
import java.util.Scanner;

public class s25417_p02 {
    int[][] kolorPozycjaPionka;
    Scanner scanner = new Scanner(System.in);
    char[] plansza = new char[40];
    public static void main(String[] args) {
        s25417_p02 s = new s25417_p02();
        s.start();
        //System.out.println(s.kolorPozycjaPionka[0].length);

    }
    public void start() {
        boolean czyBylo6 = false;
        System.out.println("podaj ilosc graczy");
        int temp = scanner.nextInt();
        while (temp > 4 || temp < 2) {
            System.out.println("nieprawidlowa ilosc graczy minimum to 2, a maxium to 4");
        }
        for (int i = 0; i < plansza.length; i++) {
            plansza[i] = 'x';
        }
        kolorPozycjaPionka = new int[temp][4];
        System.out.println("za jakiego gracza rzucasz (podaj litere od a do d)");
        char symbol = scanner.next().charAt(0);
        boolean czyGraczJestNaPlanszy = false;
        for (int i = 0; i < plansza.length; i++) {
            if (plansza[i] == symbol) {
                czyGraczJestNaPlanszy = true;
                break;
            }
        }
        if (czyGraczJestNaPlanszy) {
            ruszSie(symbol);
        } else {
            czyBylo6 = wyjscieZBazy();
            if (czyBylo6) {
                if (symbol == 'a')
                    plansza[0] = 'a';
                if (symbol == 'b')
                    plansza[10] = 'b';
                if (symbol == 'c')
                    plansza[20] = 'c';
                if (symbol == 'd')
                    plansza[30] = 'd';

            }
        }
        wyrysujPlansze();
        System.out.println("za jakiego gracza rzucasz (podaj litere od a do d)");
        symbol = scanner.next().charAt(0);
        while (czyWygralKtos(symbol)) {


            for (int i = 0; i < plansza.length; i++) {
                if (plansza[i] == symbol) {
                    czyGraczJestNaPlanszy = true;
                    break;
                }
            }
            if (czyGraczJestNaPlanszy) {
                ruszSie(symbol);
            } else {
                czyBylo6 = wyjscieZBazy();
                if (czyBylo6) {
                    if (symbol == 'a')
                        plansza[0] = 'a';
                    if (symbol == 'b')
                        plansza[10] = 'b';
                    if (symbol == 'c')
                        plansza[20] = 'c';
                    if (symbol == 'd')
                        plansza[30] = 'd';

                }
            }
            wyrysujPlansze();
            System.out.println("za jakiego gracza rzucasz (podaj litere od a do d)");
            symbol = scanner.next().charAt(0);
        }
    }
    public void start(int iloscGraczy, int[][] kolorPozycjaPionka,
                      int[] tablicaLosowan, int[] tablicaDecyzji) {

    }
    public boolean wyjscieZBazy(){
        int pozostaleProby = 3;
        int wynikRzutu = 0;
        while (pozostaleProby > 0 && wynikRzutu != 6) {
            wynikRzutu = rzutKostka();
            System.out.println(wynikRzutu);
            if(wynikRzutu != 6)
                pozostaleProby--;
            else {
                return true;
            }

        }
        return false;
    }
    public int rzutKostka() {
        return new Random().nextInt(6) + 1;
    }
    public boolean czyWygralKtos(char symbol) {
        boolean czyWygrana;
        czyWygrana = kolorPozycjaPionka[symbol][0] == 100 && kolorPozycjaPionka[symbol][1] == 100 &&
                kolorPozycjaPionka[symbol][2] == 100 && kolorPozycjaPionka[symbol][3] == 100;
        return czyWygrana;
    }
    public boolean ruszSie(char symbol) {
        boolean czyWygrana = false;
        int wynikRzutu = rzutKostka();
        System.out.println("wybierz nr pionka");
        int nrPionka = scanner.nextInt();
        while (nrPionka > 4 || nrPionka < 1) {
            System.out.println("zly numer");
            nrPionka = scanner.nextInt();
        }
        int temp = kolorPozycjaPionka[symbol][nrPionka];
        while (temp == 100) {
            System.out.println("wybrales pionka, ktory jest w domku");
            System.out.println("wybierz dobrego");
            nrPionka = scanner.nextInt();
            while (nrPionka > 4 || nrPionka < 1) {
                System.out.println("zly numer");
                nrPionka = scanner.nextInt();
            }
            temp = kolorPozycjaPionka[symbol][nrPionka];
        }
        temp += wynikRzutu;
        if(symbol == 'a' && temp > 40) {
            kolorPozycjaPionka[symbol][nrPionka] = 100;
        } else
        if(symbol == 'b' && temp > 50) {
            kolorPozycjaPionka[symbol][nrPionka] = 100;
        } else
        if(symbol == 'c' && temp > 60) {
            kolorPozycjaPionka[symbol][nrPionka] = 100;
        } else
        if(symbol == 'd' && temp > 70) {
            kolorPozycjaPionka[symbol][nrPionka] = 100;
        } else {
            plansza[temp % 40] = symbol;
        }
        return czyWygralKtos(symbol);
    }

    public void tablicaDecyzji() {

    }
    public void wyrysujPlansze() {


        System.out.println("               0           ");
        System.out.println("           "+plansza[38]+" "+plansza[39]+" "+plansza[0]+"           ");
        System.out.println("           "+plansza[37]+"   "+plansza[1]+"           ");
        System.out.println("           "+plansza[36]+"   "+plansza[2]+"           ");
        System.out.println("           "+plansza[35]+"   "+plansza[3]+"           ");
        System.out.println("30 "+plansza[30]+" "+plansza[31]+" "+plansza[32]+" "+plansza[33]+
                        " "+plansza[34]+"   "+plansza[4]+" "+plansza[5]+" "+plansza[6]+" "+plansza[7]+" "+plansza[8]+"   ");
        System.out.println("   "+plansza[29]+"                   "+plansza[9]+"   ");
        System.out.println("   "+plansza[28]+" "+plansza[27]+" "+plansza[26]+" "+plansza[25]+" "+plansza[24]+"   "+plansza[14]+" "+plansza[13]+" "+plansza[12]+" "+plansza[11]+" "+plansza[10]+" 10");
        System.out.println("           "+plansza[23]+"   "+plansza[15]+"           ");
        System.out.println("           "+plansza[22]+"   "+plansza[16]+"           ");
        System.out.println("           "+plansza[21]+"   "+plansza[17]+"           ");
        System.out.println("           "+plansza[20]+" "+plansza[19]+" "+plansza[18]+"           ");
        System.out.println("           20              ");

    }
}
