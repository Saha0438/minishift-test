package com.pavan.demoservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisMain {

	public static void main(String args[]) {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");

		RedissonClient client = Redisson.create(config);

		RMap<String, Integer> rmap = client.getMap("pavan-hash");
		
		ExecutorService executor = Executors.newFixedThreadPool(3);

		System.out.println("*************************************************************" + rmap.get("pavan"));
		for (int i = 0; i < 100; i++) {
			RLock rlock = client.getFairLock("pavan");
			rlock.lock();
			executor.submit(new MyThread(rmap));
			rlock.unlock();
		}
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS);
			executor.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("*************************************************************" + rmap.get("pavan"));
	}
}

class MyThread implements Runnable {
	private RMap<String, Integer> rmap;

	public MyThread(RMap<String, Integer> rmap) {
		this.rmap = rmap;
	}

	public void run() {
		Integer inte = rmap.get("pavan");
		if (null == inte) {
			inte = 0;
		}
		inte = inte + 1;
		rmap.put("pavan", inte);
	}
}