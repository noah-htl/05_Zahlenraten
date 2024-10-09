package at.htlsaalfelden.zahlenraten;

import java.util.Random;

public class ZahlenRaten {
    private int zahl;
    private int versuche;
    private int gesamtVersuche = 5;
    private boolean hasWon;

    public ZahlenRaten() {
        zahl = new Random().nextInt(1, 100);
        versuche = 0;
        hasWon = false;
    }

    public int getZahl() {
        return zahl;
    }

    public int checkZahl(int input) {
        versuche++;
        if(input == zahl) {
            hasWon = true;
        }
        return Integer.compare(input, zahl);
    }

    public int getVersuche() {
        return gesamtVersuche - versuche;
    }

    public int getGesamtVersuche() {
        return gesamtVersuche;
    }

    public int getUsedVersuche() {
        return versuche;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public boolean canRun() {
        return !hasWon && getVersuche() > 0;
    }
}
