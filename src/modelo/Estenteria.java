package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.ArrayBufferView;
import java.util.*;

public class Estenteria {

    private bebidas[] bebidas;
    private agua_manantial[] agua_manantial;
    private File File;
    private FileWriter fileW;
    private BufferedWriter buF;
    private PrintWriter escri;
    private String name;

    public Estenteria(int tam) {
        this.agua_manantial = new agua_manantial[tam];
        this.bebidas = new bebidas[tam];
        this.File = null;
        this.fileW = null;
        this.buF = null;
        this.escri = null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public bebidas getBebidas(int pos) {
        return bebidas[pos];
    }

    public void setBebidas(bebidas bebidas, int pos) {
        this.bebidas[pos] = bebidas;
    }

    public bebidas[] getBebidas() {
        return bebidas;
    }

    public agua_manantial[] getAgua_manantial() {
        return agua_manantial;
    }

    public agua_manantial getAgua_manantial(int pos) {
        return agua_manantial[pos];
    }

    public void setAgua_manantial(agua_manantial agua_manantial, int dato) {
        this.agua_manantial[dato] = agua_manantial;
    }

    public int get_lengt() {
        return this.bebidas.length;
    }

    public String mostrar() {

        String msj = "";
        msj += "marca \t cantidad litro \t id \t precio \t porcentaje azucar   \t  promocion \t origen \n ";
        for (int a = 0; a < get_lengt(); a++) {
            if (getBebidas(a) != null) {
                msj += getBebidas(a).getMarca() + "\t ";
                msj += getBebidas(a).getCantLit() + " \t ";
                msj += getBebidas(a).getId() + "\t";
                msj += getBebidas(a).getPrec() + "\t";
                msj += getBebidas(a).getPorazu() + "\t" + "\t";
                msj += getBebidas(a).getPromo() + "\n";
                //  return msj;

            } else if (getAgua_manantial(a) != null) {
                msj += "agua " + getAgua_manantial(a).getMarca() + "\t";
                msj += getAgua_manantial(a).getCantLit() + "\t";
                msj += getAgua_manantial(a).getIdag() + "\t";
                msj += getAgua_manantial(a).getPrec() + "\t";
                msj += "  " + "\t" + "\t";
                msj += "  " + "\t";
                msj += getAgua_manantial(a).getOrigen() + " \n";

            }

        }

        return msj;

    }

    public String eliminar(int pos) {
        String msj = "";
        //  boolean encontrado = false;
        for (int a = 0; a < get_lengt(); a++) {
            if (getBebidas(a) != null) {
                if (this.bebidas[a].getId() == pos) {
                    setBebidas(null, a);

                    msj = "se elimino ";
                    //  break;
                }
            } else if (getAgua_manantial(a) != null) {
                if (this.agua_manantial[a].getIdag() == pos) {
                    setAgua_manantial(null, a);
                    msj = "se eliminooo";
                    break;
                }

            }
        }
        return msj;
    }

    public String crate(String name) throws IOException {
        String msj = "";
        setName(name);
        String message = "";
        this.File = new File(getName());
        if (!this.File.exists()) {
            try {
                this.File.createNewFile();
                message = "Archivo creado";
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            message = "El archivo ya existe";
        }
        return msj;

    }

    public void agregarAvhivo() throws IOException {
        String msj = "";
        try {
            fileW = new FileWriter("bebidas.txt", true);
            for (int a = 0; a < get_lengt(); a++) {
                if (getBebidas(a) != null) {
                    fileW.write(String.valueOf(getBebidas(a).getId()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getBebidas(a).getMarca()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getBebidas(a).getPrec()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getBebidas(a).getCantLit()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getBebidas(a).getPromo()));
                    fileW.write("\n");
                    setBebidas(null, a);

                } else if (getAgua_manantial(a) != null){
                    fileW.write(String.valueOf(getAgua_manantial(a).getIdag()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getAgua_manantial(a).getMarca()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getAgua_manantial(a).getPrec()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getAgua_manantial(a).getCantLit()));
                    fileW.write(",");
                    fileW.write(String.valueOf(getAgua_manantial(a).getOrigen()));
                    fileW.write("\n");
                    
                   
                }else{
                    fileW.close();
                }
            }
        } catch (Exception e) {
        }
    }

    public int porcentaje(int por) {
        int pre;
        if (por == 1) {
            pre = 10;
        } else {
            pre = 0;
        }
        return pre;
    }

    public String suma(String mar) {
        double val = 0;
        String msj = "";
        for (int a = 0; a < get_lengt(); a++) {
            if (getBebidas(a) != null) {
                if (getBebidas(a).getMarca().equals(mar)) {
                    val = val + getBebidas(a).getPrec();
                }

            } else if (getAgua_manantial(a) != null) {
                if (getAgua_manantial(a).getMarca().equals(mar)) {
                    val = val + getAgua_manantial(a).getPrec();

                }
            }
            msj = "valor de las " + mar + " es de " + val;

        }
        return msj;
    }

    public String suTota(int bebi) {
        double tot = 0;
        String msj = "";
        if (bebi == 1) {
            for (int a = 0; a < get_lengt(); a++) {
                if (getBebidas(a) != null) {
                    tot = tot + getBebidas(a).getPrec();
                }
            }

        } else if (bebi == 2) {
            for (int a = 0; a < get_lengt(); a++) {
                if (getAgua_manantial(a) != null) {
                    tot = tot + getAgua_manantial(a).getPrec();

                }

            }

        } else if (bebi == 3) {
            for (int a = 0; a < get_lengt(); a++) {
                if (getBebidas(a) != null) {
                    tot = tot + getBebidas(a).getPrec();
                } else if (getAgua_manantial(a) != null) {
                    tot = tot + getAgua_manantial(a).getPrec();
                }
            }
        }
        msj = "el valor total es " + tot;

        return msj;
    }

    public String elimi(String arrego) {
        File Archivo = new File(arrego);
//        byte[] byteArr = arrego.getBytes();
        String msj = "";
//        Archivo.exists();
        Archivo.delete();
        return msj;
    }

    public String EliminarAr(int pos) throws IOException {
        agregarAvhivo();
        String linea;
        int con = 0;
        String com = "";

        File f = new File("bebidas.txt");
        FileReader f1 = new FileReader(f);
        BufferedReader b = new BufferedReader(f1);
        while ((linea = b.readLine()) != null) {
            Object[] data = b.lines().toArray();
            for (int a = 0; a < data.length; a++) {
                String line = data[a].toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[0].equals(pos)) {
//                    setBebidas(null, a);
                    String li = dataRow[0];
                    linea = li;
                    linea = "   ";
                    System.out.println(linea);
                }
                System.out.println(data[0]);
                System.out.println(data[1]);
                System.out.println(linea);
//                System.out.println(data[2]);

            }
        }
        return com;
    }

    public String muestraContenido(String archivo) throws IOException {
        String otra = "";
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            otra += cadena + "\n";
        }
        b.close();
        return otra;
    }

    public String EEl(int pos) throws FileNotFoundException, IOException {
        String msj = "";
        File EtFile = new File("bebidas.txt");
        File tempFile = new File("bebidast.txt");
        BufferedReader leer = new BufferedReader(new FileReader(EtFile));
        BufferedWriter escribir = new BufferedWriter(new FileWriter(tempFile));
        int lineaeliminar;
        lineaeliminar = pos;
        String listaactual;
        int contar = 0;
        while ((listaactual = leer.readLine()) != null) {
            contar++;
            if (contar == lineaeliminar) {
                continue;
            }
            escribir.write(listaactual + System.getProperty("line.separator"));
        }
        escribir.close();
        leer.close();
        EtFile.delete();
        tempFile.renameTo(EtFile);
        return msj;
    }
}
