package com.minbo.redis.single;

/**
 * 重点看这个类：RedisServiceSingleImpl
 */
public class TestSingle {

	public static void main(String[] args) {
		RedisClientSingle redisClient = new RedisClientSingle();
//		redisClient.set("province", "guangzhou");
		System.out.println(redisClient.get("province"));
	}

}
