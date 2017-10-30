/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Image;
import java.awt.Toolkit;
import commons.getIp;
import connection.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class Entrada extends javax.swing.JFrame {

    int x, y;
    String ip;
    
    /**
     * Creates new form Entrada
     */
    public Entrada() {
        initComponents();
        this.version.setText(Main.version);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        // Get IP
        ip = new getIp().getPublicIP();
        jTextLabelIP.setText(ip);
    }
    
    public Image getIconImage () {
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jTabbedPaneElegir = new javax.swing.JTabbedPane();
        jPanelConectar = new javax.swing.JPanel();
        jLabelIPConectar = new javax.swing.JLabel();
        jTextFieldIPConectar = new javax.swing.JTextField();
        jLabelPuertoConectar = new javax.swing.JLabel();
        jTextFieldPuertoConectar = new javax.swing.JTextField();
        jButtonConectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanelCrear = new javax.swing.JPanel();
        jLabelIP = new javax.swing.JLabel();
        jLabelPuerto = new javax.swing.JLabel();
        jTextFieldPuerto = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextLabelIP = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelServerIcon = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RolOnline - Selección");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(51, 51, 51));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setFocusable(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTabbedPaneElegir.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPaneElegir.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPaneElegir.setToolTipText("");
        jTabbedPaneElegir.setFocusable(false);
        jTabbedPaneElegir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanelConectar.setBackground(new java.awt.Color(51, 51, 51));
        jPanelConectar.setForeground(new java.awt.Color(255, 255, 255));
        jPanelConectar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIPConectar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelIPConectar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIPConectar.setText("IP:");
        jPanelConectar.add(jLabelIPConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTextFieldIPConectar.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldIPConectar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIPConectar.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldIPConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIPConectarActionPerformed(evt);
            }
        });
        jTextFieldIPConectar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIPConectarKeyPressed(evt);
            }
        });
        jPanelConectar.add(jTextFieldIPConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 160, -1));

        jLabelPuertoConectar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPuertoConectar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPuertoConectar.setText("Puerto:");
        jPanelConectar.add(jLabelPuertoConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextFieldPuertoConectar.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldPuertoConectar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPuertoConectar.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPuertoConectar.setText("2020");
        jTextFieldPuertoConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPuertoConectarActionPerformed(evt);
            }
        });
        jTextFieldPuertoConectar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPuertoConectarKeyPressed(evt);
            }
        });
        jPanelConectar.add(jTextFieldPuertoConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        jButtonConectar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonConectar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonConectar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConectar.setText("Conectar");
        jButtonConectar.setFocusable(false);
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });
        jPanelConectar.add(jButtonConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanelConectar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanelConectar.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 160, -1));

        jTabbedPaneElegir.addTab("Conectar", jPanelConectar);

        jPanelCrear.setBackground(new java.awt.Color(51, 51, 51));
        jPanelCrear.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelIP.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIP.setText("IP:");
        jPanelCrear.add(jLabelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabelPuerto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPuerto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPuerto.setText("Puerto:");
        jPanelCrear.add(jLabelPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextFieldPuerto.setBackground(new java.awt.Color(102, 102, 102));
        jTextFieldPuerto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPuerto.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPuerto.setText("2020");
        jTextFieldPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPuertoActionPerformed(evt);
            }
        });
        jTextFieldPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPuertoKeyPressed(evt);
            }
        });
        jPanelCrear.add(jTextFieldPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        jButtonCrear.setBackground(new java.awt.Color(51, 51, 51));
        jButtonCrear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrear.setText("Crear");
        jButtonCrear.setFocusable(false);
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanelCrear.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanelCrear.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanelCrear.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 160, -1));

        jTextLabelIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextLabelIP.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCrear.add(jTextLabelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jTabbedPaneElegir.addTab("Crear", jPanelCrear);

        getContentPane().add(jTabbedPaneElegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 270, 170));

        version.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setEnabled(false);
        version.setFocusable(false);
        getContentPane().add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/titulo2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelServerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/serverIcon2.png"))); // NOI18N
        getContentPane().add(jLabelServerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 180, 140));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bg.jpg"))); // NOI18N
        jLabelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelFondoMouseDragged(evt);
            }
        });
        jLabelFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelFondoMousePressed(evt);
            }
        });
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        int ax = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if(ax == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jLabelFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFondoMousePressed
        x = evt.getX (); 
        y = evt.getY(); 
    }//GEN-LAST:event_jLabelFondoMousePressed

    private void jLabelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFondoMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        
         setLocation(point.x - x, point.y - y)  ; 
    }//GEN-LAST:event_jLabelFondoMouseDragged

    private void jTextFieldPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPuertoActionPerformed

    private void jTextFieldIPConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIPConectarActionPerformed

    }//GEN-LAST:event_jTextFieldIPConectarActionPerformed

    private void jTextFieldIPConectarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIPConectarKeyPressed
        if (evt.VK_ENTER == evt.getKeyCode()) {
            conectar();
        }
    }//GEN-LAST:event_jTextFieldIPConectarKeyPressed

    private void jTextFieldPuertoConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPuertoConectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPuertoConectarActionPerformed

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        // Boton de conectar
        conectar();
    }//GEN-LAST:event_jButtonConectarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        crear();
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.VK_ENTER == evt.getKeyCode()) {
            conectar();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextFieldPuertoConectarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPuertoConectarKeyPressed
        if (evt.VK_ENTER == evt.getKeyCode()) {
            conectar();
        }
    }//GEN-LAST:event_jTextFieldPuertoConectarKeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.VK_ENTER == evt.getKeyCode()) {
            crear();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextFieldPuertoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPuertoKeyPressed
        if (evt.VK_ENTER == evt.getKeyCode()) {
            crear();
        }
    }//GEN-LAST:event_jTextFieldPuertoKeyPressed
    
    private void conectar() {       
        try {
            Main.startClient(jTextFieldIPConectar.getText(),
                    Integer.parseInt(jTextFieldPuertoConectar.getText()),
                    jTextField1.getText());
            //Main.name = jTextField1.getText();
            dispose();
            //Interfaz in = new Interfaz();
//            new Thread () {
//                public void run() {
                    
                    Main.interfaz = new Interfaz(jTextField1.getText());
                    Main.interfaz.setVisible(true);
                    while (Main.client == null) {}
                    Main.darNombreCliente(jTextField1.getText());
//                }
//            }.start();
        }
        catch (NumberFormatException ex) {
            
        }
    }
    
    private void conectarSelf() {
        try {
            Main.startClient("localhost", Integer.parseInt(jTextFieldPuertoConectar.getText()),jTextField2.getText());
            this.setVisible(false);
            //Interfaz in = new Interfaz();
            new Thread () {
                public void run() {
                    Main.interfaz = new Interfaz(jTextField2.getText());
                    Main.interfaz.setVisible(true);
                    //while (Main.client == null) {}
                    //Main.darNombreCliente(jTextField1.getText());
                }
            }.start();
        }
        catch (NumberFormatException ex) {
            
        }
    }
    
    private void crear() {
        try {
            Main.startServer(Integer.parseInt(jTextFieldPuerto.getText()));
            //Main.name = jTextField2.getText();
            conectarSelf();
        }
        catch (NumberFormatException ex) {
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelIPConectar;
    private javax.swing.JLabel jLabelPuerto;
    private javax.swing.JLabel jLabelPuertoConectar;
    private javax.swing.JLabel jLabelServerIcon;
    private javax.swing.JPanel jPanelConectar;
    private javax.swing.JPanel jPanelCrear;
    private javax.swing.JTabbedPane jTabbedPaneElegir;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldIPConectar;
    private javax.swing.JTextField jTextFieldPuerto;
    private javax.swing.JTextField jTextFieldPuertoConectar;
    private javax.swing.JLabel jTextLabelIP;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}