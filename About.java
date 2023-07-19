import java.awt.*;  
import javax.swing.*; 
import java.awt.event.*;  
public class About {  
    private static JDialog d;  
    JButton b ;
    private JLabel l,l1,l2,l3;
    About() {  
        JFrame f= new JFrame();  
        f.setBackground(Color.white);
        d = new JDialog(f , "About Text-Editor", true);  
        d.setBackground(Color.white);
        d.setLayout( new FlowLayout() );  
        ImageIcon i = new ImageIcon("Blank.png");
        d.setIconImage(i.getImage());
    } 
    void addAbout()
    {
        //Image set
        ImageIcon icon = new ImageIcon("windows.png");
        l = new JLabel(icon);
        //adding image in the label
        d.add(l);

        //label1
        l1 = new JLabel("Windows 10");
        l1.setForeground(Color.BLUE);
        Font font1= new Font(Font.SANS_SERIF,Font.PLAIN,60);
        l1.setFont(font1);
        d.add(l1);

        //label2
        l2 = new JLabel("<html>  ___________________________________________________________________________________     </html><br>");
        d.add(l2) ;

        //label3
        l3 = new JLabel("<html><br><br>Microsoft Windows<br>Version 22H2 (OS Build 19045.3086)<br>\u00A9 2023 Microsoft Corporation All rights reserved.<br><br>This Notepad Application is protected by copyright laws and,<br> is the intellectual property of Microsoft Corporation.<br>Windows is a registered trademark of Microsoft Corporation,<br>We value your feedback and suggestions.<br></html>");
        d.add(l3);
       
        //dialog set up
        d.setBounds(200, 150, 0, 0);
        d.setSize(600,500);  

        //button for closing dialog
        b = new JButton(" Ok ");
        d.add(b);  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                About.d.setVisible(false);  
            }  
        }); 
        d.setVisible(true);  
        
    } 
    public static void main(String args[])  
    {  
        About a = new About();  
        a.addAbout();
    }  
}