package com.minbo.redisdemo;

import com.minbo.redis.common.GlobalParams;

import redis.clients.jedis.Jedis;

public class RedisJava {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis(GlobalParams.HOST_IP_B);
		System.out.println("Connection to server sucessfully");
		// 查看服务是否运行
		System.out.println("Server is running: " + jedis.ping());
	}
}
