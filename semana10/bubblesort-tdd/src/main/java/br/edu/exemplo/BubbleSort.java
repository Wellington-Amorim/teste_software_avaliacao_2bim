package br.edu.exemplo;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        if (numeros == null || numeros.length <= 1) {
            return;
        }

        int n = numeros.length;
        boolean houveTroca;

        for (int i = 0; i < n - 1; i++) {
            houveTroca = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    trocar(j, j + 1);
                    houveTroca = true;
                }
            }

            if (!houveTroca) {
                break;
            }
        }
    }

    private void trocar(int indiceA, int indiceB) {
        int temp = numeros[indiceA];
        numeros[indiceA] = numeros[indiceB];
        numeros[indiceB] = temp;
    }

    public int[] getNumeros() {
        return numeros;
    }
}