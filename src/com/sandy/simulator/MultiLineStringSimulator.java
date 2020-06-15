package com.sandy.simulator;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.SwingUtilities;

public class MultiLineStringSimulator extends JFrame {
    public MultiLineStringSimulator() {

        String dummyString = "Sandeep leans to Java. This solution will help to dynamically calculate height of any given text by specifying with width";

        Font font = new Font("Segoe Script", Font.PLAIN, 8);
        JTextArea text = new JTextArea();
        text.setText(dummyString);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(font);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        getContentPane().setLayout(layout);
        layout.setVerticalGroup(layout.createParallelGroup()

                .addComponent(text)
        );
        layout.setHorizontalGroup(layout.createSequentialGroup()

                .addComponent(text, DEFAULT_SIZE, 120, 120) //Lock the width to 400
        );

        pack();
        //System.out.println(this.getContentPane());
        layout.invalidateLayout(this.getContentPane());
        pack();
        System.out.println(text.getBounds().height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MultiLineStringSimulator();
           // frame.setVisible(true);
        });
    }
}
