
public class Main {
    public static void main(String args[]) {

        if (args.length!=2) {
            System.out.println("Erreur !");
            System.out.println("Premier parametre : Message a chiffrer (Seulement des majuscules)");
            System.out.println("Deuxieme parametre : Graine pour melanger le paquet (n'importe quel caractere ASCII)");
            return;
        }

        System.out.println("Chiffrement   : "+
            Cryptage.encryption(args[0],Cartes.getMasque(args[1],args[0].length())));
        System.out.println("Dechiffrement : "+
            Cryptage.decryption(args[0],Cartes.getMasque(args[1],args[0].length())));

    }
}
