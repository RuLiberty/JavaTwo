package lesson5.homework;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        getArr(arr);
        System.out.println("Время работы 1 метода: " + (System.currentTimeMillis() - startTime) + " мс.");
        System.out.println();

        startTime = System.currentTimeMillis();
        threadGetArr(arr);
        System.out.println("Время работы 2 метода: " + (System.currentTimeMillis() - startTime) + " мс.");
        System.out.println();
    }

    static void getArr(float[] arr){
        MyThread thread = new MyThread();
        thread.run(arr);
    }

    static void threadGetArr(float[] arr){
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MyThread thread1 = new MyThread();
        thread1.run(a1);

        MyThread thread2 = new MyThread();
        thread2.run(a2);

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
