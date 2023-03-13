public class Cryptage {
    public static String encryption(String message, String key) {
        String s = "";
        for (int t=0; t<message.length(); t++)
            s += ""+(char)('A' + ((message.charAt(t)-'A')+(key.charAt(t)-'A')) % 26);
        return s;
    }
    public static String decryption(String message, String key) {
        String s = "";
        for (int t=0; t<message.length(); t++) {
            int tmp = ((message.charAt(t)-'A')-(key.charAt(t)-'A'));
            if (tmp < 0) tmp += 26;
            s += ""+(char)('A' + tmp);
        }
        return s;
    }
}
