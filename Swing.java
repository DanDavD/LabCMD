/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cmd;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Swing extends javax.swing.JFrame {
CMD mf=new CMD();
    /**
     * Creates new form Swing
     */
    public Swing() {
        initComponents();
        System.setOut(new PrintStream(new TextAreaOutputStream(cmd)));
        LeerComando();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cmd = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmd.setColumns(20);
        cmd.setRows(5);
        jScrollPane1.setViewportView(cmd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swing().setVisible(true);
            }
        });
    }

    public void LeerComando() {
        cmd.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String texto = cmd.getText();
                String[] lineas = texto.split("\\n");
                String ultimalinea = lineas[lineas.length - 1]; 
                
                if(ultimalinea.length()>4){
                if(ultimalinea.substring(0,5).equals("Mkdir")){
                    String[] palabras = ultimalinea.split(" ");
                    String nombre = palabras[1];
                    mf.mkdirs(nombre);
                }
                
                if(ultimalinea.substring(0,5).equals("Mfile")){
                    String[] palabras = ultimalinea.split(" ");
                    String nombre = palabras[1];
                    try {
                        mf.crearFile(nombre);
                    } catch (IOException ex) {
                        System.out.println("Error");
                    }
                }
                
                if(ultimalinea.substring(0,5).equals("<...>")){
                    mf.puntosSuspensivos();
                }
                }
                
                if(ultimalinea.length()>1){
                if(ultimalinea.substring(0,2).equals("Rm")){
                    mf.Rm();
                }
                
                if(ultimalinea.substring(0,2).equals("Cd")){
                    String[] palabras = ultimalinea.split(" ");
                    String nombre = palabras[1];
                    mf.cd(nombre);
                }
                }
                
                if(ultimalinea.length()>2){
                if(ultimalinea.substring(0,3).equals("Dir")){
                    mf.Dir();
                }
                }
                
                if(ultimalinea.length()>3){
                if(ultimalinea.substring(0,4).equals("Time")){
                    mf.Time();
                }
                
                if(ultimalinea.substring(0,4).equals("Date")){
                    mf.Date();
                } 
                }
                
                if(ultimalinea.length()>11){
                if(ultimalinea.substring(0,12).equals("Escribir<wr>")){
                    mf.Escribir(texto);
                }
                    }
                
                if(ultimalinea.length()>7){
                if(ultimalinea.substring(0,8).equals("Leer<rd>"))
                    mf.Leer();
                    }
            }
        }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cmd;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
