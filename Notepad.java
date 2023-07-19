import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.swing.border.EmptyBorder;
//import javax.swing.filechooser.FileNameExtensionFilter;
public class Notepad implements ActionListener
{
    private JFrame frame;
    private JTextArea textArea;
    private JTextField dirName;
    private JPanel saveFile;
    JLabel fileLabel,dirLabel;
    private JMenuBar menuBar;
    private JMenu file,edit,format,help;
    private JMenuItem itemNew,open,save,print,exit,cut,copy,paste,selectAll1,aboutUs,fontSize;
    About a = new About();
    String directory;
    String fileName;
    

    public Notepad()
    {
        frame = new JFrame("Untitled - Text Editor");
        textArea = new JTextArea();
        menuBar = new JMenuBar();

        //menuItem
        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        help = new JMenu("Help");

        //Menu items for file menu
        itemNew = new JMenuItem("New");
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        


        //Menu items for edit menu
        cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste = new JMenuItem("paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        selectAll1 = new JMenuItem("Select All");
        selectAll1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        //Menu items for format menu
        fontSize = new JMenuItem("Font Size");

        //Menu items for help menu
        aboutUs = new JMenuItem("About Us");

        //call methods
        addMenuItems();
        setMenuItemsListeners();
        setComponents();
        setFrameComponents();
    }
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch(command)
        {
            case "New":
                textArea.setText("");
                frame.setTitle("Untitled - Text Editor ");
                break;
            case "Open":
                open1();
                break;
            case "Save":
                save1();
                break;
            case "Exit":
                frame.dispose();
                break;

            case "Cut":
                textArea.cut();
                break;
            case "Copy":
                textArea.copy();
                break;
            case "Select All":
                textArea.selectAll();
                break;
            
            case "Font Size":
                String fontSize = JOptionPane.showInputDialog(frame, "Enter Font Size", JOptionPane.OK_CANCEL_OPTION);
                if(fontSize != null){
                    int convertSize = Integer.parseInt(fontSize);
                    Font font1= new Font(Font.SANS_SERIF,Font.BOLD,convertSize);
                    textArea.setFont(font1);
                }
                break;
            
            case "About Us":
                a.addAbout();
                break;
            
            }
        if(e.getSource()==paste)
        {
            textArea.paste();
        }
        if(e.getSource()==print)
        {
            try{
                textArea.print();
            }
            catch(PrinterException ex){
                //Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
    }
    public void addMenuItems()
    {
        //add menu itemss in a file menu
        file.add(itemNew);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        //add menu items in a edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll1);

        //add menu items in a format menu
        format.add(fontSize);

        //add menu item in a about menu
        help.add(aboutUs);

        //add main menus in a menu bar
        menuBar.add(file);  
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(help);
        

        itemNew.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        open.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        save.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        print.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        exit.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        cut.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        copy.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        paste.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        selectAll1.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        fontSize.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        aboutUs.setBorder(new EmptyBorder(new Insets(5, 0, 5, 20)));
        frame.setJMenuBar(menuBar);
    }
    //exit sub menu
    private void setMenuItemsListeners() {

        itemNew.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        selectAll1.addActionListener(this);
        
        fontSize.addActionListener(this);

        aboutUs.addActionListener(this);
        
	}

    private void setComponents()
    {
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial",Font.PLAIN,20));
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(BorderLayout.CENTER,scroll);
    }
    //set frame components
    private void setFrameComponents()
    {
        frame.setSize(500,500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //set image icon
        ImageIcon icon = new ImageIcon("Text.PNG");
        frame.setIconImage(icon.getImage());
    }
    private void open1()
    {
        JFileChooser choose = new JFileChooser();
        int i = choose.showOpenDialog(frame);
        if(i==JFileChooser.APPROVE_OPTION)
        {
            File file1 = choose.getSelectedFile();
            String filePath = file1.getPath();
            String fileName = file1.getName();
            frame.setTitle(fileName);
            try{
                BufferedReader readFile = new BufferedReader(new FileReader(filePath));
                String s1 = "";
                String s2 = "";
                while((s1=readFile.readLine())!=null)
                {
                    s2+=s1+"\n";
                }
                textArea.setText(s2);
                readFile.close();
            } 
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    private void save1()
    {
            saveFile = new JPanel(new GridLayout(2, 1));
            dirLabel = new JLabel("Save File To :-");
            dirName = new JTextField();
            saveFile.add(dirLabel);
            saveFile.add(dirName);
            JOptionPane.showMessageDialog(frame, saveFile);
            String fileContent = textArea.getText();
            String filePath = dirName.getText();
            try{
                BufferedWriter writeText    = new BufferedWriter(new FileWriter(filePath));
                writeText.write(fileContent);
                writeText.close();
                JOptionPane.showMessageDialog(frame,"File Saved Successfully !");
                frame.setTitle(filePath+".txt" + " - Text Editor");
            }
            catch(Exception ex)
            {
                
                ex.printStackTrace();
            }
        }
    public static void main(String[] args) {
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	    	
	    }
        new Notepad();
    }
}
