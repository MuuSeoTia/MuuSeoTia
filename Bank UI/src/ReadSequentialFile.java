// This program reads a file of objects sequentially
// and displays each record.

// Java core packages
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;


@SuppressWarnings("serial")
public class ReadSequentialFile extends JFrame {
    private static final long serialVersionUID = 3417040053089159204L;
    private ObjectInputStream input;
    private BankUI userInterface;
    private JButton nextButton, openButton;

    // Constructor -- initialize the Frame
    public ReadSequentialFile()
    {
        super( "Reading a Sequential File of Objects" );

        // create instance of reusable user interface
        userInterface = new BankUI(8);
        getContentPane().add(
                userInterface, BorderLayout.CENTER );
        for(int x = 0; x < 8; x++){
            userInterface.fields[x].setEditable( false );
            userInterface.fields[x].setBackground(Color.white);
        }
        // get reference to generic task button doTask1 from BankUI
        openButton = userInterface.getDoTask1Button();
        openButton.setText( "Open File" );
        openButton.setMnemonic('o');
        // register listener to call openFile when button pressed
        openButton.addActionListener(

                // anonymous inner class to handle openButton event
                new ActionListener() {

                    // close file and terminate application
                    public void actionPerformed( ActionEvent event )
                    {
                        openFile();
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener




        // get reference to generic task button doTask2 from BankUI
        nextButton = userInterface.getDoTask2Button();
        nextButton.setText( "Next Record" );
        nextButton.setEnabled( false );
        nextButton.setMnemonic('N');
        // register listener to call readRecord when button pressed
        nextButton.addActionListener(

                // anonymous inner class to handle nextRecord event
                new ActionListener() {

                    // call readRecord when user clicks nextRecord
                    public void actionPerformed( ActionEvent event )
                    {
                        readRecord();
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        nextButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    readRecord();
            } // keyPressed
        }/*KeyAdapter*/);
        pack(); // pack the window, making it just big enough

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




    }  // end ReadSequentialFile constructor

    // enable user to select file to open
    private void openFile()
    {
        // display file dialog so user can select file to open
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_ONLY );

        int result = fileChooser.showOpenDialog( this );

        // if user clicked Cancel button on dialog, return
        if ( result == JFileChooser.CANCEL_OPTION )
            return;

        // obtain selected file
        File fileName = fileChooser.getSelectedFile();

        // display error if file name invalid
        if ( fileName == null ||
                fileName.getName().equals( "" ) )
            JOptionPane.showMessageDialog( this,
                    "Invalid File Name", "Invalid File Name",
                    JOptionPane.ERROR_MESSAGE );

        else {

            // open file
            try {
                input = new ObjectInputStream(
                        new FileInputStream( fileName ) );

                openButton.setEnabled( false );
                nextButton.setEnabled( true );
                nextButton.requestFocus();
            }

            // process exceptions opening file
            catch ( IOException ioException ) {
                JOptionPane.showMessageDialog( this,
                        "Error Opening File", "Error",
                        JOptionPane.ERROR_MESSAGE );
            }

        }  // end else

    }  // end method openFile

    // read record from file
    public void readRecord()
    {
        AccountRecord record;

        // input the values from the file
        try {
            record = ( AccountRecord ) input.readObject();  // going from one type to the other type

            // create array of Strings to display in GUI
            String values[] = {
                    String.valueOf( record.getAccount() ),
                    record.getFirstName(),
                    record.getLastName(),
                    record.getAddress(),
                    record.getSocsec(),
                    String.valueOf(record.getBalance()),
                    String.valueOf(record.getGpa()),
                    record.getTitle()
            };

            // display record contents
            userInterface.setFieldValues( values );
        }

        // display message when end-of-file reached
        catch ( EOFException endOfFileException ) {
            nextButton.setEnabled( false );

            JOptionPane.showMessageDialog( this,
                    "No more records in file",
                    "End of File", JOptionPane.ERROR_MESSAGE );
        }

        // display error message if cannot read object
        // because class not found
        catch ( ClassNotFoundException classNotFoundException ) {
            JOptionPane.showMessageDialog( this,
                    "Unable to create object",
                    "Class Not Found", JOptionPane.ERROR_MESSAGE );
        }

        // display error message if cannot read
        // due to problem with file
        catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
                    "Error during read from file",
                    "Read Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    // close file and terminate application
    private void closeFile()
    {
        // close file and exit
        try {
            input.close();
            System.exit( 0 );
        }

        // process exception while closing file
        catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
                    "Error closing file",
                    "Error", JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
        }
    }

    // execute application; ReadSequentialFile constructor
    // displays window
    public static void main( String args[] )
    {
        new ReadSequentialFile();
    }

}  // end class ReadSequentialFile