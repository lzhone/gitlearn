package com.lzh.redis;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class TestClusterRedis {
	
	public static void main(String[] args) {
	
		Set<HostAndPort> jedisClusterNode=new HashSet<>();	
		
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7001));
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7002));
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7003));
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7004));
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7005));
		jedisClusterNode.add(new HostAndPort("192.168.183.128", 7006));
		
		//创建连接池
		JedisPoolConfig cfg=new JedisPoolConfig();
		cfg.setMaxTotal(100); //最大连接
		cfg.setMaxIdle(20);
		cfg.setMaxWaitMillis(-1);//等待
		cfg.setTestOnBorrow(true);
		JedisCluster jc=new JedisCluster(jedisClusterNode,6000,100,cfg);
		
	
		System.out.println(jc.set("age", "25"));
		jc.close();
	}
}
