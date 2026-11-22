package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void deveCriarProdutoValido() {
        Produto produto = new Produto("Teclado", 100.00);

        assertEquals("Teclado", produto.getNome());
        assertEquals(100.00, produto.getPreco(), 0.001);
    }

    @Test
    void devePermitirProdutoComPrecoZero() {
        Produto produto = new Produto("Brinde", 0.00);

        assertEquals(0.00, produto.getPreco(), 0.001);
    }

    @Test
    void naoDevePermitirProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Teclado", -100.00);
        });
    }

    @Test
    void naoDevePermitirProdutoComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", 100.00);
        });
    }

    @Test
    void naoDevePermitirProdutoComNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto(null, 100.00);
        });
    }
}