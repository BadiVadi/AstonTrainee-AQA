package org.example;

public class ArrayChecker {

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(validArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        String[][] invalidArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };

        try {
            int result = processArray(invalidArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int expectedRows = 4;
        int expectedCols = 4;

        if (array.length != expectedRows || !validateColumns(array, expectedCols)) {
            throw new MyArraySizeException("Размер массива не равен 4х4");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }

    private static boolean validateColumns(String[][] array, int expectedCols) {
        for (String[] row : array) {
            if (row.length != expectedCols) {
                return false;
            }
        }
        return true;
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}