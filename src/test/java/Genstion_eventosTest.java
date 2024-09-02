import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Genstion_eventosTest {
    @Test
    public void testAgregarPersona() {
        String[][] entradas = new String[10][5];
        Gestion_eventos.agregarPersona(entradas, "Marco", "20", "VIP", "1", "False");

        assertEquals("Marco", entradas[0][0]);
        assertEquals("20", entradas[0][1]);
        assertEquals("VIP", entradas[0][2]);
        assertEquals("1", entradas[0][3]);
        assertEquals("False", entradas[0][4]);
    }
    @Test
    public void testVerificarEdad() {
        String[][] entradas = new String[10][5];
        Gestion_eventos.agregarPersona(entradas, "Marco", "20", "VIP", "1", "False");

        assertTrue(Gestion_eventos.verificarEdad(entradas, "Marco"));
        assertFalse(Gestion_eventos.verificarEdad(entradas, "Ana"));
    }
    @Test
    public void testVerificarBoleto() {
        String[][] entradas = new String[10][5];
        Gestion_eventos.agregarPersona(entradas, "Marco", "20", "VIP", "1", "False");
        Gestion_eventos.agregarPersona(entradas, "Ana", "15", "General", "1", "False");

        assertEquals("VIP", Gestion_eventos.verificarBoleto(entradas, "Marco"));
        assertEquals("false", Gestion_eventos.verificarBoleto(entradas, "Ana"));
    }
}
