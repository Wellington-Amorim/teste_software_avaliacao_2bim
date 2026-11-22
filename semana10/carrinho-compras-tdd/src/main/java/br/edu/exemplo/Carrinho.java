package br.edu.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {

    private static final double VALOR_MINIMO_DESCONTO = 500.00;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    private final List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();

        if (subtotal >= VALOR_MINIMO_DESCONTO) {
            return subtotal * (1.0 - PERCENTUAL_DESCONTO);
        }

        return subtotal;
    }

    private double calcularSubtotal() {
        double soma = 0.0;
        for (Produto produto : produtos) {
            soma += produto.getPreco();
        }
        return soma;
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }
}