package main.materiales;

import main.EstadoVivo;

public class Metal extends Material {

    public static final int DURABILIDAD_METAL = 50;
    public Metal() {
        this.estado = new EstadoVivo(DURABILIDAD_METAL);
    }

    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
