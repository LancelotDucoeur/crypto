import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Gui extends JPanel {
    
    private JTextField jTextFieldSeed;
    private JTextArea textAreaLeft;
    private JTextArea textAreaRight;
    private JButton buttonEncryption;
    private JButton buttonDecryption;
    
    public Gui() {
        super();
        initComponents();
        initEvents();
    }

    private void initComponents() {

        JLabel jLabelSeed = new JLabel("Seed : ");
        jLabelSeed.setLabelFor(jTextFieldSeed);
        jTextFieldSeed = new JTextField();
        jTextFieldSeed.setPreferredSize(new Dimension(1000, 40));
        jTextFieldSeed.setFont( new Font("SansSerif", Font.PLAIN, 35));
        JPanel panelTop = new JPanel();
        panelTop.add(jLabelSeed);
        panelTop.add(jTextFieldSeed);
        this.add(panelTop, BorderLayout.PAGE_START);

        textAreaLeft = new JTextArea();
        textAreaLeft.setFont( new Font("SansSerif", Font.PLAIN, 35));
        textAreaLeft.setLineWrap(true);
        JScrollPane scrollPanelCenterLeft = new JScrollPane(textAreaLeft, 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanelCenterLeft.setPreferredSize(new Dimension(630, 500));
        textAreaRight = new JTextArea();
        textAreaRight.setFont( new Font("SansSerif", Font.PLAIN, 35));
        textAreaRight.setLineWrap(true);
        JScrollPane scrollPanelCenterRight = new JScrollPane(textAreaRight,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanelCenterRight.setPreferredSize(new Dimension(630, 500));
        buttonEncryption = new JButton("Encryption");
        buttonDecryption = new JButton("Decryption");
        JPanel panelCenterLeft = new JPanel();
        panelCenterLeft.add(scrollPanelCenterLeft, BorderLayout.CENTER);
        panelCenterLeft.add(buttonEncryption, BorderLayout.PAGE_END);
        JPanel panelCenterRight = new JPanel();
        panelCenterRight.add(scrollPanelCenterRight, BorderLayout.CENTER);
        panelCenterRight.add(buttonDecryption, BorderLayout.PAGE_END);
        JPanel panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(1280, 650));
        panelCenter.setLayout(new GridLayout(1, 2));
        panelCenter.add(panelCenterLeft);
        panelCenter.add(panelCenterRight);
        this.add(panelCenter, BorderLayout.CENTER);

    }

    private void initEvents() {
        
        buttonEncryption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textAreaLeft.setText(
                    textAreaLeft.getText().toUpperCase().replaceAll("[^A-Z]", ""));
                textAreaRight.setText(
                    Cryptage.encryption(
                        textAreaLeft.getText(),
                        Cartes.getMasque(
                            jTextFieldSeed.getText(),
                            textAreaLeft.getText().length())));
            }
        });
        buttonDecryption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textAreaRight.setText(
                    textAreaRight.getText().toUpperCase().replaceAll("[^A-Z]", ""));
                textAreaLeft.setText(
                    Cryptage.decryption(
                        textAreaRight.getText(),
                        Cartes.getMasque(
                            jTextFieldSeed.getText(),
                            textAreaRight.getText().length())));
            }
        });
    }

}
