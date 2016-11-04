package com.minbo.redis.cluster;

import java.util.HashSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 集群
 */
public class ClusterTest {
	public static void main(String[] args) {
		// 初始化集合，用于装下面的多个主机和端口
		HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();
		String hostIp = "192.168.0.152";

		// 创建多个主机和端口实例
		HostAndPort hostAndPort = new HostAndPort(hostIp, 7000);
		HostAndPort hostAndPort1 = new HostAndPort(hostIp, 7001);
		HostAndPort hostAndPort2 = new HostAndPort(hostIp, 7002);
		HostAndPort hostAndPort3 = new HostAndPort(hostIp, 7003);
		HostAndPort hostAndPort4 = new HostAndPort(hostIp, 7004);
		HostAndPort hostAndPort5 = new HostAndPort(hostIp, 7005);

		// 添加多个主机和端口到集合中
		nodes.add(hostAndPort);
		nodes.add(hostAndPort1);
		nodes.add(hostAndPort2);
		nodes.add(hostAndPort3);
		nodes.add(hostAndPort4);
		nodes.add(hostAndPort5);

		// 创建config
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// 通过config创建集群实例
		JedisCluster jedisCluster = new JedisCluster(nodes, poolConfig);
		// 获取集群中的key为name键的值
		//jedisCluster.set("name", "hemin");
		//System.out.println("name=" + jedisCluster.get("name"));
		System.out.println("name=" + jedisCluster.get("name"));
		System.out.println("address=" + jedisCluster.get("address"));
	}
}
