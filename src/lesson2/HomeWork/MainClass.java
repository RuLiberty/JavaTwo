package lesson2.HomeWork;

public class MainClass {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        String[][] myArray = new String[n][m]; // массим 4х3
        String[][] myArrayParse = new String[n][m]; // массим 4х3
        String[][] ArraySizeNot4 = new String[2][4]; // массив размеров не 4х4
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                myArray[i][k] = i + k + "";
            }
        }
        myArrayParse[0][0] = "fred";
        try {
            System.out.println("сумма = " + getMeArray(myArrayParse)); // Задание 2
            System.out.println("");
            System.out.println("сумма = " + getMeArray(myArray)); // Задание 1
            System.out.println("");
            System.out.println("сумма = " + getMeArray(ArraySizeNot4)); // Задание 1
            System.out.println("");
        } catch (Exception e) {
        }
        System.out.println("Конец программы!");
    }

    public static int getMeArray(String[][] s) throws Exception {
        int sum = 0;
        if (s.length != 4 || s[0].length != 4) {
            throw new MyArraySizeException();
        }
        System.out.println("На вход поступил массив размером 4х4");
        int[][] myIntArray = new int[4][4];
        int l = 0;
        int r = 0;
        try {
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < 4; k++) {
                    l = i;
                    r = k;
                    myIntArray[i][k] = Integer.parseInt(s[i][k]);
                    sum =+ myIntArray[i][k];
                }
            }
        } catch (Exception e) {
            throw new MyArrayDataException(l, r);
        }
    return sum;
    }
}