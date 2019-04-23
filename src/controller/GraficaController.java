package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.type.Complex;
import view.fPrincipal;

public class GraficaController extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

    private fPrincipal fp;
    private JEP miEvaluador;
    Node nodin;
    int puntosInt;
    boolean errorEnExpresion; //si hay error de sintaxis en la función
    boolean errorEnNumero; //si hay error de sintaxis en la función
    int Galto, Gancho;       //dimesiones de la zona de graficación
    int x0, y0;           //origen
    int escalaX, escalaY;
    int aumento1, aumento2;
    int intervaloA, intervaloB;
    int numeroDeInteraciones;
    double xmin, xmax, imgx;
    //
    int offsetX, offsetY;
    boolean dragging;
    //TIPOS DE FUENTE
    Font ft10 = new Font("Arial", Font.PLAIN, 10);
    Font ft12 = new Font("Arial", Font.PLAIN, 12);
    Font ft7 = new Font("Arial", Font.PLAIN, 10);//funte de los numeros

    //VARIABLES PARA GROSOR DE LAS LINEAS
    final static BasicStroke grosor1 = new BasicStroke(3.5f); //thickness
    final static float dash1[] = {5.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);

    GraficaController(fPrincipal fp) {
        this.fp = fp;
        setBackground(new Color(21, 69, 79));
        offsetX = x0;
        offsetY = y0;
        //
        Gancho = fp.grafica.getWidth() + 19;
        Galto = fp.grafica.getHeight() + 10;
        //
        escalaX = 30;
        escalaY = 30;
        x0 = Gancho / 2;
        y0 = Galto / 2;
        aumento1 = 7;
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);

        //EVALUADOR DE FUNCIONES
        miEvaluador = new JEP();
        miEvaluador.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluador.addStandardConstants();
        miEvaluador.addComplex();
        //miEvaluador.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluador.addVariable("x", 0);
        miEvaluador.addVariable("y", 1);
        miEvaluador.addVariable("a", 3);
        miEvaluador.addVariable("b", 4);
        miEvaluador.setImplicitMul(true); //permite 2x en vez de 2*x
        miEvaluador.parseExpression("(x^3)-(6x^2)-15x+40");//((x^3)+y)/(x-2y)
        errorEnExpresion = miEvaluador.hasError(); //hay error?
    }

    public void mousePressed(MouseEvent evt) {
        if (dragging) {
            return;
        }
        int x = evt.getX();  // clic inicial
        int y = evt.getY();
        offsetX = x - x0;
        offsetY = y - y0;
        dragging = true;
    }

    public void mouseReleased(MouseEvent evt) {
        dragging = false;
        repaint();
    }

    public void mouseDragged(MouseEvent evt) {
        if (dragging == false) {
            return;
        }
        int x = evt.getX();   // posicin del mouse
        int y = evt.getY();
        x0 = x - offsetX;     // mover origen
        y0 = y - offsetY;
        repaint();
    }

    public void mouseWheelMoved(MouseWheelEvent evt) {
        int zoom = evt.getWheelRotation();
        escalaY += -zoom;
        escalaX += -zoom;
        repaint();
    }

    //el resto hace nada 
    public void mouseMoved(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graficar(g, x0, y0);
    }

    //METODO QUE PINTA TODA LA GRçFICA
    void Graficar(Graphics ap, int xg, int yg) {
        int cxmin, cxmax, cymin, cymax;
        //convertimos el objeto ap en un objeto Graphics2D para usar los mtodos Java2D
        Graphics2D g = (Graphics2D) ap;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setFont(ft10);
        //g.setPaint(new Color(130,216,245));// color ejes

        //PINTAMOS EL EJE X Y EL EJE Y
        g.draw(new Line2D.Double(xg, 10, xg, Galto - 10)); //EJE Y
        g.draw(new Line2D.Double(10, yg, Gancho - 10, yg));//EJE X

        xmin = -1.0 * xg / escalaX;
        xmax = (1.0 * (Gancho - xg) / escalaX);
        cxmin = (int) Math.round(xmin); //pantalla
        cxmax = (int) Math.round(xmax);

        intervaloA = -10;
        intervaloB = 10;
        puntosInt = 99;
        //intervalos para pintar funcin
        cymin = (int) Math.round(1.0 * (yg - Galto) / escalaY);
        cymax = (int) Math.round(1.0 * yg / escalaY);

        //numPuntos = Gancho; //num pixels
        g.setPaint(new Color(0, 102, 102));//COLOR CUADRICULA
        g.setFont(ft7);

        //PINTAMOS TODOS LOS EJES PARA FORMAR LA CUADRICULA
        if (escalaX > 5) {
            for (int i = cxmin; i <= cxmax; i++) {   //EJES PARALELOS AL EJE Y
                g.setPaint(new Color(0, 102, 102));//COLOR CUADRICULA
                g.draw(new Line2D.Double(xg + i * escalaX, yg - 2, xg + i * escalaX, yg + 2));
                if ((xg + i * escalaX) != xg) {
                    g.draw(new Line2D.Double(xg + i * escalaX, 10, xg + i * escalaX, Galto - 10));
                }

                if (i > 0) {
                    g.setPaint(new Color(245, 185, 14));//COLOR NUMEROS #dc3545
                    g.drawString("" + i, xg + i * escalaX - aumento1, yg + 12);
                }
                if (i < 0) {
                    g.setPaint(new Color(245, 185, 14));//COLOR NUMEROS #dc3545
                    g.drawString("" + i, xg + i * escalaX - 8, yg + 12);
                }
            }
        }

        if (escalaY > 5) {
            for (int i = cymin + 1; i < cymax; i++) {   //EJES PARALELOS AL EJE X
                g.setPaint(new Color(0, 102, 102));//COLOR CUADRICULA
                g.draw(new Line2D.Double(xg - 2, yg - i * escalaY, xg + 2, yg - i * escalaY));
                if ((yg - i * escalaY) != yg) {
                    g.draw(new Line2D.Double(10, yg - i * escalaY, Gancho - 10, yg - i * escalaY));
                }
                if (i > 0) {
                    g.setPaint(new Color(245, 185, 14));//COLOR NUMEROS #dc3545
                    g.drawString("" + i, xg - 12, yg - i * escalaY + 8);
                }
                if (i < 0) {
                    g.setPaint(new Color(245, 185, 14));//COLOR NUMEROS #dc3545
                    g.drawString("" + i, xg - 14, yg - i * escalaY + 8);
                }
            }
        }

        //g.setPaint(new Color(29,220,248));//COLOR DE LA FUNCION
        //g.setPaint(new Color(146,32,8));
        g.setPaint(new Color(40, 167, 69));//COLOR DE LA FUNCION

        g.setStroke(grosor1);
        int[] color = new int[3];
        color[0] = 40;
        color[1] = 167;
        color[2] = 69;
        if (fp.jCheckBox1.isSelected()) {
            miEvaluador.parseExpression(fp.txtFuncion.getText().replace("raíz", "sqrt"));
            errorEnExpresion = miEvaluador.hasError(); //hay error?
            pintarFuncion(g, xg, yg, color);
        }

        //funcion de la derivada
        color[0] = 220;
        color[1] = 53;
        color[2] = 69;
        if (fp.jCheckBox2.isSelected()) {
            miEvaluador.parseExpression(PrincipalController.r);
            errorEnExpresion = miEvaluador.hasError(); //hay error?
            pintarFuncion(g, xg, yg, color);
        }
    }//Graficar

    double dist(double xA, double yA, double xB, double yB) {
        return (xA - xB) * (xA - xB) + (yA - yB) * (yA - yB);
    }//

    private void pintarFuncion(Graphics2D g, int xg, int yg, int[] color) {
        int xi = 0, yi = 0, xi1 = 0, yi1 = 0, numPuntos = 1;
        double valxi = 0.0, valxi1 = 0.0, valyi = 0.0, valyi1 = 0.0;
        if (!errorEnExpresion) {
            //if (fp.jCheckBox2.isSelected()) {
            //g.setPaint(new Color(220, 53, 69));//COLOR DE LA FUNCION
            g.setPaint(new Color(color[0], color[1], color[2]));//COLOR DE LA FUNCION

            g.setStroke(grosor1);
            //CICLO QUE PINTA LA FUNCIÓN
            int c = 0;
            for (int i = (xg + intervaloA * escalaX); i < (xg + intervaloB * escalaY) - 1; i++)//numPuntos
            {
                //g.setPaint(new Color(220, 53, 69));//COLOR DE LA FUNCION
                g.setPaint(new Color(color[0], color[1], color[2]));//COLOR DE LA FUNCION
                valxi = xmin + i * 1.0 / escalaX;
                valxi1 = xmin + (i + 1) * 1.0 / escalaX;
                miEvaluador.addVariable("x", valxi);
                valyi = miEvaluador.getValue();
                miEvaluador.addVariable("x", valxi1);
                valyi1 = miEvaluador.getValue();
                xi = (int) Math.round(escalaX * (valxi));
                yi = (int) Math.round(escalaY * valyi);
                xi1 = (int) Math.round(escalaX * (valxi1));
                yi1 = (int) Math.round(escalaY * valyi1);

                //control de discontinuidades groseras y complejos
                //control de puntos
                if (i % (100 - puntosInt) == 0) {
                    Complex valC = miEvaluador.getComplexValue();
                    //System.out.println("valc "+valC);
                    double imgx = (double) Math.abs(valC.im());
                    if (dist(valxi, valyi, valxi1, valyi1) < 1000 && imgx == 0) {
                        g.draw(new Line2D.Double(xg + xi, yg - yi, xg + xi1, yg - yi1));
                        if (fp.jCheckBox3.isSelected()) {

                            c++;
                            if (c == 10) {
                                c = 0;
                                g.setPaint(new Color(150, 185, 14));//COLOR DE LAS COORDENADAS
                                g.drawString("{" + String.format("%.2f", valxi) + " , " + String.format("%.2f", valyi) + "}", (xg + xi) - 60, (yg - yi));
                                //g.drawString("(" + Math.round(valxi) + "," + Math.round(valyi) + ")", (xg + xi) - 30, (yg - yi));
                                //g.draw(new Line2D.Double(x1, y1, x2, y2));
                            }
                        }
                    }
                }
            }
        }//fin del for 
        //}
    }
}
