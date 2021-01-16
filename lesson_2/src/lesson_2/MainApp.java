package lesson_2;

import java.nio.channels.ScatteringByteChannel;

public class MainApp {
    public static void main(String[] args) {
        String[][] arr1 = {
            {"2", "4", "1", "5"},
            {"3", "8", "2", "3"},
            {"6", "8"},
            {"4", "6", "0", "1"},
        };
        String[][] arr2 = {
                {"2", "4", "1", "5"},
                {"3", "8", "2", "3s"},
                {"6", "8", "3", "5"},
                {"4", "6", "0", "1"},
        };

        try {
            System.out.println("Summa of elements of array: " + checkSizeAndSumArrElements(arr1));
        } catch (MyArraySizeException e) {
            System.out.println("Input array is not 4x4");
        } catch (MyArrayDataException e) {
            System.out.println("Element of input array (row: " + e.getRow() + " , col: " + e.getCol() + ") is not a number");
        }

        try {
            System.out.println("Summa of elements of array: " + checkSizeAndSumArrElements(arr2));
        } catch (MyArraySizeException e) {
            System.out.println("Input array is not 4x4");
        } catch (MyArrayDataException e) {
            System.out.println("Element of input array (row: " + e.getRow() + " , col: " + e.getCol() + ") is not a number");
        }



    }

    /**
     *
     * @param arr проверяется на соответствии размерности 4х4
     * @throws MyArraySizeException будет брошен если массив не будет соответствовать размерности 4х4
     */
    public static void isArr4x4 (String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Input array in not 4x4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Input array in not 4x4");
            }
        }
    }

    /**
     *
     * @param arr проверяется на возможность преобразования элементов в целые числа и вычисляет их сумму
     * @return возвращает сумму элементов массива arr
     * @throws MyArrayDataException будет брошен если хотя бы один из элементов массива arr невозможно преобразовать в целое число
     */
    public static int sumArrElements (String[][] arr) throws MyArrayDataException {
        int sum =0;
        int i =0, j = 0;
        try {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[i].length; j++){
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Illegal data in array element, row: " + i +" col: "+ j, i, j);
        }
        return sum;
    }

    /**
     *
     * @param arr проверяется на соответствии размерности 4х4, проверяется на возможность преобразования элементов
     *           в целые числа и вычисляет их сумму
     * @return возвращает сумму элементов массива arr
     * @throws MyArraySizeException будет брошен если массив не будет соответствовать размерности 4х4
     * @throws MyArrayDataException будет брошен если хотя бы один из элементов массива arr невозможно преобразовать в целое число
     */
    public static int checkSizeAndSumArrElements (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        isArr4x4(arr);
        sum = sumArrElements(arr);
        return sum;
    }

}
