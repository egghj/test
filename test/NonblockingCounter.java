package cn.longyt.test;

import java.util.concurrent.atomic.AtomicInteger;

public class NonblockingCounter {

    private AtomicInteger value;// 前面提到过，AtomicInteger类是以原子的方式操作整型变量。

    public int getValue() {
        return value.get();
    }
    
    public int increment() {
        int v;
        do {
            v = value.get();
        } while (!value.compareAndSet(v, v + 1));
        return v + 1;
    }
}
