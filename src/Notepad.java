import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Notepad {

    JTextArea textArea;
    JButton saveButton,openButton;

    public Notepad() {

        JFrame frame = new JFrame("Notepad");

        textArea = new JTextArea();

        saveButton = new JButton("Save");
        openButton = new JButton("Open");

        textArea.setBounds(50,50,600,400);
        openButton.setBounds(425,475,100,25);
        saveButton.setBounds(550,475,100,25);

        openButton.addActionListener(e -> openButtonAction(frame));

        saveButton.addActionListener(e-> saveButtonAction(frame));



        frame.add(textArea);
        frame.add(openButton);
        frame.add(saveButton);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(710,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    public void openButtonAction(Frame frame){

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("OPEN");

        try {

            int returnValue = fc.showOpenDialog(frame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                textArea.setText(Files.readString(selectedFile.toPath()));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void saveButtonAction(Frame frame){

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("SAVE");

        try {

            if(!textArea.getText().equals("")){

                int returnValue = fc.showSaveDialog(frame);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();
                    Files.writeString(selectedFile.toPath(), textArea.getText(), StandardOpenOption.CREATE);
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
