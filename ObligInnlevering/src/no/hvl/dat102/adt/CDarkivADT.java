package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {


    CD[] hentCdTabell();

    void leggTilCd(CD nyCd);

    boolean slettCd(int cdNr);

    CD[] sokTittel(String delstreng);


    CD[] sokArtist(String delstreng);


    int hentAntall();//

    int hentAntall(Sjanger sjanger);

}
