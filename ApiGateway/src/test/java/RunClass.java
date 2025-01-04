public class RunClass {

    public static void main(String[] args) {
        MultiThread m = new MultiThread();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.start();
//        t1.yield();
//        System.out.println();
        t2.start();
        t1.start();

//        for (int i=0;i<100;i++){
//            System.out.print (i+ " ");
//        }

    }
}
