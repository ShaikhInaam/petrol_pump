package gui;



import entity.Client;
import operations.DatabaseOperations;
import util.StringUtilities;

import javax.swing.*;
import java.awt.Color;

import java.awt.event.ItemEvent;
import java.util.ArrayList;


public class MainFrame extends javax.swing.JFrame {


    public static ArrayList<Client> list;


    public MainFrame() {

        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        initComponents();
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //int height = screenSize.height;
        // int width = screenSize.width;
        // this.setSize(width/2, height/2);
        // Dimension dm = this.getContentPane().getSize();
        // jPanel1.setSize((int)dm.getWidth()/2, (int)dm.getHeight()/2);

    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("<html><div style='text-align: center;'><font size ='5' color='green'>"+"Log in with your user name"+"</font></div></html>");

        jTextField1.setText("User Name");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }

        });


        jPasswordField1.setText("Password");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
        });

        jCheckBox1.setText("Show password");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jButton1.setText("<html><div style='text-align: center;'><font size ='5'>"+"Log in"+"</font></div></html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1)
                                        .addComponent(jPasswordField1)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPasswordField1.setEchoChar((char) 0);
        jButton1.setBackground(Color.GREEN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(103, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>



    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        jTextField1.setText("");
    }



    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
        jPasswordField1.setText("");
        jPasswordField1.setEchoChar('*');
    }

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String username = jTextField1.getText().toString().trim();
        String password = jPasswordField1.getText().toString().trim();

        System.out.println(username +"   "+password);

        if(!StringUtilities.isEmpty(username) && !StringUtilities.isEmpty(password))
        {
            try {

                list = (ArrayList<Client>) DatabaseOperations.read(username,password,Client.class);

                if(list.size()>0)
                {

                    this.setVisible(false);
                    new StationFrame().setVisible(true);

                }

                else
                    JOptionPane.showMessageDialog(this,"no such user found!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else
            JOptionPane.showMessageDialog(this,"such data is not allowed!");

    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
