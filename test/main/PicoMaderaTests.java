package main;

import main.herramientas.Pico;
import main.herramientas.ConstructorPico;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        assertThat(picoMadera.getFuerza() , is(2));
    }

    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is (98));
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is (98));


    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoMadera = ConstructorPico.construirPicoMadera();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is (98));

    }
}
