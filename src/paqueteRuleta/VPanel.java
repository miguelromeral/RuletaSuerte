/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteRuleta;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Miguel
 */
public class VPanel extends javax.swing.JFrame {

    public Pregunta pregunta;
    public boolean rapida = false;
    public boolean palabra = false;
    int bote = 1000;
    JTextField tf[] = new JTextField[52];
    JTextField tfAux[] = new JTextField[4];
    ArrayList<Integer> numerosCogidos;
    /**
     * Creates new form VPanel
     */
    public VPanel() {
        initComponents();
        int i;
        numerosCogidos = new ArrayList<Integer>();
        for(i=0; i<52; i++){
            tf[i] = new JTextField();
            tf[i].setSize(500,500);
            tf[i].setEditable(false);
            tf[i].setBackground(Color.blue);
            tf[i].setFont(new Font("Tahoma", Font.BOLD, 90));
            tf[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
        for(i=0; i<4; i++){
            tfAux[i] = new JTextField();
        }
        for(i=0; i<12; i++){
            if(i==0){
                panel1.add(tfAux[0]);
            }
            panel1.add(tf[i]);
            if(i==11){
                panel1.add(tfAux[1]);
            }
        }
        for(i=12; i<26; i++){
            panel2.add(tf[i]);
        }
        for(i=26; i<40; i++){
            panel3.add(tf[i]);
        }
        for(i=40; i<52; i++){
            if(i==40){
                panel4.add(tfAux[2]);
            }
            panel4.add(tf[i]);
            if(i==51){
                panel4.add(tfAux[3]);
            }
        }
    }
    public void cambiaPanel(){
        if(pregunta != null){
            int i = 0;
            tfBote.setText(""+bote);
            tfPista.setText(pregunta.pista);
            for(Character car : pregunta.panel1.toCharArray()){
                if(car.compareTo(' ') != 0){
                    tf[i].setBackground(Color.WHITE);
                }
                if(car.compareTo(',') == 0){
                    tf[i].setText(",");
                }
                i++;
            }
            i = 12;
            for(Character car : pregunta.panel2.toCharArray()){
                if(car.compareTo(' ') != 0){
                    tf[i].setBackground(Color.WHITE);
                }
                if(car.compareTo(',') == 0){
                    tf[i].setText(",");
                }
                i++;
            }
            i = 26;
            for(Character car : pregunta.panel3.toCharArray()){
                if(car.compareTo(' ') != 0){
                    tf[i].setBackground(Color.WHITE);
                }
                if(car.compareTo(',') == 0){
                    tf[i].setText(",");
                }
                i++;
            }
            i = 40;
            for(Character car : pregunta.panel4.toCharArray()){
                if(car.compareTo(' ') != 0){
                    tf[i].setBackground(Color.WHITE);
                }
                if(car.compareTo(',') == 0){
                    tf[i].setText(",");
                }
                i++;
            }
            for(i=0; i<4; i++){
                tfAux[i].setVisible(false);
            }
            if(rapida || palabra){
                buttonEnviar.setVisible(false);
                cbCantidad.setVisible(false);
                jLabel1.setVisible(false);
                tfLetra.setVisible(false);
                tfBote.setVisible(false);
            }else{
                buttonEmpezar.setVisible(false);
            }
        }
    }
    
    public void cambiaPanelRapido(){
        try{
            if(rapida){
                int panel;
                Random randPanel = new Random();
                Random randLetra = new Random();
                panel = randPanel.nextInt(4);
                int letra = 0;
                int j = 0;
                if(panel == 0){
                    letra = randLetra.nextInt(pregunta.panel1.length());
                    j+=letra;
                    if(!numerosCogidos.contains(j)){
                        numerosCogidos.add(j);
                        tf[j].setText(""+pregunta.panel1.charAt(letra));
                    }else{
                        if(numerosCogidos.size() == pregunta.panel1.length()+pregunta.panel2.length()+pregunta.panel3.length()+pregunta.panel4.length()){
                            JOptionPane.showMessageDialog(null, "Ya están todas las letras.", "Error en el panel", JOptionPane.ERROR_MESSAGE);
                            throw new Exception ("Ya están todas las letras");
                        }else{
                           cambiaPanelRapido(); 
                        }
                    }
                }
                if(panel == 1){
                    j=12;
                    letra = randLetra.nextInt(pregunta.panel2.length());
                    j+=letra;
                    if(!numerosCogidos.contains(j)){
                        numerosCogidos.add(j);
                        tf[j].setText(""+pregunta.panel2.charAt(letra));
                    }else{
                        if(numerosCogidos.size() == pregunta.panel1.length()+pregunta.panel2.length()+pregunta.panel3.length()+pregunta.panel4.length()){
                            JOptionPane.showMessageDialog(null, "Ya están todas las letras.", "Error en el panel", JOptionPane.ERROR_MESSAGE);
                            throw new Exception ("Ya están todas las letras");
                        }else{
                           cambiaPanelRapido(); 
                        }
                    }
                }
                if(panel == 2){
                    j=26;
                    letra = randLetra.nextInt(pregunta.panel3.length());
                    j+=letra;
                    if(!numerosCogidos.contains(j)){
                        numerosCogidos.add(j);
                        tf[j].setText(""+pregunta.panel3.charAt(letra));
                    }else{
                        if(numerosCogidos.size() == pregunta.panel1.length()+pregunta.panel2.length()+pregunta.panel3.length()+pregunta.panel4.length()){
                            JOptionPane.showMessageDialog(null, "Ya están todas las letras.", "Error en el panel", JOptionPane.ERROR_MESSAGE);
                            throw new Exception ("Ya están todas las letras");
                        }else{
                           cambiaPanelRapido(); 
                        }
                    }
                }
                if(panel == 3){
                    j=40;
                    letra = randLetra.nextInt(pregunta.panel4.length());
                    j+=letra;
                    if(!numerosCogidos.contains(j)){
                        numerosCogidos.add(j);
                        tf[j].setText(""+pregunta.panel4.charAt(letra));
                    }else{
                        if(numerosCogidos.size() == pregunta.panel1.length()+pregunta.panel2.length()+pregunta.panel3.length()+pregunta.panel4.length()){
                            JOptionPane.showMessageDialog(null, "Ya están todas las letras.", "Error en el panel", JOptionPane.ERROR_MESSAGE);
                            throw new Exception ("Ya están todas las letras");
                        }else{
                           cambiaPanelRapido(); 
                        }
                    }
                }
            }
            if(palabra){
                int j = 12;
                for(Character car : pregunta.panel2.toCharArray()){
                    if(car.compareTo(' ') != 0){
                        tf[j].setBackground(Color.WHITE);
                        tf[j].setText("");
                    }
                    j++;
                }
                Random randLetra = new Random();
                int letra = 0;
                j = 12;
                letra = randLetra.nextInt(pregunta.panel2.length());
                j+=letra;
                tf[j].setText(""+pregunta.panel2.charAt(letra));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        buttonResolver = new javax.swing.JButton();
        tfPista = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfLetra = new javax.swing.JTextField();
        cbCantidad = new javax.swing.JComboBox();
        tfBote = new javax.swing.JTextField();
        buttonEnviar = new javax.swing.JButton();
        buttonEmpezar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PANEL");

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        panel1.setLayout(new java.awt.GridLayout(1, 14));
        jPanel1.add(panel1);

        panel2.setLayout(new java.awt.GridLayout(1, 14));
        jPanel1.add(panel2);

        panel3.setLayout(new java.awt.GridLayout(1, 14));
        jPanel1.add(panel3);

        panel4.setLayout(new java.awt.GridLayout(1, 14));
        jPanel1.add(panel4);

        buttonResolver.setText("RESOLVER");
        buttonResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResolverActionPerformed(evt);
            }
        });

        tfPista.setEditable(false);
        tfPista.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        jLabel1.setText("Letra:");

        tfLetra.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        cbCantidad.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "25", "50", "75", "100", "125", "150", "200", "1000" }));

        tfBote.setBackground(new java.awt.Color(0, 153, 204));
        tfBote.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        tfBote.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addComponent(buttonResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPista, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBote, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonResolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfLetra)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfPista)
            .addComponent(cbCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tfBote, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        buttonEnviar.setText("ENVIAR");
        buttonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarActionPerformed(evt);
            }
        });

        buttonEmpezar.setText("EMPEZAR");
        buttonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmpezarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(buttonEmpezar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEmpezar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarActionPerformed
        try{
            if(tfLetra.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No se ha enviado ninguna letra.", "Fallo en el panel", JOptionPane.ERROR_MESSAGE);
                throw new Exception ("No se ha enviado ninguna letra.");
            }            
            Character letra = tfLetra.getText().charAt(0);
            if(!Character.isLetter(letra)){
                JOptionPane.showMessageDialog(null, "Debe escribir una letra.", "Fallo en el panel", JOptionPane.ERROR_MESSAGE);
                throw new Exception ("Debe escribir una letra.");
            }
            if(Character.isLowerCase(letra)){
                letra = Character.toUpperCase(letra);
            }
            int aciertos = 0;
            int i = 0;
            for(Character car : pregunta.panel1.toCharArray()){
                if(letra.compareTo(car) == 0){
                    tf[i].setText(letra.toString());
                    aciertos++;
                }
                i++;
            }
            i = 12;
            for(Character car : pregunta.panel2.toCharArray()){
                if(letra.compareTo(car) == 0){
                    tf[i].setText(letra.toString());
                    aciertos++;
                }
                i++;
            }
            i = 26;
            for(Character car : pregunta.panel3.toCharArray()){
                if(letra.compareTo(car) == 0){
                    tf[i].setText(letra.toString());
                    aciertos++;
                }
                i++;
            }
            i = 40;
            for(Character car : pregunta.panel4.toCharArray()){
                if(letra.compareTo(car) == 0){
                    tf[i].setText(letra.toString());
                    aciertos++;
                }
                i++;
            }
            int cantidad = Integer.valueOf(cbCantidad.getSelectedItem().toString());
            int añadido = cantidad * aciertos;
            bote = añadido + bote;
            tfBote.setText(""+bote);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_buttonEnviarActionPerformed

    private void buttonResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResolverActionPerformed
        int i = 0;
        int n = JOptionPane.showConfirmDialog(null, "Va a resolver el panel diréctamente, ¿está seguro?", "Resolver panel", JOptionPane.WARNING_MESSAGE);
            if(n == JOptionPane.OK_OPTION){
                for(Character car : pregunta.panel1.toCharArray()){
                    tf[i].setText(car.toString());
                    i++;
                }
                i = 12;
                for(Character car : pregunta.panel2.toCharArray()){
                    tf[i].setText(car.toString());
                    i++;
                }
                i = 26;
                for(Character car : pregunta.panel3.toCharArray()){
                    tf[i].setText(car.toString());
                    i++;
                }
                i = 40;
                for(Character car : pregunta.panel4.toCharArray()){
                    tf[i].setText(car.toString());
                    i++;
                }
            }
    }//GEN-LAST:event_buttonResolverActionPerformed

    private void buttonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmpezarActionPerformed
        cambiaPanelRapido();
    }//GEN-LAST:event_buttonEmpezarActionPerformed

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
            java.util.logging.Logger.getLogger(VPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEmpezar;
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JButton buttonResolver;
    private javax.swing.JComboBox cbCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JTextField tfBote;
    private javax.swing.JTextField tfLetra;
    private javax.swing.JTextField tfPista;
    // End of variables declaration//GEN-END:variables
}
