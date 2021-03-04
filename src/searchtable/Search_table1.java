package searchtable;

/*  -- This class allows the management to search for an blood donor --

*/

import bootathon.BOOTATHON;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.*;
import management_login.DoctorWelcome;
public class Search_table1 implements ActionListener{
    JFrame frame;
    JLabel lb_search,lb_bgimage,lb_head,lb_pincode,lbl_home,lbl_back;
    JTextField txt_pincode;
    JComboBox cb_grp;
    JButton b_search;
    String bloodgrp,tname,tgrp,tmail,tcontact,query,get_pincode,get_grp;
    JTable searcht;
    JScrollPane scroll;
    
    public Search_table1(){      
        
        
        frame=new JFrame();
        frame.setTitle("SEARCH FORM");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        frame.getContentPane().setBackground(Color.WHITE);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        
        lb_head=new JLabel("SEARCH FORM");
        lb_head.setFont(new Font("Arial",Font.BOLD,30));
        lb_head.setForeground(Color.red);
        lb_head.setBounds(600,35,683,125);
        
        lb_search=new JLabel("BLOOD GROUP");
        lb_search.setFont(new Font("Arial",Font.BOLD,18));
        lb_search.setBounds(450,170,445,120);
        lb_search.setForeground(Color.black);
        
        String types[]={"--","A+","O+","B+","AB+","A-","O-","B-","AB-"};
        cb_grp=new JComboBox(types);
        cb_grp.setFont(new Font("Arial",Font.PLAIN,18));
        cb_grp.setBounds(750,210,250,40);
        
        
        lb_pincode=new JLabel("PINCODE");
        lb_pincode.setFont(new Font("Arial",Font.BOLD,18));
        lb_pincode.setBounds(450,250,445,120);
        lb_pincode.setForeground(Color.black);
        
        txt_pincode=new JTextField();
        txt_pincode.setBounds(750,290,350,40);
        txt_pincode.setFont(new Font("Arial",Font.PLAIN,20));
        
        b_search=new JButton("SEARCH");
        b_search.setFont(new Font("Times New Roman",Font.BOLD,18));
        b_search.setBounds(750,380,200,40);
        b_search.setForeground(Color.WHITE);
        b_search.setBackground(Color.red);
        b_search.addActionListener(this);
        
        frame.setTitle("SEARCH FORM");
        frame.setLayout(null);
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.add(lb_search);
        frame.add(cb_grp);
        frame.add(b_search);
        frame.add(txt_pincode);
        frame.add(lb_pincode);
        frame.add(lb_head);
        
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel(img_home);
        lbl_home.setBounds(40,30,53,54);
        frame.add(lbl_home);
        
        ImageIcon img_back= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel(img_back);
        lbl_back.setBounds(1200,580,53,54);
        frame.add(lbl_back);
            
        lbl_home.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                BOOTATHON boot=new BOOTATHON();
                boot.welcome_page();
                frame.setVisible(false);        
            }
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            }
            @Override
            public void mousePressed(MouseEvent e) 
            {
            }
        });

        
        lbl_back.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new DoctorWelcome();
                frame.setVisible(false);
            }
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            }
            @Override
            public void mousePressed(MouseEvent e) 
            {
            }
        });
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        get_pincode=txt_pincode.getText();
        get_grp=cb_grp.getSelectedItem().toString();
        if((get_pincode.isEmpty())||(get_grp.equals("--"))){
            JOptionPane.showMessageDialog(frame,"ENTER ALL THE FIELDS");
        }
        else{
            try {
                Search_result sr=new Search_result();
                sr.display_table(get_pincode,get_grp);
            } catch (SQLException ex) {
                Logger.getLogger(Search_table1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
   public static void main(String[] args){
        new Search_table1();
    }
}