package com.minbo.redis.multi;

import java.util.ArrayList;
import java.util.List;

import com.minbo.redis.common.GlobalParams;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

/**
 * 分布式模式 ShardedJedis是基于一致性哈希算法实现的分布式Redis集群客户端
 */
public class RedisServiceMultiImpl implements RedisServiceMulti {
	private ShardedJedisPool shardedJedisPool;

	public RedisServiceMultiImpl() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();// Jedis池配置
		poolConfig.setMaxTotal(500);// 最大活动的对象个数
		poolConfig.setMaxIdle(1000 * 60);// 对象最大空闲时间
		poolConfig.setMaxWaitMillis(1000 * 10);// 获取对象时最大等待时间
		poolConfig.setTestOnBorrow(true);
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(1);
		JedisShardInfo infoA = new JedisShardInfo(GlobalParams.HOST_IP_A, GlobalParams.PORT_A);
		// infoA.setPassword("123456");
		// JedisShardInfo infoB = new JedisShardInfo(GlobalParams.HOST_IP_B,
		// GlobalParams.PORT_B);
		// infoB.setPassword("123456");
		shards.add(infoA);
		// shards.add(infoB);
		shardedJedisPool = new ShardedJedisPool(poolConfig, shards, Hashing.MURMUR_HASH,
				Sharded.DEFAULT_KEY_TAG_PATTERN);
	}

	public ShardedJedis getRedisClient() {
		try {
			return shardedJedisPool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
		} else {
			shardedJedisPool.returnResource(shardedJedis);
		}
	}
}
