package no.hvl.dat102;


import java.util.Scanner;

import no.hvl.dat102.adt.CDarkivADT;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private CDarkivADT cda;
    private int valg;
    private Scanner tast;

    public Meny(CDarkivADT cda) {
        tekstgr = new Tekstgrensesnitt();
        this.cda = cda;
    }


    public void start() {
        tast = new Scanner(System.in);

        hovedMeny();

        tast.close();
    }

    public void hovedMeny() {

        String meny = "\n1 - Opprett nytt arkiv" + "\n2 - aapne eksisterende fil paa arkiv" + "\n3 - Avslutt og lagre"
                + "\n\nValg: ";
        do {
            System.out.print(meny);
            valg = tast.nextInt();
            switch (valg) {
                case 1:
                    OpprettNyttArkiv();
                    break;
                case 2:
                    BrukEksisterendeArkivMeny();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Menyvalget eksisterer ikke");
            }
        } while (valg != 3);

    }

    public void OpprettNyttArkiv() {

        System.out.print("Oppgi navn paa nytt arkiv: ");
        String navnPaaArkiv = tast.next();
        ArkivValg();
        Fil.skrivTilFil(cda, navnPaaArkiv + ".txt");

    }

    public void BrukEksisterendeArkivMeny() {

        System.out.print("Oppgi filnavn i arkivet: ");
        String filnavn = tast.next();
        cda = Fil.lesFraFil(filnavn + ".txt");
        ArkivValg();

        Fil.skrivTilFil(cda, filnavn + ".txt");

    }

    public void ArkivValg() {
        String meny = "\n1 - Legg til CD \n2 - Slett CD \n3 - Sok paa Tittel \n4 - Sok paa Artist \n5 - SkrivUtStatistikk \n6 - Avslutt for � lagre  ";
        do {
            System.out.print(meny);
            valg = tast.nextInt();
            switch (valg) {
                case 1:
                    cda.leggTilCd(tekstgr.lesCD());
                    break;
                case 2:
                    System.out.print("Oppgi CD nummer");
                    int nr = tast.nextInt();
                    if (cda.slettCd(nr)) {
                        System.out.println("CD nummer " + nr + " er slettet");
                    }
                    break;
                case 3:
                    System.out.print("Finn tittel: ");
                    String delstreng = tast.next();
                    tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
                    break;
                case 4:
                    System.out.print("Finn artist: ");
                    String dels = tast.next();
                    tekstgr.skrivUtCdArtist(cda, dels);
                    break;
                case 5:
                    tekstgr.skrivUtStatistikk(cda);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Menyvalget eksisterer ikke");
            }
        } while (valg != 6);

    }

}