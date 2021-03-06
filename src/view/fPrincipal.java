/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author root
 */
public class fPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form fPrincipal
     */
    public fPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFuncion = new javax.swing.JTextField();
        jCheckBoxDerivadaTripl = new javax.swing.JCheckBox();
        jCheckBoxDerivadaDoble = new javax.swing.JCheckBox();
        grafica = new javax.swing.JPanel();
        txtResultado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTituloFuncion = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        btnHacercaDe = new javax.swing.JLabel();
        txtFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Derivada Calc");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFuncion.setBackground(new java.awt.Color(0, 102, 102));
        txtFuncion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtFuncion.setForeground(new java.awt.Color(245, 185, 14));
        txtFuncion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFuncion.setText("((x^3)+y)/(x-2y)");
        txtFuncion.setBorder(null);
        txtFuncion.setCaretColor(new java.awt.Color(220, 53, 69));
        txtFuncion.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtFuncion.setSelectionColor(new java.awt.Color(220, 53, 69));
        getContentPane().add(txtFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 560, 30));

        jCheckBoxDerivadaTripl.setBackground(new java.awt.Color(21, 69, 79));
        jCheckBoxDerivadaTripl.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBoxDerivadaTripl.setText("Derivada Triple");
        jCheckBoxDerivadaTripl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxDerivadaTripl.setRequestFocusEnabled(false);
        getContentPane().add(jCheckBoxDerivadaTripl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        jCheckBoxDerivadaDoble.setBackground(new java.awt.Color(21, 69, 79));
        jCheckBoxDerivadaDoble.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBoxDerivadaDoble.setText("Derivada Doble");
        jCheckBoxDerivadaDoble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxDerivadaDoble.setRequestFocusEnabled(false);
        getContentPane().add(jCheckBoxDerivadaDoble, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        grafica.setBackground(new java.awt.Color(21, 69, 79));
        grafica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(grafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 800, 410));

        txtResultado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(204, 204, 204));
        txtResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResultado.setText(". . .");
        txtResultado.setToolTipText("Show Result");
        getContentPane().add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 800, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opcionales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 500, 40));

        txtTituloFuncion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTituloFuncion.setForeground(new java.awt.Color(204, 204, 204));
        txtTituloFuncion.setText("F(x):");
        getContentPane().add(txtTituloFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 30));

        btnCalcular.setText("<html> \n<head> \t\n<style>  \t\n\t.btnprimary {\n\t    height: 25px;\n\t    color: white;\n\t    padding:5px;\n\t    margin-top:2px;\n \t    background-color: #28a745;\n \t    border-color: #28a745;\n\t\tborder-radius: 40%;\n\t} \t \n</style> \n</head> \n<body> <div class=\"btnprimary\">Calcular</div> \n</body> \n</html>");
        btnCalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, 30));

        jCheckBox1.setBackground(new java.awt.Color(21, 69, 79));
        jCheckBox1.setForeground(new java.awt.Color(40, 167, 69));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("f (x)");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setRequestFocusEnabled(false);
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(21, 69, 79));
        jCheckBox2.setForeground(new java.awt.Color(220, 53, 69));
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("f '(x)");
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.setRequestFocusEnabled(false);
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jCheckBox3.setBackground(new java.awt.Color(21, 69, 79));
        jCheckBox3.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox3.setText("Coordenadas");
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox3.setRequestFocusEnabled(false);
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        btnHacercaDe.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnHacercaDe.setText("<html> \n<head> \t\n<style>  \t\n\t.btnprimary {\n\t    height: 25px;\n\t    color: white;\n\t    padding:5px;\n\t    margin-top:2px;\n \t    background-color: #17a2b8;\n \t    border-color: #17a2b8;\n\t\tborder-radius: 40%;\n\t} \t \n</style> \n</head> \n<body> <div class=\"btnprimary\">?</div> \n</body> \n</html>");
        btnHacercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnHacercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 20, 30));

        txtFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFondo.setText("<html>  <head> \t \n<style> \t\n\t.background {  \t\t\n\t\tpadding:0px;margin:0px;\n \t\ttext-align:center; \n\t\theight: 450px;\n \t\twidth: 1050px; \n\t\tbackground: #15454F; \n\t} \t  \n</style>  \n</head> \n <body> \n<div class=\"background\"></div>\n  </body> \n </html>");
        getContentPane().add(txtFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

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
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnCalcular;
    public javax.swing.JLabel btnHacercaDe;
    public javax.swing.JPanel grafica;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JCheckBox jCheckBox3;
    public javax.swing.JCheckBox jCheckBoxDerivadaDoble;
    public javax.swing.JCheckBox jCheckBoxDerivadaTripl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtFondo;
    public javax.swing.JTextField txtFuncion;
    public javax.swing.JLabel txtResultado;
    private javax.swing.JLabel txtTituloFuncion;
    // End of variables declaration//GEN-END:variables
}
