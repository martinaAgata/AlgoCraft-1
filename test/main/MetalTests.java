package main;

import main.herramientas.*;
import main.materiales.Material;
import main.materiales.Metal;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalTests {

    private static final int DURABILIDAD_INICIAL_METAL = 50;

    @Test
    public void testSeCreaMetalConDurabilidadCorrespondiente() {
        Metal metal = new Metal();
        assertThat(metal.getDurabilidad(), is(Metal.DURABILIDAD_METAL));
    }
    @Test
    public void testMetalNoEsDesgastadoPorHachaMadera() {
        Metal metal = new Metal();
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        hachaMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test03MetalNoEsDesgastadoPorHachaPiedra() {
        Material metal = new Metal();
        Hacha hachaPiedra = Hacha.nuevaHachaPiedra();
        hachaPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test04MetalNoEsDesgastadoPorHachaMetal() {
        Material metal = new Metal();
        Hacha hachaMetal = Hacha.nuevaHachaMetal();
        hachaMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test05MetalNoEsDesgastadoPorPicoMadera() {
        Material metal = new Metal();
        Pico picoMadera = Pico.nuevoPicoMadera();
        picoMadera.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test06MetalEsDesgastadoPorPicoPiedra() {
        Metal metal = new Metal();
        Pico picoPiedra = Pico.nuevoPicoPiedra();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
    }
    @Test
    public void test07MetalNoEsDesgastadoPorPicoMetal() {
        Metal metal = new Metal();
        Pico picoMetal = Pico.nuevoPicoMetal();
        picoMetal.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }
    @Test
    public void test08MetalNoEsDesgastadoPorPicoFino() {
        Metal metal = new Metal();
        PicoFino picoFino = new PicoFino();
        picoFino.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL));
    }

    @Test
    public void test09MetalEsDesgastadoPorPicoPiedraSeReduceVariasVeces(){
        Metal metal = new Metal();
        Pico picoPiedra = Pico.nuevoPicoPiedra();
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 4));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 8));
        picoPiedra.usar(metal);
        assertThat(metal.getDurabilidad(), is(DURABILIDAD_INICIAL_METAL - 12));
    }

    @Test(expected = IllegalStateException.class)
    public void test11MetalEsDesgastadoPorPicoPiedraLanzaExcepcionTrasRomperse(){
        Metal metal = new Metal();
        Pico picoPiedra = Pico.nuevoPicoPiedra();
        for (int i = 0; i < 14; i++) { picoPiedra.usar(metal); }
    }
}
