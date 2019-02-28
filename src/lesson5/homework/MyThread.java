package lesson5.homework;

public class MyThread extends Thread {

    private float[] arr;

    MyThread(float[] array){
    super();
    arr = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(Thread.currentThread().getName());
    }

}
