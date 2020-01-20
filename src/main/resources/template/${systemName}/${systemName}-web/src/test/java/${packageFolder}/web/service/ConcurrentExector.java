package ${package}.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import ${package}.web.AbstractTest;

/**
 * 并发执行器
 * <p>需要实现并发测试，继承本类并实现executor方法。executor方法内编码需求并发执行的代码</p>
 * @author lwy
 *
 */
public abstract class ConcurrentExector extends AbstractTest{
	private int threads = 100;
	private static CountDownLatch latch;
	
	@Test
	public void start(){
		latch = new CountDownLatch(threads);
		long startTime = System.currentTimeMillis();
		List<Thread> subThreads = new ArrayList<>();
		for (int i = 0; i < threads; i++) {
			Thread subThread = new Thread(new ExecutorRunnable());
			subThreads.add(subThread);
			subThread.start();
		}
		for (Thread thread : subThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
		logger.info(String.format("threads=%s,costTime=%sms", threads, System.currentTimeMillis()-startTime));
	}
	
	private class ExecutorRunnable implements Runnable{
		@Override
		public void run() {
			try {
				latch.countDown();
				latch.await();
				executor();
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	/**
	 * 执行器，编码执行的代码
	 */
	protected abstract void executor();
}