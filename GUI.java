import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLOutput;
import java.util.EventListener;
import java.util.Scanner;

public class GUI extends Frame implements ActionListener {
    JTextField t1,t2,t3;
    String Branch,Name,Roll_No;
    JFrame Jframe;

    GUI(){
        Jframe = new JFrame("gui");

        JLabel l1= new JLabel("Roll No.");
        l1.setBounds(50,70,100,30);
         t1 = new JTextField();
        t1.setBounds(150,70,170,30);

        JLabel l2= new JLabel("Name");
        l2.setBounds(50,120,100,30);
         t2 = new JTextField();
        t2.setBounds(150,120,170,30);



        JLabel l3= new JLabel("Year");
        l3.setBounds(50,170,100,30);
         t3 = new JTextField();
        t3.setBounds(150,170,170,30);
        Branch = t3.getText();
        System.out.println(Branch);

        Jframe.add(l1);
        Jframe.add(t1);
        Jframe.add(l2);
        Jframe.add(t2);
        Jframe.add(l3);
        Jframe.add(t3);

        JButton b = new JButton("ENTER");
        b.setBounds(120,240,100,30);
        b.addActionListener(this);
        Jframe.add(b);


        Jframe.setSize(400,400);
        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new GUI();
        File f1 = new File("CSE.txt");
        f1.createNewFile();
        File f2 = new File("ICT.txt");
        f2.createNewFile();
        File f3 = new File("ECE.txt");
        f3.createNewFile();



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Name = t2.getText();
        String str = t1.getText();
        String string = "";

        for(int i = 2; i <5 ; i++ ){
            char s = str.charAt(i);
            string += s;
        }
        Branch = t3.getText();
        JOptionPane.showMessageDialog(Jframe,"DATA Written Successfully:-","successfull",JOptionPane.PLAIN_MESSAGE );

        if(string.equals("BCP")) {
            try {

//                int i;
//                FileReader fr = new FileReader("CSE.txt");
//                while((i = fr.read() )!=-1){
//                    s+=(char)i;
//                }

                FileWriter fl = new FileWriter("CSE.txt",true);
                BufferedWriter fw = new BufferedWriter(fl);
                fw.write(   "\nRoll No:- " + str + "\nName " + Name + "\nYear:- " + Branch + "\n");
                fw.close();


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(string.equals("ICT")) {
            try {
                FileWriter fw = new FileWriter("ICT.txt",true);
                fw.write( "\nRoll No:- " + str + "\nName " + Name+ "\nYear:- " + Branch );

                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(string.equals("ECE")) {
            try {
                FileWriter fw = new FileWriter("ECE.txt",true);
                fw.write("\nRoll No:- " + str+ "\nName " + Name + "\nYear:- " + Branch   );

                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



    }
}
