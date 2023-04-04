import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Crypto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,630);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Gui());
        frame.setVisible(true);
    }
}

