// Java core packages
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class CreateSequentialFile extends JFrame {
    private static final long serialVersionUID = 3417040053089159204L;
    private ObjectOutputStream output;
    private BankUI userInterface;
    private JButton enterButton, openButton;
    private JTextField setFcs;

    // set up GUI
    public CreateSequentialFile() {
        super("Creating a Sequential File of Objects");

        // create instance of reusable user interface
        userInterface = new BankUI(5);
        getContentPane().add(userInterface, BorderLayout.CENTER);
        // get reference to generic task button doTask1 in BankUI
        // and configure button for use in this program
        openButton = userInterface.getDoTask1Button();
        openButton.setText("Save into File ...");
        openButton.setMnemonic('S');
        // register listener to call openFile when button pressed
        openButton.addActionListener(

                // anonymous inner class to handle openButton event
                new ActionListener() {

                    // call openFile when button pressed
                    public void actionPerformed(ActionEvent event) {
                        openFile();
                    }

                } // end anonymous inner class

        ); // end call to addActionListener

        // get reference to generic task button doTask2 in BankUI
        // and configure button for use in this program
        enterButton = userInterface.getDoTask2Button();
        enterButton.setText("Enter");
        enterButton.setEnabled(false); // disable button
        enterButton.setMnemonic('E'); // hot key alt+E
        // register listener to call addRecord when button pressed
        enterButton.addActionListener(

                // anonymous inner class to handle enterButton event
                new ActionListener() {

                    // call addRecord when button pressed
                    public void actionPerformed(ActionEvent event) {
                        addRecord();
                        setFcs = userInterface.fields[0];
                        setFcs.requestFocus();
                    }

                } // end anonymous inner class

        ); // end call to addActionListener

        // add Enter key listener
        enterButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    addRecord();
                setFcs = userInterface.fields[0];
                setFcs.requestFocus();
            } // keyPressed
        }/* KeyAdapter */);

        // configure window
        setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE );

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (((screenSize.width - this.getWidth()) / 2) / 2);
        int y = (((screenSize.height - this.getHeight()) / 2) / 2);
        this.setLocation(x, y);
        // Set font style
        Font myFont = new Font("Franklin", Font.BOLD, 14);

        //produce the frame and show its
        setSize( 500, 350  );
        setResizable(false);
        setVisible( true );

    } // end CreateSequentialFile constructor

    // allow user to specify file name
    private void openFile() {
        // display file dialog, so user can choose file to open
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showSaveDialog(this);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION) // JFileChooser.CANCEL_OPTION
            return;

        // get selected file
        File fileName = fileChooser.getSelectedFile(); // file treats the string
        // \ into
        // @"c:\java\date\r.dat" into "c:\\java\\date\\r.dat"

        // display error if invalid
        if (fileName == null || fileName.getName().equals(""))
            JOptionPane.showMessageDialog(this, "Invalid File Name",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);

        else {

            // open file
            try {
                output = new ObjectOutputStream(new FileOutputStream(fileName));

                openButton.setEnabled(false);
                enterButton.setEnabled(true);
            }

            // process exceptions from opening file
            catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "Error Opening File",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    } // end method openFile

    // close file and terminate application
    private void closeFile() {
        // close file
        try {
            output.close();

            System.exit(0);
        }

        // process exceptions from closing file
        catch (IOException ioException) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    // add record to file
    public void addRecord() {
        int accountNumber = 0;
        AccountRecord record;
        String fieldValues[] = userInterface.getFieldValues();

        // if account field value is not empty
        if (!fieldValues[BankUI.ACCOUNT].equals("")) {

            // output values to file
            try {
                accountNumber = Integer.parseInt(fieldValues[BankUI.ACCOUNT]);

                if (accountNumber > 0) {

                    // create new record
                    record = new AccountRecord(accountNumber,
                            fieldValues[BankUI.FIRSTNAME],
                            fieldValues[BankUI.LASTNAME],
                            fieldValues[BankUI.ADDRESS],
                            fieldValues[BankUI.SOCSEC]);


                    // output record and flush buffer
                    output.writeObject(record);
                    output.flush(); // flush make sure all the data are done
                }

                // clear textfields
                userInterface.clearFields();
            }

            // process invalid account number or balance format
            catch (NumberFormatException formatException) {
                JOptionPane.showMessageDialog(this,
                        "Bad account number or balance",
                        "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
            }

            // process exceptions from file output
            catch (IOException ioException) {
                closeFile();
            }

        } // end if

    } // end method addRecord

    // execute application; CreateSequentialFile constructor
    // displays window
    public static void main(String args[]) {
        new CreateSequentialFile();
    }

} // end class CreateSequentialFile