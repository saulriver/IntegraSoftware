/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.are.captureintegrasoft;

import com.are.captureintegrasoft.entity.Employee;
import com.are.captureintegrasoft.entity.FingerprintRequest;
import com.are.captureintegrasoft.entity.FingerprintResponse;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.ui.swing.sample.Enrollment.CaptureForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;

/**
 *
 * @author Laura
 */
public class MainForm extends javax.swing.JFrame {

         // Variables declaration - do not modify                     
    private javax.swing.JButton findButton;
    private javax.swing.JButton fingerButton1;
    private javax.swing.JButton fingerButton10;
    private javax.swing.JButton fingerButton2;
    private javax.swing.JButton fingerButton3;
    private javax.swing.JButton fingerButton4;
    private javax.swing.JButton fingerButton5;
    private javax.swing.JButton fingerButton6;
    private javax.swing.JButton fingerButton7;
    private javax.swing.JButton fingerButton8;
    private javax.swing.JButton fingerButton9;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JDesktopPane jDesktopPaneTitle;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel photo;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCriteria;
    private javax.swing.JTextField txtfirstName;
    private javax.swing.JTextField txtlastName;
    private javax.swing.JButton verifyFingerButton1;
    private javax.swing.JButton verifyFingerButton10;
    private javax.swing.JButton verifyFingerButton2;
    private javax.swing.JButton verifyFingerButton3;
    private javax.swing.JButton verifyFingerButton4;
    private javax.swing.JButton verifyFingerButton5;
    private javax.swing.JButton verifyFingerButton6;
    private javax.swing.JButton verifyFingerButton7;
    private javax.swing.JButton verifyFingerButton8;
    private javax.swing.JButton verifyFingerButton9;
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration 
    
    // Fingerprint variables
    public static String TEMPLATE_PROPERTY = "template";
    
    private DPFPTemplate template1;
    private DPFPTemplate template2;
    private DPFPTemplate template3;
    private DPFPTemplate template4;
    private DPFPTemplate template5;
    private DPFPTemplate template6;
    private DPFPTemplate template7;
    private DPFPTemplate template8;
    private DPFPTemplate template9;
    private DPFPTemplate template10;
    private DPFPTemplate templatefingerprintDefault;
    
    private FingerprintRequest fingerprintRequest;
    private String EmployeeId;
    private String fingerprintPosition;
    private String fingerprintDefault;
    
    public MainForm() throws HeadlessException {
        initComponent();
        setup();
    
    }
    
    private void setup() {
        this.addPropertyChangeListener(TEMPLATE_PROPERTY, new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                verifyFingerButton1.setEnabled(template1 != null);
                verifyFingerButton2.setEnabled(template2 != null);
                verifyFingerButton3.setEnabled(template3 != null);
                verifyFingerButton4.setEnabled(template4 != null);
                verifyFingerButton5.setEnabled(template5 != null);
                verifyFingerButton6.setEnabled(template6 != null);
                verifyFingerButton7.setEnabled(template7 != null);
                verifyFingerButton8.setEnabled(template8 != null);
                verifyFingerButton9.setEnabled(template9 != null);
                verifyFingerButton10.setEnabled(template10 != null);
                
                saveButton.setEnabled((template1 != null) || (template2 != null) || (template3 != null) || (template4 != null) || 
                                        (template5 != null) || (template6 != null) || (template7 != null) || (template8 != null) ||
                                        (template9 != null) || (template10 != null) || (templatefingerprintDefault != null));
               
                if (evt.getNewValue() == evt.getOldValue()) {
                    return;
                }
                
                if (getFingerprintPosition().equals("1") && template1 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 1 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("2") && template2 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 2 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("3") && template3 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 3 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("4") && template4 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 4 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("5") && template5 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 5 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("6") && template6 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 6 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("7") && template7 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 7 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("8") && template8 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 8 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("9") && template9 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 9 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("10") && template10 != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprint 10 template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                if (getFingerprintPosition().equals("fingerprintDefault") && templatefingerprintDefault != null) {                  
                    JOptionPane.showMessageDialog(MainForm.this, "The fingerprintDefault template is ready for fingerprint verification.", "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
                }
                
                System.out.println("\n");
                System.out.println("Position: " + getFingerprintPosition());
                System.out.println("Template 1: " + template1);
                System.out.println("Template 2: " + template2);
                System.out.println("Template 3: " + template3);
                System.out.println("Template 4: " + template4);
                System.out.println("Template 5: " + template5);
                System.out.println("Template 6: " + template6);
                System.out.println("Template 7: " + template7);
                System.out.println("Template 8: " + template8);
                System.out.println("Template 9: " + template9);
                System.out.println("Template 10: " + template10);
                System.out.println("FingerprintDefault: " + templatefingerprintDefault);
                System.out.println("\n");
            }
        });
        setTemplate1(null);
        setTemplate2(null);
        setTemplate3(null);
        setTemplate4(null);
        setTemplate5(null);
        setTemplate6(null);
        setTemplate7(null);
        setTemplate8(null);
        setTemplate9(null);
        setTemplate10(null);
        setFingerprintDefault(null);
        
        fingerprintRequest = new FingerprintRequest();
    }
    
