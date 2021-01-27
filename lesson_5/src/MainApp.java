public class MainApp {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        fillArr(arr);
        multithreadingFillArr(arr);

    }
    public static void fillArr (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        changeElemArr(arr,0);
//        printArr(arr);
        System.out.println("Время выполнения в обычном режиме: " + (System.currentTimeMillis() - a));
    }
    public static void multithreadingFillArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int hh = arr.length/2;
        float[] a1 = new float[hh];
        float[] a2 = new float[hh];
        float[] a1a2 = new float[arr.length];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, hh);
        System.arraycopy(arr, h, a2, 0, hh);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeElemArr(a1, 0);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeElemArr(a2, h);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Array a1");
//        printArr(a1);
//        System.out.println("Array a2");
//        printArr(a2);


        System.arraycopy(a1, 0, a1a2, 0, hh);
        System.arraycopy(a2, 0, a1a2, hh, hh);
        System.out.println("Время выполнения в многопоточном режиме: " + (System.currentTimeMillis() - a));
//        System.out.println("После склейки");
//        printArr(a1a2);


    }

    public static void printArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static float[] changeElemArr(float[] arr, int corrIndex) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + corrIndex) / 5) * Math.cos(0.2f + (i + corrIndex) / 5) * Math.cos(0.4f + (i + corrIndex) / 2));
        }
        return arr;
    }

}
