package com.sakib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PendingAccounts {




    public static void main(String[] args) {
        PendingAccounts ob = new PendingAccounts();
        ob.loadAccounts();

    }



        public void loadAccounts(){
            CreateWindow dashWindow = new CreateWindow(150,10,1100,700);
            UsedImages obimg = new UsedImages();

            CustomModelSakib ob1 = new CustomModelSakib();
            CustomModelSakib ob2 = new CustomModelSakib();
            CustomModelSakib ob3 = new CustomModelSakib();
            CustomModelSakib ob4 = new CustomModelSakib();
            CustomModelSakib ob5 = new CustomModelSakib();

            ob1.CreateLabel(50,40,200,50,"Accounts",ob1.customFont3);
            ob1.label.setForeground(Color.white);

            ob1.CreateTextfield(50,90,250,35,"Account No");
            ob1.textField.setBackground(ob1.DashBoradCardColor);
            ob1.textField.setForeground(Color.WHITE);
            ob1.textField.setCaretColor(Color.WHITE);

            ob2.CreateButtonColors(440,90,120,35,"Approve All",new Color(199, 0, 57));
            ob2.button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String appAllQuery = "UPDATE login SET Status='Approved' WHERE Status='pending'";
                    int appAllStatus = ob1.SendData(appAllQuery);
                    if(appAllStatus==1){

                        JOptionPane.showMessageDialog(null,"All Accounts are Approved.","Approval Operation",JOptionPane.PLAIN_MESSAGE);
                        dashWindow.frame.setVisible(false);
                        PendingAccounts obx = new PendingAccounts();
                        obx.loadAccounts();
                    }
                    else{

                        JOptionPane.showMessageDialog(null,"Operation Failed","Approval Operation",JOptionPane.ERROR_MESSAGE);

                    }

                }
            });



            ob1.CreateButtonColors(310,90,120,35,"Approve",new Color( 25, 111, 61 ));
            ob1.button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String searchKey = ob1.textField.getText();
                    if(searchKey.equals("")){
                        JOptionPane.showMessageDialog(null,"No Account Number Entered","Alert",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        int acc_no = Integer.valueOf(searchKey);


                        String Query = "SELECT * from accounts WHERE Account_No='"+acc_no+"'";
                        ResultSet rz = ob1.GetData(Query);
                        int User_IDz = 0;

                        try{
                            while (rz.next()){
                                User_IDz = Integer.valueOf(rz.getString("User_ID"));
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }


                        String appAllQuery = "UPDATE login SET Status='Approved' WHERE Identity_ID='"+User_IDz+"' AND Status='pending'";

                        int appStatus = ob1.SendData(appAllQuery);

                        if(appStatus==1){

                            JOptionPane.showMessageDialog(null,"Account is Approved.","Approval Operation",JOptionPane.PLAIN_MESSAGE);
                            dashWindow.frame.setVisible(false);
                            PendingAccounts obx = new PendingAccounts();
                            obx.loadAccounts();
                        }
                        else{

                            JOptionPane.showMessageDialog(null,"Operation Failed","Approval Operation",JOptionPane.ERROR_MESSAGE);

                        }
                    }
                }
            });


            String Query = "SELECT Account_No,A.User_ID,Name,Gender,Contact,Status FROM accounts as A,user as U,login as l WHERE A.User_ID=U.User_ID AND A.User_ID=l.Identity_ID AND l.Status='pending'";
            ResultSet rz = ob1.GetData(Query);
            ob1.CreateTable(50,140,1000,500,rz);
            dashWindow.mainpanel.add(ob1.scrollPane);



            dashWindow.mainpanel.add(ob1.label);
            dashWindow.mainpanel.add(ob1.textField);
            dashWindow.mainpanel.add(ob1.button);
            dashWindow.mainpanel.add(ob2.button);


            JLabel titleLabel = new JLabel("Smartie Commercial Bank");
            titleLabel.setBounds(10,1,300,30);
            titleLabel.setForeground(Color.white);
            dashWindow.panel.add(titleLabel);

            dashWindow.cross.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dashWindow.frame.setVisible(false);
                    AccountsList ob = new AccountsList();
                    ob.loadAccounts();
                }
            });

            dashWindow.mainpanel.setBackground(ob1.DashBoradBgColor);
            dashWindow.panel.setBackground(ob1.DashBoradBgColor);
            dashWindow.cross.setBackground(ob1.DashBoradBgColor);
            dashWindow.frame.setVisible(true);

        }


}