    private void initComponent() {
       
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanelTitle = new javax.swing.JPanel();
        jDesktopPaneTitle = new javax.swing.JDesktopPane();
        headerTitle = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        txtCriteria = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        label3 = new javax.swing.JLabel();
        txtfirstName = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txtlastName = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fingerButton1 = new javax.swing.JButton();
        fingerButton2 = new javax.swing.JButton();
        fingerButton3 = new javax.swing.JButton();
        fingerButton4 = new javax.swing.JButton();
        fingerButton5 = new javax.swing.JButton();
        verifyFingerButton1 = new javax.swing.JButton();
        verifyFingerButton2 = new javax.swing.JButton();
        verifyFingerButton3 = new javax.swing.JButton();
        verifyFingerButton4 = new javax.swing.JButton();
        verifyFingerButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fingerButton6 = new javax.swing.JButton();
        fingerButton7 = new javax.swing.JButton();
        fingerButton8 = new javax.swing.JButton();
        fingerButton9 = new javax.swing.JButton();
        fingerButton10 = new javax.swing.JButton();
        verifyFingerButton8 = new javax.swing.JButton();
        verifyFingerButton9 = new javax.swing.JButton();
        verifyFingerButton10 = new javax.swing.JButton();
        verifyFingerButton7 = new javax.swing.JButton();
        verifyFingerButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setAlignmentX(50.0F);
        jInternalFrame1.setAlignmentY(50.0F);
        jInternalFrame1.setAutoscrolls(true);
        jInternalFrame1.setEnabled(false);
        jInternalFrame1.setVisible(true);

        jPanelTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
       

        jDesktopPaneTitle.setBackground(new java.awt.Color(126, 92, 243));
        jDesktopPaneTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(247, 247, 247)));
        jDesktopPaneTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
       
        headerTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(247, 247, 247));
        headerTitle.setText("INTEGRASOFT");
        headerTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jDesktopPaneTitle.setLayer(headerTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneTitleLayout = new javax.swing.GroupLayout(jDesktopPaneTitle);
        jDesktopPaneTitle.setLayout(jDesktopPaneTitleLayout);
        jDesktopPaneTitleLayout.setHorizontalGroup(
            jDesktopPaneTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPaneTitleLayout.setVerticalGroup(
            jDesktopPaneTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        headerTitle.getAccessibleContext().setAccessibleParent(headerTitle);

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneTitle)
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        label1.setText("Employee code:");
       
        label2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        label2.setText("Code:");
        
        txtCriteria.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtCode.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        
        label3.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        label3.setText("First name:");
        
        txtfirstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        
        label4.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        label4.setText("Last name:");
        
        txtlastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        
        findButton.setIcon(new javax.swing.ImageIcon("research.png")); // NOI18N
        findButton.addFocusListener(new java.awt.event.FocusAdapter() {
        });

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setIcon(new javax.swing.ImageIcon("face.png")); // NOI18N
        photo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(255, 255, 255), null, null), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        photo.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        photo.setMinimumSize(new java.awt.Dimension(0, 0));
        photo.setEnabled(true);
        
        quitButton.setIcon(new javax.swing.ImageIcon("exit.png")); // NOI18N

        saveButton.setIcon(new javax.swing.ImageIcon("save.png")); // NOI18N
        
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fingerprint - default", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 14))); // NOI18N
        
        jPanel2.setBackground(new java.awt.Color(249, 247, 170));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null), "Left - hand", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        
        fingerButton1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton1.setText("Thumb");

        fingerButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton2.setText("Index");

        fingerButton3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton3.setText("Middle");

        fingerButton4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton4.setText("Ring");
        
        fingerButton5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton5.setText("Little");

        verifyFingerButton1.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
        verifyFingerButton2.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
        verifyFingerButton3.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
        verifyFingerButton4.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
        verifyFingerButton5.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
       
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(verifyFingerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fingerButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verifyFingerButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verifyFingerButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(verifyFingerButton5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(verifyFingerButton4))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(fingerButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fingerButton4)
                                    .addComponent(fingerButton3)
                                    .addComponent(fingerButton5))))))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fingerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verifyFingerButton2)
                    .addComponent(fingerButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verifyFingerButton3)
                    .addComponent(fingerButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verifyFingerButton4)
                    .addComponent(fingerButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verifyFingerButton5)
                    .addComponent(fingerButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(249, 247, 170));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null), "Right - hand", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 12))); // NOI18N

        fingerButton6.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton6.setText("Thumb");

        fingerButton7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton7.setText("Index");

        fingerButton8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton8.setText("Middle");

        fingerButton9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton9.setText("Ring");

        fingerButton10.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        fingerButton10.setText("Little");

        verifyFingerButton8.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
               
        verifyFingerButton9.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
               
        verifyFingerButton10.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
                
        verifyFingerButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        verifyFingerButton7.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
       
        verifyFingerButton6.setIcon(new javax.swing.ImageIcon("fingerprint.png")); // NOI18N
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fingerButton10)
                        .addGap(18, 18, 18)
                        .addComponent(verifyFingerButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fingerButton9)
                        .addGap(18, 18, 18)
                        .addComponent(verifyFingerButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fingerButton7)
                        .addGap(18, 18, 18)
                        .addComponent(verifyFingerButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fingerButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(verifyFingerButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(fingerButton8)
                        .addGap(18, 18, 18)
                        .addComponent(verifyFingerButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fingerButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fingerButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton7))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fingerButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton8))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fingerButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton9))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fingerButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyFingerButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //Combo box seleccion de fingerprint por defecto
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Thumb-left", "2 Index-left", "3 Middle-left", "4 Ring-left", "5 Little-left", "6 Thumb-right", "7 Index-right", "8 Middle-right", "9 Ring-right", "10 Little-right" }));
        jComboBox1.setFocusable(true);
        
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(29, 29, 29)
                        .addComponent(quitButton))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(txtCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(106, 106, 106)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCriteria))
                                .addGap(31, 31, 31)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtfirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGap(15, 15, 15)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(106, 106, 106)
                    .addContainerGap())
        );

        label1.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 650));

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 // </editor-fold>
        
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonClick(evt);
            }
        });
        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonClick(evt);
            }
        });
        
        fingerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("1");
                captureButtonClick(evt);
            }
        });
        
        fingerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("2");
                captureButtonClick(evt);
            }
        });
        
        fingerButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("3");
                captureButtonClick(evt);
            }
        });
        
        fingerButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("4");
                captureButtonClick(evt);
            }
        });
        
        fingerButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("5");
                captureButtonClick(evt);
            }
        });
        
        fingerButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("6");
                captureButtonClick(evt);
            }
        });
        
        fingerButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("7");
                captureButtonClick(evt);
            }
        });
        
        fingerButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("8");
                captureButtonClick(evt);
            }
        });
        
        fingerButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("9");
                captureButtonClick(evt);
            }
        });
        
        fingerButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFingerprintPosition("10");
                captureButtonClick(evt);
            }
        });
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                setFingerprintPosition("fingerprintDefault");
 //               captureButtonClick(evt);
    
            }
        });
        
        verifyFingerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        verifyFingerButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonClick(evt);
            }
        });
        
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonClick(evt);
            }
        });
        
        pack();
        setTitle("Capture Employee Fingerprint");
        setVisible( true );      
    }
    
    public void findButtonClick(java.awt.event.ActionEvent evt) {
        try {
            if (txtCriteria.getText().equals("")) {
                JOptionPane.showMessageDialog(MainForm.this, "Entry Employee please.", "Error", JOptionPane.ERROR_MESSAGE);
                txtCriteria.requestFocus();
                cleanForm();
                return;
            }
            
            String criteria = txtCriteria.getText().trim();
            String url = "http://ec2-18-224-134-225.us-east-2.compute.amazonaws.com:8087/employee/object/" + criteria;
            
            ClientRestService client = new ClientRestService(url);
            
            Employee employee = client.consumeRestEmployee();
            if (employee != null) {
                System.out.println("State: " + employee.getState());
                if(employee.getState().equals("ENABLED")){
                    
                    txtCode.setText(employee.getCode());
                    txtfirstName.setText(employee.getFirstName());
                    txtlastName.setText(employee.getLastName());
                    
                    setEmployeeId(employee.getId());
                    
                    /*
                    if (employee.getPhoto() != null) {
                            photo.setIcon(getIcon(employee.getPhoto(), photo.getWidth(), photo.getHeight()));
                    }else {
                        ImageIcon icon = new ImageIcon("person.png");
                        photo.setIcon(icon);
                    }
                    */
                    fingerButton1.setEnabled(true);
                    fingerButton2.setEnabled(true);
                    fingerButton3.setEnabled(true);
                    fingerButton4.setEnabled(true);
                    fingerButton5.setEnabled(true);
                    fingerButton6.setEnabled(true);
                    fingerButton7.setEnabled(true);
                    fingerButton8.setEnabled(true);
                    fingerButton9.setEnabled(true);
                    fingerButton10.setEnabled(true);
                    jComboBox1.setEnabled(true);
                   
                    /*
                    if (employee.getFingerprint() != null) {
                        DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
                            t.deserialize(employee.getFingerprint());
                            setTemplate(t);

                            saveButton.setEnabled(true);
                            verifyButton.setEnabled(true);
                    }
                    */
                
                }else{
                    JOptionPane.showMessageDialog(MainForm.this, "Inactive employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    cleanForm();
                }
                
            }else {
                JOptionPane.showMessageDialog(MainForm.this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
                cleanForm();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
    
    public void cleanForm() {
        txtCode.setText("");
        txtfirstName.setText("");
        txtlastName.setText("");
        ImageIcon icon = new ImageIcon("person.png");
        photo.setIcon(icon);
        fingerButton1.setEnabled(false);
        fingerButton2.setEnabled(false);
        fingerButton3.setEnabled(false);
        fingerButton4.setEnabled(false);
        fingerButton5.setEnabled(false);
        fingerButton6.setEnabled(false);
        fingerButton7.setEnabled(false);
        fingerButton8.setEnabled(false);
        fingerButton9.setEnabled(false);
        fingerButton10.setEnabled(false);
        jComboBox1.setEnabled(false);
        saveButton.setEnabled(false);
        verifyFingerButton1.setEnabled(false);
        verifyFingerButton2.setEnabled(false);
        verifyFingerButton3.setEnabled(false);
        verifyFingerButton4.setEnabled(false);
        verifyFingerButton5.setEnabled(false);
        verifyFingerButton6.setEnabled(false);
        verifyFingerButton7.setEnabled(false);
        verifyFingerButton8.setEnabled(false);
        verifyFingerButton9.setEnabled(false);
        verifyFingerButton10.setEnabled(false);
        
    }
    
    public ImageIcon getIcon(byte[] data, int width, int height) {
        ImageIcon _photo = new ImageIcon(data);
        Image image = _photo.getImage();
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return  new ImageIcon(newimg);  // transform it back
    }
    
    public void saveButtonClick(java.awt.event.ActionEvent evt) {
        
        Employee employee = new Employee();
        System.out.println("Save employee: " + getEmployeeId());
        employee.setId(getEmployeeId());
        
        FingerprintRequest fingerprintRequest = new FingerprintRequest();
        
        fingerprintRequest.setEmployee(employee);        
        fingerprintRequest.setFingerprintDefault("fingerprintDefault");
        if (getTemplate1() != null) {
            fingerprintRequest.setFingerprint1(getTemplate1().serialize());
        }
        if (getTemplate2() != null) {
            fingerprintRequest.setFingerprint2(getTemplate2().serialize());
        }
        if (getTemplate3() != null) {
            fingerprintRequest.setFingerprint3(getTemplate3().serialize());
        }
        if (getTemplate4() != null) {
            fingerprintRequest.setFingerprint4(getTemplate4().serialize());
        }
        if (getTemplate5() != null) {
            fingerprintRequest.setFingerprint5(getTemplate5().serialize());
        }
        if (getTemplate6() != null) {
            fingerprintRequest.setFingerprint6(getTemplate6().serialize());
        }
        if (getTemplate7() != null) {
            fingerprintRequest.setFingerprint7(getTemplate7().serialize());
        }
        if (getTemplate8() != null) {
            fingerprintRequest.setFingerprint8(getTemplate8().serialize());
        }
        if (getTemplate9() != null) {
            fingerprintRequest.setFingerprint9(getTemplate9().serialize());
        }
        if (getTemplate10() != null) {
            fingerprintRequest.setFingerprint10(getTemplate10().serialize());
        }
        if (getFingerprintDefault() != null) {
            fingerprintRequest.setFingerprintDefault(getFingerprintDefault());
        }
        
        fingerprintRequest.setToken("00000");
        fingerprintRequest.setLang("es");
                
         try {
             
            String url = "http://ec2-18-224-134-225.us-east-2.compute.amazonaws.com:8087/fingerprintEmployee/save";
            
            ClientRestService client = new ClientRestService(url);
            
            FingerprintResponse fingerprintResponse = client.consumeRestSaveFingerprintEmployee(fingerprintRequest);
            
            if (!fingerprintResponse.isError()) {
                
                System.out.println("Result: " + fingerprintResponse.isResult());
                System.out.println("Error: " + fingerprintResponse.isError());
                System.out.println("Message: " + fingerprintResponse.getMessage());
                
            }else {
                JOptionPane.showMessageDialog(MainForm.this, "Could not be saved.", "Error", JOptionPane.ERROR_MESSAGE);
                cleanForm();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void captureButtonClick(java.awt.event.ActionEvent evt) {
        onEnroll();
    }
    
    public void verifyButtonClick(java.awt.event.ActionEvent evt) {
        onVerify();
    }
    
    public void quitButtonClick(java.awt.event.ActionEvent evt) {
        dispose();
    }
    
    private void onEnroll() {
        EnrollmentForm form = new EnrollmentForm(this);
        form.setVisible(true);
    }

    private void onVerify() {
        VerificationForm form = new VerificationForm(this);
        form.setVisible(true);
    }
    
    public static void main( String args[] ) {
        // Instancia un objeto de tipo Interfaz Hombre-Maquina
        MainForm mainForm = new MainForm();
        
    }

    public DPFPTemplate getTemplate1() {
        return template1;
    }

    public void setTemplate1(DPFPTemplate template1) {
        DPFPTemplate old = this.template1;
        this.template1 = template1;
        firePropertyChange(TEMPLATE_PROPERTY, old, template1);
    }

    public DPFPTemplate getTemplate2() {
        return template2;
    }

    public void setTemplate2(DPFPTemplate template2) {
        DPFPTemplate old = this.template2;
        this.template2 = template2;
        firePropertyChange(TEMPLATE_PROPERTY, old, template2);
    }

    public DPFPTemplate getTemplate3() {
        return template3;
    }

    public void setTemplate3(DPFPTemplate template3) {
        DPFPTemplate old = this.template3;
        this.template3 = template3;
        firePropertyChange(TEMPLATE_PROPERTY, old, template3);
    }

    public DPFPTemplate getTemplate4() {
        return template4;
    }

    public void setTemplate4(DPFPTemplate template4) {
       DPFPTemplate old = this.template4;
        this.template4 = template4;
        firePropertyChange(TEMPLATE_PROPERTY, old, template4);
    }

    public DPFPTemplate getTemplate5() {
        return template5;
    }

    public void setTemplate5(DPFPTemplate template5) {
        DPFPTemplate old = this.template5;
        this.template5 = template5;
        firePropertyChange(TEMPLATE_PROPERTY, old, template5);
    }

    public DPFPTemplate getTemplate6() {
        return template6;
    }

    public void setTemplate6(DPFPTemplate template6) {
       DPFPTemplate old = this.template6;
        this.template6 = template6;
        firePropertyChange(TEMPLATE_PROPERTY, old, template6);
    }

    public DPFPTemplate getTemplate7() {
        return template7;
    }

    public void setTemplate7(DPFPTemplate template7) {
        DPFPTemplate old = this.template7;
        this.template7 = template7;
        firePropertyChange(TEMPLATE_PROPERTY, old, template7);
    }

    public DPFPTemplate getTemplate8() {
        return template8;
    }

    public void setTemplate8(DPFPTemplate template8) {
       DPFPTemplate old = this.template8;
        this.template8 = template8;
        firePropertyChange(TEMPLATE_PROPERTY, old, template8);
    }

    public DPFPTemplate getTemplate9() {
        return template9;
    }

    public void setTemplate9(DPFPTemplate template9) {
        DPFPTemplate old = this.template9;
        this.template9 = template9;
        firePropertyChange(TEMPLATE_PROPERTY, old, template9);
    }

    public DPFPTemplate getTemplate10() {
        return template10;
    }

    public void setTemplate10(DPFPTemplate template10) {
        DPFPTemplate old = this.template10;
        this.template10 = template10;
        firePropertyChange(TEMPLATE_PROPERTY, old, template10);
    }
    
    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String EmployeeId) {
        this.EmployeeId = EmployeeId;
    }
    
    public String getFingerprintDefault() {
        return fingerprintDefault;
    }
    
    public void setFingerprintDefault(String fingerprintDefault) {
        this.fingerprintDefault = fingerprintDefault;
    }
    
    public String getFingerprintPosition() {
        return fingerprintPosition;
    }

    public void setFingerprintPosition(String fingerprintPosition) {
        this.fingerprintPosition = fingerprintPosition;
    }
         
    private void txtCriteriaFocusGained(java.awt.event.FocusEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void findButtonFocusLost(java.awt.event.FocusEvent evt) {                                     
        // TODO add your handling code here:
    } 
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt, Employee employee) {                                           
        // TODO add your handling code here:
        fingerprintRequest.setEmployee(employee);        
        fingerprintRequest.setFingerprintDefault("fingerprintDefault");
        
        
        fingerprintRequest.setToken("00000");
        fingerprintRequest.setLang("es");
                
         try {
             
            String url = "http://ec2-18-224-134-225.us-east-2.compute.amazonaws.com:8087/fingerprintEmployee/save";
            
            ClientRestService client = new ClientRestService(url);
            
            FingerprintResponse fingerprintResponse = client.consumeRestSaveFingerprintEmployee(fingerprintRequest);
            
            if (!fingerprintResponse.isError()) {
                
                System.out.println("Result: " + fingerprintResponse.isResult());
                System.out.println("Error: " + fingerprintResponse.isError());
                System.out.println("Message: " + fingerprintResponse.getMessage());
                
            }else {
                JOptionPane.showMessageDialog(MainForm.this, "Could not be saved.", "Error", JOptionPane.ERROR_MESSAGE);
                cleanForm();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static BufferedImage byteArrayToImage(byte[] bytes) {
        BufferedImage bufferedImage = null;
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            //bos.write(bytes);
            //byte [] data = bos.toByteArray();
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(bis);
        } catch (IOException ex) {
            Logger.getLogger(CaptureForm.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(CaptureForm.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }

        return bufferedImage;
    }

    DPFPTemplate getTemplatefingerprintDefault() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTemplatefingerprintDefault(DPFPTemplate template) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
