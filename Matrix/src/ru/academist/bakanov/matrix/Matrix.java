package ru.academist.bakanov.matrix;

import ru.academits.bakanov.vector.*;

public class Matrix {
    private int n;
    private Vector[] vector;

    public Matrix (int n, int m){
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("размер матрици должен быть больше 0");
        }
        for (int i = 0; i < n; i++){
                vector = new Vector[m];
                for(int j = 0; j < m; m++ ){
                    vector[j] = new Vector(1);
                }
            }
        }

}
