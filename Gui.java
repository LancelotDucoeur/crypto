import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel{

    public Gui() {
        super();
        initComponents();

    }

    private void initComponents() {

        JPanel panelTop = new JPanel();
        this.add(panelTop, BorderLayout.PAGE_START);
        JLabel jLabelSeed = new JLabel("Seed : ");
        JTextField jTextFieldSeed = new JTextField();
        jTextFieldSeed.setPreferredSize(new Dimension(1000, 40));
        jTextFieldSeed.setFont( new Font("SansSerif", Font.PLAIN, 35));

        jLabelSeed.setLabelFor(jTextFieldSeed);
        panelTop.add(jLabelSeed);
        panelTop.add(jTextFieldSeed);

        JPanel panelCenter = new JPanel();
        this.add(panelCenter, BorderLayout.CENTER);
        panelCenter.setPreferredSize(new Dimension(1280, 650));

        JPanel panelCenterLeft = new JPanel();
        JPanel panelCenterRight = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 2));
        panelCenter.add(panelCenterLeft);
        panelCenter.add(panelCenterRight);
        JTextArea textAreaLeft = new JTextArea();
        JTextArea textAreaRight = new JTextArea();

        textAreaRight.setPreferredSize(new Dimension(630, 500));
        textAreaLeft.setPreferredSize(new Dimension(630, 500));
        panelCenterLeft.add(textAreaLeft, BorderLayout.CENTER);
        panelCenterRight.add(textAreaRight, BorderLayout.CENTER);
        JButton buttonEncryption = new JButton("Encryption");
        JButton buttonDecryption = new JButton("Decryption");
        panelCenterLeft.add(buttonEncryption, BorderLayout.PAGE_END);
        panelCenterRight.add(buttonDecryption, BorderLayout.PAGE_END);
    }



}
