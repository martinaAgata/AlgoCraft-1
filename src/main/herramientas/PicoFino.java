package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealDecimal;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Diamante;
import main.materiales.Material;

public class PicoFino extends Herramienta {

    private static final int DURABILIDAD_PICO_FINO = 1000;
    private static final int FUERZA_PICO_FINO = 20;
    private static final double FACTOR_DESGASTE = 0.1;

    /* por si hacemos que sea un pico
    private PicoFino(EstrategiaDesgaste estrategia, int durabilidad, int fuerza){
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }*/

    public PicoFino() {
        this.estado = new EstadoVivo(DURABILIDAD_PICO_FINO);
        this.estrategia = new DesgasteLinealFactor(FACTOR_DESGASTE);
        this.fuerza = FUERZA_PICO_FINO;
    }

    public static PicoFino nuevoPicoFino() {
        PicoFino picoFino = new PicoFino();
        return  picoFino;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

    @Override
    public void desgastarDiamante(Diamante diamante) {
        diamante.reducirDurabilidad(this.fuerza);
    }

}