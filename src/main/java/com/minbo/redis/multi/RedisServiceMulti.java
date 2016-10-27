package com.minbo.redis.multi;

import redis.clients.jedis.ShardedJedis;

public interface RedisServiceMulti {
	
	public ShardedJedis getRedisClient();

	public void returnResource(ShardedJedis shardedJedis);

	public void returnResource(ShardedJedis shardedJedis, boolean broken);
	
}
