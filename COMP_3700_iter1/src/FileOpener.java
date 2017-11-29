import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileOpener extends JFrame {
        private JTextField filename = new JTextField(), dir = new JTextField();

        private JButton open = new JButton("Open");

        public FileOpener() {
            JPanel p = new JPanel();
            open.addActionListener(new OpenL());
            p.add(open);
            Container cp = getContentPane();
            cp.add(p, BorderLayout.SOUTH);
            dir.setEditable(false);
            filename.setEditable(false);
            p = new JPanel();
            p.setLayout(new GridLayout(2, 1));
            p.add(filename);
            p.add(dir);
            cp.add(p, BorderLayout.NORTH);
        }

        class OpenL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(FileOpener.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    filename.setText(c.getSelectedFile().getName());
                    dir.setText(c.getCurrentDirectory().toString());
                }
                if (rVal == JFileChooser.CANCEL_OPTION) {
                    filename.setText("You pressed cancel");
                    dir.setText("");
                }
            }
        }

        public void run(int width, int height) {
            FileOpener frame = new FileOpener();
            frame.setSize(width, height);
            frame.setVisible(true);
        }

}
