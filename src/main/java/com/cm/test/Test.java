package com.cm.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther cuimiao
 * @date 2017/12/26/026  22:51
 * @deprecated
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        /*String result = jedis.ping();// 测试连接
        System.out.println(result);
        jedis.close();*/

        //关键字（Keys）
        //字符串（String）
        /*System.out.println("set :" + jedis.set("name", "cuimiao"));
        System.out.println("set :" + jedis.set("name", "mengjia"));
        System.out.println("get :" + jedis.get("name"));
        System.out.println("exists :" + jedis.exists("name"));*/
        //System.out.println("del :"+ jedis.del("name"));

        //TODO 哈希（Hashs）
        /*for (int i = 0; i < 10; i++) {
            System.out.println("hset :" + jedis.hset("hset", "set-key" + i, "set-value" + i));
        }
        System.out.println("hkeys :"+ jedis.hkeys("hset"));*/

        //列表（Lists）
        /*System.out.println("rpush :"+ jedis.rpush("lset","lset001","lset002","lset003","lset004"));
        System.out.println("lrange :"+ jedis.lrange("lset",0,2));*/

        //集合（Sets）
        /*System.out.println("sadd :"+ jedis.sadd("sadd","sadd001","sadd002","sadd003"));
        System.out.println("scard :"+ jedis.scard("sadd"));*/

        //有序集合（Sorted Sets）
        /*Map<String,Double> scoreMembers =new HashMap<String,Double>();
        scoreMembers.put("001",0.1D);
        scoreMembers.put("002",0.2D);
        scoreMembers.put("003",0.3D);
        System.out.println("zadd :"+ jedis.zadd("zadd", scoreMembers));
        System.out.println("zrange :"+ jedis.zrange("zadd",1L,2L));*/

        //HyperLogLog
        /*for (int i = 0; i < 10; i++) {
            System.out.println("pfadd :" + jedis.pfadd("HyperLogLog", UUID.randomUUID().toString()));
        }
        jedis.pfadd("HyperLogLog", "cuimiao");
        jedis.pfadd("HyperLogLog", "cuimiao");
        System.out.println("pfcount :" + jedis.pfcount("HyperLogLog"));*/

        //发布/订阅（Pub/Sub）
        /*Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run ()
            {
                final Jedis j = new Jedis("127.0.0.1", 6379);
                j.subscribe(new JedisPubSub()
                {
                    @Override
                    public void onMessage (String channel, String message)
                    {
                        System.out.println("onMessage--channel:" + channel + " message:" + message);
                        this.unsubscribe();
                    }
                },"channel001");
                j.close();
                System.out.println("连接已关闭");
            }
        });
        thread.start();
        Thread.sleep(10);
        System.out.println("publish :" + jedis.publish("channel001", "发送一条消息"));
        System.out.println("publish :" + jedis.publish("channel001", "发送第二条消息"));
        System.out.println("publish :" + jedis.publish("channel001", "发送第三条消息"));*/

        //事务（Transactions）
        /*Transaction transaction = jedis.multi();
        System.out.println("set :"+ transaction.set("multi001","123"));
        System.out.println("incr :"+ transaction.incr("multi001"));
        System.out.println("transaction.exec :"+ transaction.exec());*/

        // 脚本（Scripting）
        /*System.out.println("eval :"+ jedis.eval("local msg = \"Hello, world!\" return msg"));*/

        //连接（Connection）
        /*System.out.println("ping :"+ jedis.ping());
        System.out.println("select :"+ jedis.select(0));*/
        System.out.println("set :" + jedis.set("name", "cuimiao"));
        System.out.println("dbSize :"+ jedis.dbSize());
        System.out.println("clientList :"+ jedis.clientList());
    }
}
