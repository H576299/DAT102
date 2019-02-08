package no.hvl.dat102;

public enum Sjanger {

    POP(1),ROCK(2),OPERA(3),KLASSISK(4);
    private int nr;

    Sjanger(int n) {
        nr = n;
    }


    public static Sjanger finnSjanger(int n) {
        Sjanger sjanger = null;
        for (Sjanger sj : Sjanger.values()) {
            if (sj.nr == n) {
                sjanger = sj;
                break;
            }
        }
        return sjanger;
    }


    public static Sjanger finnSjanger(String n) {
        Sjanger sjanger = null;
        for (Sjanger sj : Sjanger.values()) {
            if (sj.toString().equals(n)) {
                sjanger = sj;
            }
        }
        return sjanger;
    }
}
