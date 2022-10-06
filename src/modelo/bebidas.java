
package modelo;


public class bebidas {
    private int id;
    private float cantLit;
    private float prec;
    private String marca ;
    private float porazu;
    private float promo;


    public bebidas() {
        this.cantLit= 0;
        this.id=0;
        this.marca="";
        this.prec=0;
        this.promo = 0;
        this.porazu=0;
        
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public double getCantLit() {
        return cantLit;
    }

    public void setCantLit(float cantLit) {
        this.cantLit = cantLit;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(float prec) {
        this.prec = prec;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPorazu() {
        return porazu;
    }

    public void setPorazu(float porazu) {
        this.porazu = porazu;
    }

    public float getPromo() {
        return promo;
    }

    public void setPromo(float promo) {
        this.promo = promo;
    }
    
   
}
 