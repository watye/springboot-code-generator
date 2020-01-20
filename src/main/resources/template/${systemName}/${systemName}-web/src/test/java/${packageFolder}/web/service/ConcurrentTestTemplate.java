package ${package}.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.web.service.ConcurrentTestTemplate.PipeLineRunnable;

import ${package}.web.AbstractTest;

/**
 * 并发测试模板
 * @author lwy
 */
public class ConcurrentTestTemplate extends AbstractTest{
	/**
	 * 并发数设置
	 */
	private static final int THREADS = 500;
	private static final CountDownLatch latch = new CountDownLatch(THREADS);
	
	@Test
	public void testConcurrent() throws InterruptedException{
		long startTime = System.currentTimeMillis();
		List<Thread> subThreads = new ArrayList<>();
		for (int i = 0; i < THREADS; i++) {
			Thread subThread = new Thread(new PipeLineRunnable());
			subThreads.add(subThread);
			subThread.start();
		}
		for (Thread thread : subThreads) {
			thread.join();
		}
		System.out.println(String.format("threads=%s,costTime=%sms", THREADS, System.currentTimeMillis()-startTime));
	}
	
	private class PipeLineRunnable implements Runnable{
		@Override
		public void run() {
			try {
				latch.countDown();
				latch.await();
				curd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void curd(){
	}
}