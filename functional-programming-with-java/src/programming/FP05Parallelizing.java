package programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //0 - 1000000000
        //System.out.println(LongStream.range(0,1000000000).sum());//1528 ms
//        for(int i=0; i<10;i++){//3336ms
//            System.out.println(LongStream.range(0,1000000000).sum());
//        }

        for(int i=0; i<10;i++){//279ms
            System.out.println(LongStream.range(0,1000000000).parallel().sum());
        }
        //System.out.println(LongStream.range(0,1000000000).parallel().sum());//74ms
        System.out.println(System.currentTimeMillis() - time);
    }
}
