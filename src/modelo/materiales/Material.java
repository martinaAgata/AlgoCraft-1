package modelo.materiales;
import modelo.estados.Estado;
import modelo.juego.Ubicable;
import modelo.herramientas.Herramienta;

public abstract class Material implements Desgastable, Ubicable {

    protected Estado estado;

    public Material desgastarCon(Herramienta herramienta){ return this; }
    public void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }
    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

}