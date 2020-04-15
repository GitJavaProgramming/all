package org.pp.zookeeper.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public abstract class AbstractLock implements Lock {
    /**
     * 获取锁的重试次数
     */
    private static final int RE_TRY = 10;

    @Override
    public void lock() {
        int count = RE_TRY;
        while (!this.tryLock() && count > 0) {
            count--;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
