package JZOffer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-24
 */
public class Foo {

    AtomicInteger turn = new AtomicInteger(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        turn.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (turn.get() != 2) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        turn.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (turn.get() != 3) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
