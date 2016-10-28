package com.minbo.redisdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.minbo.redis.common.GlobalParams;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

public class TestJedisHash {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis(GlobalParams.HOST_IP_A);
		System.out.println("Connection to server sucessfully");
		// hmset hmget
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("hashMap1", "hashValue11");
		hashMap.put("hashMap2", "hashValue22");
		hashMap.put("hashMap3", "hashValue33");
		hashMap.put("hashMap4", "hashValue44");
		String status = jedis.hmset("hashMapkey", hashMap);// 如果命令执行成功，返回OK
															// 。当key 不是哈希表(hash)
															// 类型时，返回一个错误。
		System.out.println("status=" + status);
		System.out.println("OK".equals(status) ? "操作成功 返回值" : "操作失败");

		// 返回值： 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样
		List<String> hashList = jedis.hmget("hashMapkey", "hashMap1 hashMap2 hashMap3 hashMap4".split(" "));
		for (String value : hashList) {
			System.out.println("对应的value值：  " + value + " ");// 返回值：
																// 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样
		}
		System.out.println();

		// hgetall 获得一个Map 返回key整个file域
		Map<String, String> hashMapKey = jedis.hgetAll("hashMapkey");

		// map的第一种迭代方式
		System.out.println("map的第一种迭代方式");
		Set<Map.Entry<String, String>> entry = hashMapKey.entrySet();
		Iterator<Map.Entry<String, String>> it = entry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> e = it.next();
			System.out.println("key: " + e.getKey() + "  value: " + e.getValue());
		}
		System.out.println();

		// map的第二种迭代方式
		System.out.println("map的第二种迭代方式");
		Set<String> keySet = hashMapKey.keySet();// map中的所有key在set中存放着，可以通过迭代set的方式，来获得key
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = hashMapKey.get(key);
			System.out.println("key: " + key + "  value: " + value);
		}
		System.out.println();

		// hscan 类似于 scan遍历库中 key下所有的域 返回 file-value 以map 的形式；
		System.out.println("hscan的用法");
		ScanParams scanParams = new ScanParams();
		// 完全匹配key值，不支持模糊匹配
		scanParams.match("hashMap1");
		//ScanResult<Map.Entry<String, String>> hscanResult = jedis.hscan("hashMapkey", "0", scanParams);
		ScanResult<Map.Entry<String, String>> hscanResult = jedis.hscan("", 1);
		int cursor = hscanResult.getCursor(); // 返回0 说明遍历完成
		System.out.println("游标" + cursor);
		List<Map.Entry<String, String>> scanResult = hscanResult.getResult();
		for (int m = 0; m < scanResult.size(); m++) {
			Map.Entry<String, String> mapentry = scanResult.get(m);
			System.out.println("key: " + mapentry.getKey() + "  value: " + mapentry.getValue());
		}
	}

}
