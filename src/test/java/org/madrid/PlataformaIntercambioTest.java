package org.madrid;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class PlataformaIntercambioTest {

    @Test
    void addCartera() {
        PlataformaIntercambio p = new PlataformaIntercambio();
        Cartera c1 = new Cartera("Carlos");
        Cartera c2 = new Cartera("María");

        assertTrue(p.addCartera(c1));
        assertTrue(p.addCartera(c2));

        assertEquals("Carlos", p.getListaCarteras()[0].getUsuario());
        assertEquals("María", p.getListaCarteras()[1].getUsuario());
        assertEquals(2, p.getNumeroCarteras());
    }




    @Test
    void buscarCartera() {
        PlataformaIntercambio p = new PlataformaIntercambio();
        Cartera c1 = new Cartera("Carlos");
        Cartera c2 = new Cartera("María");
        Cartera c3 = new Cartera("Lucia");


        assertTrue(p.addCartera(c1));
        assertTrue(p.addCartera(c2));
        assertTrue(p.addCartera(c3));
        assertEquals(p.getNumeroCarteras(), 3);
        System.out.println(c1.equals(p.getListaCarteras()[0]));
        assertEquals(c1,p.getListaCarteras()[0]);
        assertEquals(0, p.buscarCarteraRecursiva("Carlos",0));
        assertEquals(1, p.buscarCarteraRecursiva("María",0));
        assertEquals(2, p.buscarCarteraRecursiva("Lucia",0));
        assertEquals(p.getListaCarteras()[p.buscarCarteraRecursiva("Carlos",0)], c1);
        assertEquals(p.getListaCarteras()[p.buscarCarteraRecursiva("María",0)], c2);
        assertEquals(p.getListaCarteras()[p.buscarCarteraRecursiva("Lucia",0)], c3);


    }

    @Test
    void addMonedaCartera() {
        PlataformaIntercambio p = new PlataformaIntercambio();
        Cartera c1 = new Cartera("Carlos");
        Cartera c2 = new Cartera("María");
        CriptoMoneda ayusocoin = new CriptoMoneda("AyusoCoin", 2.5, 20000.0,"SHA-256");
        CriptoMoneda etherum = new CriptoMoneda("Ether", 3.3, 1500.0,"Ethash");

        try {
            p.addCartera(c1);
            p.addCartera(c2);
        } catch (Exception e) {
            fail("No debería lanzar excepción");
        }

        p.addMonedaCartera("Carlos", ayusocoin);
        p.addMonedaCartera("Carlos", etherum);
        ayusocoin.setCantidad(3.5);
        p.addMonedaCartera("María", ayusocoin);

        assertEquals(2, p.getListaCarteras()[p.buscarCarteraRecursiva("Carlos",0)].getNumCriptomonedas());
        assertEquals(1, p.getListaCarteras()[p.buscarCarteraRecursiva("María",0)].getNumCriptomonedas());
        assertEquals(2.5, p.getListaCarteras()[p.buscarCarteraRecursiva("Carlos",0)].getCriptomonedas()[0].getCantidad());
        assertEquals(3.3, p.getListaCarteras()[p.buscarCarteraRecursiva("Carlos",0)].getCriptomonedas()[1].getCantidad());
        assertEquals(3.5, p.getListaCarteras()[p.buscarCarteraRecursiva("María",0)].getCriptomonedas()[0].getCantidad());

    }
}