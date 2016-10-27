package com.minbo.redisdemo;

import com.minbo.redis.common.GlobalParams;

import redis.clients.jedis.Jedis;

public class RedisStringJava {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis(GlobalParams.HOST_IP_A);
		System.out.println("Connection to server sucessfully");
		// 设置 redis 字符串数据
		jedis.set("address", "heng yang");
		// 获取存储的数据并输出
		System.out.println("Stored string in redis:: " + jedis.get("address"));
	}

}
