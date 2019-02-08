package no.hvl.dat102;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import no.hvl.dat102.adt.CDarkivADT;


public class Fil {
    private static final String SKILLE = "#";

    public static CDarkivADT lesFraFil(String filnavn) {

        CDarkivADT cda = null;

        try {

            FileReader file = new FileReader( filnavn );

            BufferedReader reader = new BufferedReader( file );

            String linje = reader.readLine();
            int n = Integer.parseInt( linje );

            cda = new CDarkiv2();

            for (int i = 0; i < n; i++) {
                String post = reader.readLine();
                String[] felt = post.split( SKILLE );
                int nr = Integer.parseInt( felt[0] );
                String artist = felt[1];
                String tittel = felt[2];
                int aar = Integer.parseInt( felt[3] );
                Sjanger sj = Sjanger.valueOf( felt[4] );
                String plateselskap = felt[5];

                CD cd = new CD( nr, artist, tittel, aar, sj, plateselskap );

                cda.leggTilCd( cd );
            }


            file.close();

        } catch (FileNotFoundException e) {
            System.out.println( "Fil ikke funnet " + filnavn );
        } catch (IOException e) {
            System.out.println( "Feil ved lesing av fil: " + e );
        }

        return cda;
    }

    public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
        try {
            FileWriter CDFil = new FileWriter( filnavn );
            PrintWriter writer = new PrintWriter( CDFil );
            int antall = cdarkiv.hentAntall();
            writer.println( antall );
            for (int i = 0; i < antall; i++) {
                writer.print( cdarkiv.hentCdTabell()[i].getCdNummer() );
                writer.print( SKILLE );
                writer.print( cdarkiv.hentCdTabell()[i].getArtist() );
                writer.print( SKILLE );
                writer.print( cdarkiv.hentCdTabell()[i].getTittel() );
                writer.print( SKILLE );
                writer.print( cdarkiv.hentCdTabell()[i].getAar() );
                writer.print( SKILLE );
                writer.print( cdarkiv.hentCdTabell()[i].getSjanger() );
                writer.print( SKILLE );
                writer.print( cdarkiv.hentCdTabell()[i].getPlateselskap() );
                writer.println();
            }
            writer.close();

        } catch (IOException e) {
            System.err.println( "Feilmelding! : " + e );
        }
        System.out.println( "Printet til fil!" );
    }
}