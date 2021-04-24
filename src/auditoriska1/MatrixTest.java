package auditoriska1;

import java.util.Arrays;

public class MatrixTest {

    public static double sumOfMatrix(double[][] matrix){
       //matrix.length; //zema broj na redici
        double sum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                sum+=matrix[i][j];
            }
        }
        //return sum;
        return Arrays.stream(matrix)
                .flatMapToDouble(row -> Arrays.stream(row)) //celta na flatMapa e matrica da pretvoris vo niza
                .average()
                .getAsDouble();
    }

    public static double averageOfMatrix(double[][] matrix){
        double sum = sumOfMatrix(matrix);
        return sum/(matrix.length * matrix[0].length);
    }

    public static void main(String[] args) {
        double[] array = {1,2,3,4,5};
        double[][] matrix = {{1,2,3},{6,5,4}};
        double sum = 0;
        double avg = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                sum = sumOfMatrix(matrix);
                avg = averageOfMatrix(matrix);
            }
        }
        System.out.println(sum);
        System.out.println(avg);
    }
}
