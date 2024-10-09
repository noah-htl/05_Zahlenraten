package at.htlsaalfelden.zahlenraten;

import java.util.Random;

public class ZahlenRaten {
    private int zahl;
    private int versuche;
    private int gesamtVersuche = 5;
    private boolean hasWon;
    private boolean hasGenerated;

    public ZahlenRaten() {
        hasGenerated = false;
    }

    public void generate(int min, int max) {
        zahl = new Random().nextInt(min, max);
        versuche = 0;
        hasWon = false;
        hasGenerated = true;
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
