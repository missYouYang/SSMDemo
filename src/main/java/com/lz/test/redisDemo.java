package com.lz.test;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
   * 项目名            SSMDemo
   * 包名                com.lz.test
   * 文件名            redisDemo.java
   * 创建时间        2019年9月1日 下午2:27:20
 *@author  孙阳阳
   * 描述：
 * jedis 的demo
 */
public class redisDemo {
	
	//使用连接池
	public static void main(String[] args) {
		
		//连接池
		JedisPoolConfig jedsi = new JedisPoolConfig();
		//做大连接树
		jedsi.setMaxIdle(50);
		//最大等待时间
		jedsi.setMaxWaitMillis(100);
		//设置可校监性
		jedsi.setTestOnBorrow(true);
		
		JedisPool jedisPool = new JedisPool(jedsi, "127.0.0.1", 6379);
		
		//获取连接
		Jedis jedis = jedisPool.getResource();
		System.out.println(jedis.get("a"));
		
		//将连接池归还连接
		jedisPool.returnResource(jedis);
		
		//释放资源
		jedisPool.close();
	}
	
	
/*	public static void main(String[] args) {
		
		//链接服务
		Jedis jedis =  new Jedis("127.0.0.1",6379);;
		try {
			//设置值
			jedis.set("redis1", "re1");
			//从redis中获取数据
			List<String> mget = jedis.mget("a","redis1");
			for (int i = 0; i < mget.size(); i++) {
				System.out.println(mget.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jedis.close();
		}
		
	
	}*/
} 
