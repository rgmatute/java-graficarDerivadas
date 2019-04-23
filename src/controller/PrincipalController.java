package controller;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Eventos;
import view.fPrincipal;

public class PrincipalController extends Eventos {

    private fPrincipal fp;
    JPanel panel;

    public PrincipalController(fPrincipal fp) {
        this.fp = fp;
        init();
    }

    private void init() {
        //formulario
        this.fp.setVisible(true);
        this.fp.setLocationRelativeTo(null);
        //eventos
        this.fp.btnCalcular.addMouseListener(this);
        this.fp.btnHacercaDe.addMouseListener(this);
        this.fp.txtResultado.addMouseListener(this);
        this.fp.jCheckBox1.addActionListener(this);
        this.fp.jCheckBox2.addActionListener(this);
        this.fp.jCheckBox3.addActionListener(this);
        //ejecutar Boton Calculat
        //panel = new Grafica3();
        panel = new GraficaController(fp);
        graficar();
        calcular(1);
    }

    private void graficar() {
        //panel = new Grafica3();
        //fp.grafica.setSize(800, 900);
        panel.setPreferredSize(new Dimension(fp.grafica.getWidth() + 20, fp.grafica.getHeight()));
        fp.grafica.add(panel);
        panel.setCursor(Cursor.getPredefinedCursor(12));
        panel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.fp.btnCalcular.equals(e.getSource())) {
            graficar();
            if (!(this.fp.jCheckBoxDerivadaDoble.isSelected() & this.fp.jCheckBoxDerivadaTripl.isSelected())) {
                if (this.fp.jCheckBoxDerivadaDoble.isSelected()) {
                    calcular(2);
                } else if (this.fp.jCheckBoxDerivadaTripl.isSelected()) {
                    calcular(3);
                } else {
                    calcular(1);
                }
            } else {
                error();
            }
        } else if (e.getSource().equals(this.fp.txtResultado)) {
            JOptionPane.showMessageDialog(null, this.fp.txtResultado.getText(), "Derivada", 1);
            //this.fp.txtResultado.setText(". . .");
        } else if (e.getSource().equals(this.fp.btnHacercaDe)) {
            String Integrantes = "*a\n*b\n*c\n*d\n*e";
            JOptionPane.showMessageDialog(fp, Integrantes, "Integrantes", 1);
        }
    }
    public static String r;

    private void calcular(int i) {
        r = DerivadaController.Derivar(this.fp.txtFuncion.getText());
        switch (i) {
            case 1:
                this.fp.txtResultado.setText(resultado(r));
                break;
            case 2:
                r = DerivadaController.Derivar(r);
                this.fp.txtResultado.setText(resultado(r));
                break;
            case 3:
                r = DerivadaController.Derivar(r);
                r = DerivadaController.Derivar(r);
                this.fp.txtResultado.setText(resultado(r));
                break;
        }
    }

    private String resultado(String result) {
        int letra = 0;
        if (result.length() >= 151) {
            letra = 9;
        } else {
            letra = 11;
        }
        //danger #dc3545
        String html = ""
                + "<html>"
                + "<head><style></style>"
                + "</head>"
                + "<body>"
                + "<div style='padding-top:7px;background:#713545;height:25px; width:616px;text-align:center;'><span style='color:#8fC9CA; font-size: " + letra + "px;'>f'(x)=" + result.replace("sqrt", "raíz") + "<span>"
                + "<div>"
                + "</body>"
                + "</html>";
        return html;
    }

    private void error() {
        JOptionPane.showMessageDialog(fp, "No puede seleccionar Derivada Doble y Triple a la vez", "Error :'(", 0);
        this.fp.jCheckBoxDerivadaTripl.setSelected(false);
        this.fp.jCheckBoxDerivadaDoble.setSelected(false);
        this.fp.txtResultado.setText(". . .");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (fp.jCheckBox1.equals(e.getSource())) {
            panel.repaint();
        } else if (fp.jCheckBox2.equals(e.getSource())) {
            panel.repaint();
        } else if (fp.jCheckBox3.equals(e.getSource())) {
            panel.repaint();
        }
    }
}
