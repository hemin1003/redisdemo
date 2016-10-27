package com.minbo.redis.multi;

public class TestMulti {

	public static void main(String[] args) {
		RedisClientMulti redisClient = new RedisClientMulti();
//		redisClient.set("bank", "guangfa");
//		System.out.println(redisClient.get("bank"));
		
//		System.out.println(redisClient.exists("hash"));
		
//		redisClient.expire("bank", 1);
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(redisClient.type("bank"));
		
		System.out.println(redisClient.smembers("set"));
	}
	
}
