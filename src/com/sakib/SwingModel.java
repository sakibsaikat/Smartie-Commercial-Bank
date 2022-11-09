package com.sakib;

import com.sun.jdi.connect.Connector;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.TableUI;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SwingModel {
    JPanel panel;
    JLabel label;
    JTextField textField;
    JButton button;
    JComboBox box;
    ImageIcon image;
    ImageIcon resized_image;
    JLabel image_label;
    JScrollPane scrollPane;
    JTable table;
    JPanel hoverpanel;

    public void CreatePanel(int x,int y,int wid,int hei){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x,y,wid,hei);
    }

    public void CreateHoverPanel(int x,int y,int wid,int hei){
        hoverpanel = new JPanel();
        hoverpanel.setLayout(null);
        hoverpanel.setBounds(x,y,wid,hei);
        hoverpanel.setBackground(new Color(0,0,0));
        hoverpanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,102,204)));
        hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hoverpanel.setBackground(new Color(0,102,204));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverpanel.setBackground(new Color(0,0,0));
            }
        });
    }

    public void CreateHoverPanelCustom(int x,int y,int wid,int hei){
        hoverpanel = new JPanel();
        hoverpanel.setLayout(null);
        hoverpanel.setBounds(x,y,wid,hei);
        hoverpanel.setBackground(new Color(0,0,0));
        hoverpanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(0,102,204)));
        hoverpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hoverpanel.setBackground(new Color(30,31,31));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverpanel.setBackground(new Color(0,0,0));
            }
        });
    }


    public void CreateTable(int x,int y,int wid,int hei,ResultSet res){

        table = new JTable();
        table.setRowHeight(40);
        table.setForeground(Color.WHITE);
//        table.setModel(DbUtils.resultSetToTableModel(res));
        table.setBounds(0,0,wid,hei);


        JTableHeader th = table.getTableHeader();
        th.setBackground(Color.BLACK);
        th.setForeground(Color.WHITE);
//        th.setBorder(BorderFactory.createEmptyBorder());
        th.setPreferredSize(new Dimension(100, 40));
        th.setBorder(null);

        th.setFont(new Font("Segoe UI",Font.BOLD,12));
        th.setOpaque(false);


        //active click background
//        table.setSelectionBackground(Color.BLACK);


        //To Center All Column Value
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);


        TableModel tableModel = table.getModel();
        for(int c=0;c<tableModel.getColumnCount();c++) {
            table.getColumnModel().getColumn(c).setCellRenderer(cellRenderer);
        }
        table.setShowVerticalLines(false);


        JTableHeader hed = table.getTableHeader();
        hed.setBorder(BorderFactory.createLineBorder(Color.BLACK));


//        table.setShowGrid(false);

        table.setIntercellSpacing(new Dimension(0,0));




        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);



        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x,y,wid,hei);
    }

    public void CreateImage(int x,int y,int wid,int hei,String path){
        image = new ImageIcon(path);
        image_label = new JLabel();
        image_label.setIcon(image);
        image_label.setBounds(x,y,wid,hei);
    }

    public void CreateResizeImage(int x,int y,int wid,int hei,String path){
        resized_image = new ImageIcon(path);
        Image rez = resized_image.getImage().getScaledInstance(wid,hei,Image.SCALE_DEFAULT);
        ImageIcon rex = new ImageIcon(rez);
        image_label = new JLabel();
        image_label.setIcon(rex);
        image_label.setBounds(x,y,wid,hei);
    }

    public void CreateCombo(int x,int y,int wid,int hei,String[] options){
        box = new JComboBox(options);
        box.setBounds(x,y,wid,hei);
    }

    public void CreateLabel(int x,int y,int wid,int hei,String text,String fn_name,int size){
        label = new JLabel();
        label.setText(text);
        label.setBounds(x,y,wid,hei);
        label.setFont(new Font(fn_name,Font.BOLD,size));
    }

    public void CreateTextfield(int x,int y,int wid,int hei,String placeholder){
        textField = new JTextField(placeholder);
        textField.setBounds(x,y,wid,hei);
        textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(0,102,204)));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textField.getText().equals(placeholder)){
                    textField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().equals("")){
                    textField.setText(placeholder);
                }
            }


        });
    }

    public void CreateButton(int x,int y,int wid,int hei,String btn_name){
        button = new JButton(btn_name);
        button.setFocusable(false);
        button.setBounds(x,y,wid,hei);
    }

    public void SendData(String command){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://103.169.160.66:3306/satrong2_payra", "satrong2_sakib","S@kibtas$1514");
//            Connection con = DriverManager.getConnection("jdbc:mysql://103.169.160.66:3306/satrong2_payra","satrong2_sakib","S@akibtas$1514");
            Statement st = con.createStatement();
            st.execute(command);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet GetData(String Command){
        ResultSet rz=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://103.169.160.66:3306/satrong2_payra", "satrong2_sakib","S@kibtas$1514");
            Statement st = con.createStatement();
            rz = st.executeQuery(Command);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rz;
    }


}