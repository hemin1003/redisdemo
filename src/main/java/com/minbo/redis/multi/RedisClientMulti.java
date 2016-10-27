package com.minbo.redis.multi;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

public class RedisClientMulti {
	private static RedisServiceMultiImpl redisService = new RedisServiceMultiImpl();

	public void disconnect() {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		shardedJedis.disconnect();
	}

	/**
	 * 设置单个值
	 */
	public String set(String key, String value) {
		String result = null;

		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.set(key, value);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 获取单个值
	 */
	public String get(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}

		boolean flag = false;
		try {
			result = shardedJedis.get(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Boolean exists(String key) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.exists(key);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String type(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.type(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 在某段时间后失效
	 */
	public Long expire(String key, int seconds) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.expire(key, seconds);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 在某个时间点失效
	 */
	public Long expireAt(String key, long time) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.expireAt(key, time);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long ttl(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.ttl(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public boolean setbit(String key, long offset, boolean value) {

		ShardedJedis shardedJedis = redisService.getRedisClient();
		boolean result = false;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.setbit(key, offset, value);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public boolean getbit(String key, long offset) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		boolean result = false;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;

		try {
			result = shardedJedis.getbit(key, offset);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public long setrange(String key, long offset, String value) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		long result = 0L;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.setrange(key, offset, value);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String getrange(String key, long startOffset, long endOffset) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getrange(key, startOffset, endOffset);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String getSet(String key, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getSet(key, value);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long setnx(String key, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.setnx(key, value);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String setex(String key, int seconds, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.setex(key, seconds, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long decrBy(String key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.decrBy(key, integer);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long decr(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.decr(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long incrBy(String key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.incrBy(key, integer);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long incr(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.incr(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long append(String key, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.append(key, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String substr(String key, int start, int end) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.substr(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long hset(String key, String field, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hset(key, field, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String hget(String key, String field) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hget(key, field);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long hsetnx(String key, String field, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hsetnx(key, field, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String hmset(String key, Map<String, String> hash) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hmset(key, hash);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public List<String> hmget(String key, String... fields) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hmget(key, fields);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long hincrBy(String key, String field, long value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hincrBy(key, field, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Boolean hexists(String key, String field) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hexists(key, field);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long del(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.del(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long hdel(String key, String field) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hdel(key, field);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long hlen(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hlen(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> hkeys(String key) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hkeys(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public List<String> hvals(String key) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hvals(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Map<String, String> hgetAll(String key) {
		Map<String, String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.hgetAll(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 在redis list尾部增加一个String
	 */
	public Long rpush(String key, String string) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.rpush(key, string);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 在redis list头部增加一个String
	 */
	public Long lpush(String key, String string) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lpush(key, string);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long llen(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.llen(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public List<String> lrange(String key, long start, long end) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lrange(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String ltrim(String key, long start, long end) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.ltrim(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String lIndex(String key, long index) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lindex(key, index);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String lset(String key, long index, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lset(key, index, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long lrem(String key, long count, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lrem(key, count, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 从redis list头部取出一个key
	 */
	public String lpop(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.lpop(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	/**
	 * 从redis list尾部取出一个key
	 */
	public String rpop(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.rpop(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long sadd(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.sadd(key, member);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> smembers(String key) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.smembers(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long srem(String key, String member) {
		ShardedJedis shardedJedis = redisService.getRedisClient();

		Long result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.srem(key, member);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String spop(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.spop(key);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long scard(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		Long result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.scard(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Boolean sismember(String key, String member) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		Boolean result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.sismember(key, member);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String srandmember(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.srandmember(key);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zadd(String key, double score, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.zadd(key, score, member);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrange(String key, int start, int end) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.zrange(key, start, end);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zrem(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.zrem(key, member);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Double zincrby(String key, double score, String member) {
		Double result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zincrby(key, score, member);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zrank(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrank(key, member);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zrevrank(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrank(key, member);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrevrange(String key, int start, int end) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrange(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrangeWithScores(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrangeWithScores(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zcard(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zcard(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Double zscore(String key, String member) {
		Double result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zscore(key, member);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public List<String> sort(String key) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.sort(key);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public List<String> sort(String key, SortingParams sortingParameters) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.sort(key, sortingParameters);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zcount(String key, double min, double max) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zcount(key, min, max);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrangeByScore(String key, double min, double max) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrangeByScore(key, max, min);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max, offset, count);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrangeByScore(key, max, min, offset, count);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {

		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max, offset, count);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min, offset, count);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zremrangeByRank(String key, int start, int end) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zremrangeByRank(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long zremrangeByScore(String key, double start, double end) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.zremrangeByScore(key, start, end);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisService.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {

			result = shardedJedis.linsert(key, where, pivot, value);

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public List<Object> pipelined(ShardedJedisPipeline shardedJedisPipeline) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		List<Object> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.pipelined(shardedJedisPipeline);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Jedis getShard(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		Jedis result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getShard(key);
		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public JedisShardInfo getShardInfo(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		JedisShardInfo result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getShardInfo(key);
		} catch (Exception e) {
			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public String getKeyTag(String key) {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getKeyTag(key);
		} catch (Exception e) {
			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Collection<JedisShardInfo> getAllShardInfo() {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		Collection<JedisShardInfo> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getAllShardInfo();

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}

	public Collection<Jedis> getAllShards() {
		ShardedJedis shardedJedis = redisService.getRedisClient();
		Collection<Jedis> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean flag = false;
		try {
			result = shardedJedis.getAllShards();

		} catch (Exception e) {

			flag = true;
		} finally {
			redisService.returnResource(shardedJedis, flag);
		}
		return result;
	}
}
