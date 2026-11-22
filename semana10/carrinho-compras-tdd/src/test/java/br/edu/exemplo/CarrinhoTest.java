package br.edu.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    void deveIniciarComTotalZero() {
        assertEquals(0.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmProduto() {
        Produto teclado = new Produto("Teclado", 100.00);

        carrinho.adicionar(teclado);

        assertEquals(100.00, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void deveAdicionarVariosProdutos() {
        Produto teclado = new Produto("Teclado", 100.00);
        Produto mouse = new Produto("Mouse", 50.00);

        carrinho.adicionar(teclado);
        carrinho.adicionar(mouse);

        assertEquals(150.00, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void deveRemoverProduto() {
        Produto teclado = new Produto("Teclado", 100.00);
        Produto mouse = new Produto("Mouse", 50.00);

        carrinho.adicionar(teclado);
        carrinho.adicionar(mouse);
        carrinho.remover(mouse);

        assertEquals(100.00, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void naoDevePermitirAdicionarProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Produto produtoInvalido = new Produto("Teclado", -100.00);
            carrinho.adicionar(produtoInvalido);
        });
    }

    @Test
    void naoDevePermitirAdicionarProdutoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.adicionar(null);
        });
    }

    @Test
    void deveAplicarDescontoDeDezPorCento() {
        Produto monitor = new Produto("Monitor", 600.00);

        carrinho.adicionar(monitor);

        assertEquals(540.00, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void naoDeveAplicarDescontoAbaixoDeQuinhentos() {
        carrinho.adicionar(new Produto("Item", 499.99));

        assertEquals(499.99, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void deveAplicarDescontoParaTotalExatoDeQuinhentos() {
        carrinho.adicionar(new Produto("Item", 500.00));

        assertEquals(450.00, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void deveAplicarDescontoAcimaDeQuinhentos() {
        carrinho.adicionar(new Produto("Item", 500.01));

        assertEquals(450.009, carrinho.calcularTotal(), 0.001);
    }
}