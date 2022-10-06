package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Estenteria;
import modelo.agua_manantial;
import modelo.bebidas;
//import modelo.bebidas_azucaradas;
import vista.Vista;

public class Controlador implements ActionListener {

    private Vista vi;
    private Estenteria es;
    private int pos;
   
    public Controlador(Vista vi, Estenteria es) {
        this.vi = vi;
        this.es = es;
        this.pos = pos;
        vi.btnagre.addActionListener(this);
        //   vi.btnagre_2.addActionListener(this);
        //   vi.btnagre_3.addActionListener(this);
        vi.btneli.addActionListener(this);
        vi.btnmos.addActionListener(this);
        vi.cbopro.addActionListener(this);
        vi.btncalc.addActionListener(this);
        vi.cbocalPor.addActionListener(this);
        vi.btnarchi.addActionListener(this);
        vi.btnelArchi.addActionListener(this);
        vi.btnleerA.addActionListener(this);
        vi.btncrear.addActionListener(this);
        vi.btnElAchi.addActionListener(this);

    }

    public void iniciar() {
        vi.setTitle("Nomina De Empleados...");
        vi.setLocationRelativeTo(null);
    }

    public void agrgarbebidas() {
        try {

            if (vi.cbotipo.getSelectedIndex() == 0) {
                bebidas tem = new bebidas();
                tem.setCantLit(Integer.parseInt(vi.txtlitagu.getText()));
                tem.setId(Integer.parseInt(vi.txtidag.getText()));
                tem.setMarca(vi.txtmarcaaa.getText());
                tem.setPrec(Integer.parseInt(vi.txtpecioag.getText()));
                tem.setPorazu(Float.parseFloat(vi.txtporc.getText()));
                tem.setPromo(es.porcentaje(vi.cbopro.getSelectedIndex() + 1));

                if (es.get_lengt() > this.pos) {
                    JOptionPane.showMessageDialog(null, "se ingresaron los datos correctamente");
                    es.setBebidas(tem, pos);
                    pos++;

                } else {

                    JOptionPane.showMessageDialog(null, "el vector esta lleno");
                }
            } else if (vi.cbotipo.getSelectedIndex() == 1) {
                // public void agua (){
                agua_manantial tem = new agua_manantial();
                tem.setCantLit(Integer.parseInt(vi.txtlitagu.getText()));
                tem.setIdag(Integer.parseInt(vi.txtidag.getText()));
                tem.setMarca(vi.txtmarcaaa.getText());
                tem.setOrigen(vi.txtorigen.getText());
                tem.setPrec(Integer.parseInt(vi.txtpecioag.getText()));

                if (es.get_lengt() > this.pos) {
                    JOptionPane.showMessageDialog(null, "se ingresaron los datos correctamente");
                    es.setAgua_manantial(tem, pos);
                    pos++;

                } else {

                    JOptionPane.showMessageDialog(null, "el vector esta lleno");
                }
                //    JOptionPane.showMessageDialog(null, "se ingresaron los datos correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarLinea() throws IOException {
        vi.txtmos.setText(es.EEl(Integer.parseInt(vi.txtelimi.getText())));

    }

    public void crearArchivo() throws IOException {

        JOptionPane.showMessageDialog(null, es.crate("bebidas.txt"));
    }

    public void calcular() {
        vi.txtmosCal.setText(es.suTota(vi.cbobA.getSelectedIndex() + 1));
    }

    public void escriArchivo() throws IOException {
        es.agregarAvhivo();

    }

    public void calcuBebi() {
        vi.txtmosCal.setText(es.suma(vi.txtcalBe.getText()));

    }

    public void mostrar() {
        vi.txtmos.setText(es.mostrar());
    }

    public void leerAr() throws IOException {

        vi.txtmos.setText(es.muestraContenido("bebidas.txt"));

    }

    public void eliminar() throws IOException {
////        JOptionPane.showMessageDialog(null, "se elimino");

        es.eliminar(Integer.parseInt(vi.txtelimi.getText()));

    }

    public void eliArcivo() {
        es.elimi("bebidas.txt");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == vi.btnagre) {
                agrgarbebidas();
            }

            if (e.getSource() == vi.btnarchi) {
                escriArchivo();
            }

            if (e.getSource() == vi.btneli) {
                eliminar();
            }
            if (e.getSource() == vi.btnmos) {
                mostrar();
            }
            if (e.getSource() == vi.btncalc) {
                calcular();
            }
            if (e.getSource() == vi.cbocalPor) {
                calcuBebi();
            }
            if (e.getSource() == vi.btnelArchi) {
                eliArcivo();
            }
            if (e.getSource() == vi.btnleerA) {
                leerAr();
            }

            if (e.getSource() == vi.btnElAchi) {
                borrarLinea();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
