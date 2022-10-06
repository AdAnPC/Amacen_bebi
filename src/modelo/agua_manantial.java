
package modelo;


public class agua_manantial {
    private String marca;
    private double prec;
    private float cantLit;
    private int idag;
    private String origen;


    public agua_manantial() {
        this.marca="";
        this.prec=0;
        this.cantLit= 0;
        this.idag= 0;
        this.origen="";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    

//    public String getManantial() {
//        return marca;
//    }
//
//    public void setManantial(String manantial) {
//        this.marca = manantial;
//    }

    public double getSitio() {
        return prec;
    }

    public void setSitio(double sitio) {
        this.prec = sitio;
    }

    public double getPrec() {
        return prec;
    }
    

    public void setPrec(double prec) {
        this.prec = prec;
    }

    public float getCantLit() {
        return cantLit;
    }

    public void setCantLit(float cantLit) {
        this.cantLit = cantLit;
    }

    public int getIdag() {
        return idag;
    }

    public void setIdag(int idag) {
        this.idag = idag;
    }
    
    
}
