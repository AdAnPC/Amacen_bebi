
package modelo;

import controlador.Controlador;
import java.io.IOException;
import vista.Vista;


public class Principal {
    public static void main(String[] args)throws IOException {
       
        Estenteria es = new Estenteria (15);
        
        Vista vi = new Vista ();
        Controlador co = new Controlador (vi , es );
        co.iniciar();
        vi.setVisible(true);
        
        
    }
    
}
