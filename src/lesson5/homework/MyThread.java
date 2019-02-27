package lesson5.homework;

public class MyThread extends Thread {

    public void run(float[] arr) {
        super.run();
        float[] res = arr;
        for (int i = 0; i < arr.length; i++) {
            res[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(res[5]);
    }

}
