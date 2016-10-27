package com.minbo.redis.single;

import com.minbo.redis.common.GlobalParams;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 单机模式
 */
public class RedisServiceSingleImpl implements RedisServiceSingle {

	private static JedisPool pool = null;
	
	public RedisServiceSingleImpl(){
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(500);
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(5);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(1000 * 100);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			pool = new JedisPool(config, GlobalParams.HOST_IP_B, GlobalParams.PORT_B);
		}
	}
	
	public JedisPool getJedisPool() {
		try {
			return pool;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返还到连接池
	 * @param pool
	 * @param redis
	 */
	public void returnResource(Jedis jedis) {
		if (jedis != null) {
			pool.returnResource(jedis);
		}
	}

	public void returnResource(Jedis jedis, boolean broken) {
		if (broken) {
			pool.returnBrokenResource(jedis);
		} else {
			pool.returnResource(jedis);
		}
	}
}
