package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;


public class CDarkiv implements CDarkivADT {

    final static int STK = 100;
    private CD[] cdTabell;
    private int antall;


    public CDarkiv(int maxAntall) {
        cdTabell = new CD[maxAntall];
        antall = 0;

    }

    public CDarkiv(){
        this(STK);
    }

    @Override
    public CD[] hentCdTabell() {
        return cdTabell;
    }

    private void utvidKapasitet() {
        CD[] hjelpetabell = new CD[(int) Math.ceil(1.1 * cdTabell.length)];
        for (int i = 0; i < cdTabell.length; i++) {
            hjelpetabell[i] = cdTabell[i];
        }
        cdTabell = hjelpetabell;
    }

    @Override
    public void leggTilCd(CD nyCd) {
        if (antall == cdTabell.length) {
            utvidKapasitet();
        }
        cdTabell[antall] = nyCd;
        antall++;
    }

    @Override
    public boolean slettCd(int cdNr) {

        if (finnesCD(cdNr) != -1) {
            cdTabell[finnesCD(cdNr)] = cdTabell[antall-1];
            cdTabell[antall-1] = null;
            antall--;
            return true;
        }else
        return false;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        CD[] tittel = new CD[antall];
        for (int i = 0; i < antall; i++) {
            if (cdTabell[i].getTittel().contains(delstreng)) {
                tittel[i] = cdTabell[i];
            }
        }
        trimTab(tittel, antall);
        return tittel;
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        CD[] artist = new CD[antall];
        for (int i = 0; i < antall; i++) {
            if (cdTabell[i].getArtist().contains(delstreng)) {
                artist[i] = cdTabell[i];
            }
        }
        trimTab(artist, antall);
        return artist;
    }

    @Override
    public int hentAntall() {

        return antall;
    }

    @Override
    public int hentAntall(Sjanger sjanger) {
        int antallSjanger = 0;
        for (int i = 0; i < cdTabell.length; i++) {
            if (cdTabell[i].getSjanger()==sjanger) {
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    public int finnesCD(int cdNr) {
        for (int i = 0; i < antall ; i++) {
            if (cdTabell[i].getCdNummer() == cdNr) {
                return i;
            }
        }
        return -1;
    }

    private CD[] trimTab(CD[] tab, int n) {
        CD[] cdtab2 = new CD[n];
        int i = 0;
        while (i < n) {
            cdtab2[i] = tab[i];
            i++;
        }
        return cdtab2;
    }

}