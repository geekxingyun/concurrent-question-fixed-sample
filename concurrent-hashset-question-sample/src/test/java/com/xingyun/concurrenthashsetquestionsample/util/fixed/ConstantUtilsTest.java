package com.xingyun.concurrenthashsetquestionsample.util.fixed;

import junit.framework.TestCase;

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * @author qingfeng.zhao
 * @date 2024/6/6
 * @apiNote
 */
public class ConstantUtilsTest extends TestCase {

    private static final int THREAD_NUM = 100; // 模拟100个并发线程
    private static final int COUNT_DOWN = THREAD_NUM; // 计数器

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetGoodApiList()throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        CountDownLatch latch = new CountDownLatch(COUNT_DOWN);

        for (int i = 0; i < THREAD_NUM; i++) {
            executorService.submit(() -> {
                try {
                    // 模拟业务逻辑，调用ConstantUtils.getGoodsList()方法
                    Set<String> goodList= ConstantUtils.getGoodApiList();
                } finally {
                    latch.countDown(); // 线程执行完毕，计数器减一
                }
            });
        }

        latch.await(); // 等待所有线程执行完毕
        executorService.shutdown(); // 关闭线程池

        System.out.println("所有线程执行完毕!");
        for (int i = 0; i < 10; i++) {
            Set<String> goodList= ConstantUtils.getGoodApiList();
            System.out.println("-----start--------------");
            for (String item:goodList){
                System.out.println(item+"---"+goodList.size());
            }
            System.out.println("-----end--------------");
        }
    }
}