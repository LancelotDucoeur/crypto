
import java.util.*;

public class Cartes {

    private List<Integer> cartes;

    public Cartes() {
        cartes = new ArrayList<Integer>();
        for (int t=1; t<=54; t++)
            cartes.add(t);
    }

    public Cartes(String seed) {
        this();
        for(int i = 0; i < 54; i++) 
            Collections.swap(cartes, i, ((int)seed.charAt(i%seed.length()))%54);
    }

    public String toString() {
        String s = "";
        for (int t=0; t<54; t++) {
            s += getCarte(cartes.get(t))+" ";
            if (t%13==12) s += "\n";
        }
        return s;
    }

    public static String getMasque(String seed, int size) {
        Cartes c = new Cartes(seed);
        String res = "";
        for (int t=0; t<size; t++)
            res += c.getLettre();
        return res;
    }

    private String getCarte(int nb) {
        String s = "";
        switch ((nb-1)/13) {
            case 0: s = "\u2663"; break;
            case 1: s = "\u2666"; break;
            case 2: s = "\u2665"; break;
            case 3: s = "\u2660"; break;
            default: s = "\uD83C\uDCDF";
        }
        if (nb==53)
            s = "R"+s;
        else if (nb==54)
            s = "N"+s;
        else
            switch ((nb-1) % 13) {
                case 10: s = "V"+s; break;
                case 11: s = "D"+s; break;
                case 12: s = "R"+s; break;
                default: s = ""+(((nb-1)%13)+1)+s;
            }
        return s;
    }

    private void etape_1() {
        // joker noir = 54
        int indexJoker = cartes.indexOf(54);
        Collections.swap(cartes, indexJoker, (indexJoker==53)?1:indexJoker+1 );
    }

    private void etape_2() {
        // joker rouge = 53
        int indexJoker = cartes.indexOf(53);
        Collections.swap(cartes, indexJoker, (indexJoker==53)?2:
                                             (indexJoker==52)?1:indexJoker+2);
    }

    private void etape_3() {
        int jn, jr;
        jn = cartes.indexOf(54);
        jr = cartes.indexOf(53);

        int deb, fin;
        if (jn>jr) {deb = jr; fin = jn;}
        else {deb = jn; fin = jr;}

        List<Integer> lDeb = new ArrayList<Integer>(cartes.subList(0, deb));
        List<Integer> lMil = new ArrayList<Integer>(cartes.subList(deb,fin+1));
        List<Integer> lFin = new ArrayList<Integer>(cartes.subList(fin+1, 54)); 

        cartes.clear();
        lMil.addAll(lDeb);
        lFin.addAll(lMil);
        cartes = lFin;
    }

    private void etape_4() {
        List<Integer> lDeb = cartes.subList(0, cartes.get(53));
        List<Integer> lDebCopie = new ArrayList<Integer>(lDeb);        
        lDeb.clear();
        Integer dernCarte = cartes.remove(cartes.size()-1);
        cartes.addAll(lDebCopie);
        cartes.add(dernCarte);
    }

    private Integer etape_5() {
        Integer val;
        do {
            etape_1();
            etape_2();
            etape_3();
            etape_4();
            val = cartes.get(cartes.get(0)-1);
        } while (val==53 || val==54);
        return val;
    }

    public char getLettre() {        
        return (char)(((int)'A')+((etape_5()-1)%26));
    }

}
