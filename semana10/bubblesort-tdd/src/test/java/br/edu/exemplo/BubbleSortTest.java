package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    void deveOrdenarVetorDesordenado() {
        int[] entrada = {5, 3, 8, 4, 2};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{2, 3, 4, 5, 8}, bubbleSort.getNumeros());
    }

    @Test
    void deveManterVetorJaOrdenado() {
        int[] entrada = {1, 2, 3, 4, 5};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bubbleSort.getNumeros());
    }

    @Test
    void deveOrdenarVetorEmOrdemInversa() {
        int[] entrada = {9, 7, 5, 3, 1};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, bubbleSort.getNumeros());
    }

    @Test
    void deveOrdenarVetorComElementosDuplicados() {
        int[] entrada = {4, 2, 4, 1, 2};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, bubbleSort.getNumeros());
    }

    @Test
    void deveOrdenarVetorComNumerosNegativos() {
        int[] entrada = {-3, 10, -1, 0, 5};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{-3, -1, 0, 5, 10}, bubbleSort.getNumeros());
    }

    @Test
    void deveLidarComVetorUnitario() {
        int[] entrada = {42};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{42}, bubbleSort.getNumeros());
    }

    @Test
    void deveLidarComVetorVazio() {
        int[] entrada = {};
        BubbleSort bubbleSort = new BubbleSort(entrada);

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{}, bubbleSort.getNumeros());
    }

    @Test
    void deveLidarComVetorNuloSemLancarExcecao() {
        BubbleSort bubbleSort = new BubbleSort(null);

        assertDoesNotThrow(bubbleSort::ordenar);
        assertNull(bubbleSort.getNumeros());
    }
}