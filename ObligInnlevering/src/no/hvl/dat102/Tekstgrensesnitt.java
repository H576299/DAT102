package no.hvl.dat102;

import java.util.Scanner;
import static java.lang.Integer.*;

import no.hvl.dat102.adt.CDarkivADT;

public class Tekstgrensesnitt {
    private Scanner sc;


    public CD lesCD() {
        sc = new Scanner(System.in);

        System.out.print("CdNummer: ");
        int cdNummer = sc.nextInt();

        System.out.print("Artist: ");
        String artist = sc.next();

        System.out.print("Tittel: ");
        String tittel = sc.next();

        System.out.print("Aar: ");
        int aar = sc.nextInt();

        System.out.print("Velg sjanger: \n\n1. POP\n2. ROCK\n3. OPERA\n4. KLASSISK\n");

        int sjangerInt = parseInt( sc.next() );

        Sjanger sjanger = Sjanger.finnSjanger(sjangerInt);

        System.out.print("PlateSelskap: ");
        String plateselskap = sc.next();

        CD nycd = new CD(cdNummer, artist, tittel, aar, sjanger, plateselskap);

        return nycd;
    }



    public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
        CD[] samling = cda.sokTittel(delstreng);

        boolean finnes = true;
        for (int i = 0; i < samling.length; i++) {
            if (samling[i] != null) {
                System.out.println(samling[i].getTittel().toString());
                finnes = true;
            } else if (samling[i] == null) {
                finnes = false;
            }
        }
        if (!finnes) {
            System.out.println("Finner ikke tittel : " + delstreng + " i arkivet");
        }

    }

    public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
        CD[] samling = cda.sokArtist(delstreng);


        boolean finnes = true;

        for (int i = 0; i < samling.length; i++) {
            if (samling[i] != null) {
                System.out.println(samling[i].toString());
                finnes = true;
            } else if (samling[i] == null) {
                finnes = false;
            }
        }
        if (!finnes) {
            System.out.println("Finner ikke artist: " + delstreng + " i arkivet.");
        }
    }



    public void skrivUtStatistikk(CDarkivADT cda) {
        System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
        System.out.println("Antall CD'er med Rock: " + cda.hentAntall(Sjanger.finnSjanger("ROCK")));
        System.out.println("Antall CD'er med Pop: " + cda.hentAntall(Sjanger.finnSjanger("POP")));
        System.out.println("Antall CD'er med Opera: " + cda.hentAntall(Sjanger.finnSjanger("OPERA")));
        System.out.println("Antall CD'er med Klassisk: " + cda.hentAntall(Sjanger.finnSjanger("KLASSISK")));


    }

}