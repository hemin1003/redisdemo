package com.minbo.redisdemo;

import java.util.Set;

import com.minbo.redis.common.GlobalParams;

import redis.clients.jedis.Jedis;

public class RedisKeysJava {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis(GlobalParams.HOST_IP_A);
		System.out.println("Connection to server sucessfully");

		// 获取所有Redis上已有的全部Key值，获取数据并输出
		Set<String> set = jedis.keys("*");
		System.out.println("stored keys:: " + set.toString());
	}
}
