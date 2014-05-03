package org.smart4j.cache.redis;

import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.smart4j.cache.SmartCache;
import org.smart4j.cache.SmartCacheManager;

public class RedisCacheTest {
    /**
     * 默认cacheManager.getCache("redis");  默认对应config.properties中的cache.redis.ip
     * cacheManager.getCache("xxx"); 对应config.properties中的cache.redis.ip.xxx
     *
     * */

    @Test
    public void test() {
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<String, Object> cache = cacheManager.getCache("redis");
        System.out.println(cache.get("lu"));
        System.out.println(cache.put("lu","heihei"));
        System.out.println(cache.get("lu"));


    }

    @Test
    public void test2() {
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("one");


        System.out.println(cache.put(123,123));
        System.out.println(cache.get(123));

    }

    @Test
    public void testRemove(){
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("xxx");
        System.out.println(cache.get(123));
        System.out.println(cache.remove(123));
        System.out.println(cache.get(123));
    }

    @Test
    public void testClear(){
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.get(123));
        cache.clear();
        System.out.println(cache.get(123));
        System.out.println(cache.get("lu"));
    }

    @Test
    public void testSize(){
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.size());
    }

    @Test
    public void testKeys(){
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        Set<Object> keys =cache.keys();
        for(Object obj:keys){
            System.out.println(obj.toString());
        }
    }

    @Test
    public void testValues(){
        SmartCacheManager cacheManager = new RedisCacheManager();
        SmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        Collection<Object> list =cache.values();
        for(Object obj:list){
            System.out.println(obj.toString());
        }
    }



//    @Test
//    public void listTest() {
//        List<String> list = new ArrayList<String>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//    }
}
