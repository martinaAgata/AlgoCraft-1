package main;

public abstract class Herramienta {

    private Estado estado;
    private EstrategiaDesgaste estrategia;
    private int durabilidad;
    private int fuerza;

    public Herramienta(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        this.durabilidad = durabilidad;
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    public void usar(Material material) {
        this.durabilidad = estrategia.desgastar(fuerza, estado); //DESGASTAR
        this.desgastarMaterial(material);
    }

    public int getFuerza(){
        return fuerza;
    }

    protected abstract void desgastarMaterial(Material material);
}