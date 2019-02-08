package no.hvl.dat102;

import no.hvl.dat102.node.LinearNode;
import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

    private int antall;
    private LinearNode<CD> start;

    public CDarkiv2() {
        start = null;
        antall = 0;
    }


    @Override
    public CD[] hentCdTabell() {
        LinearNode<CD> node = start;
        CD[] cdtab = new CD[antall];
        int i = 0;
        while (i < antall && node !=null) {
            cdtab[i] = node.getElement();
            node = node.getNeste();
            i++;
        }
        return cdtab;
    }

    @Override
    public void leggTilCd(CD nyCd) {
        LinearNode<CD> tempNode = new LinearNode<CD>(nyCd);
        tempNode.setNeste(start);
        start = tempNode;
        antall++;
    }

    public LinearNode<CD> finnCDpaaCDNr(int cdNr) {
        LinearNode<CD> node = start;
        LinearNode<CD> lastNode = start;
        while (node != null) {
            if (node.getElement().getCdNummer() == cdNr) {
                return lastNode;
            } else {
                lastNode = node;
                node = lastNode.getNeste();
            }
        }
        return null;
    }

    @Override
    public boolean slettCd(int cdNr) {
        LinearNode<CD> slett = finnCDpaaCDNr(cdNr);
        boolean slettet = false;
        if (slett != null) {
            slett.getNeste().setNeste( slett );
            antall--;
            slettet = true;
    }
        return slettet;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        CD[] tittler = new CD[antall];
        LinearNode<CD> noder = start;
        int i = 0;
        while (i < antall && noder != null) {
            if (noder.getElement().getTittel().contains(delstreng)) {
                tittler[i] = noder.getElement();
            }
            noder = noder.getNeste();
            i++;
        }
        return tittler;
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        CD[] artist = new CD[antall];
        LinearNode<CD> node = start;
        int i = 0;
        while (i < antall && node != null) {
            if (node.getElement().getArtist().contains(delstreng)) {
                artist[i] = node.getElement();
            }
            node = node.getNeste();
            i++;
        }
        return artist;
    }

    @Override
    public int hentAntall() {
        return antall;
    }

    @Override
    public int hentAntall(Sjanger sjanger) {
        int antallsjanger = 0;
        LinearNode<CD> p = start;
        int teller = 1;
        while (teller <= antall) {
            if (p.getElement().getSjanger() == sjanger) {
                antallsjanger++;
            }
            p = p.getNeste();
            teller++;
        }
        return antallsjanger;
    }

}
