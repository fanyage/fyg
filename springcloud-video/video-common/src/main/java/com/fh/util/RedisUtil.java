package com.fh.util;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUtil {
    public static String get(String key) {
        Jedis resources = null;
        String getKey = null;
        try {
            resources = RedisPool.getResources();
            getKey = resources.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
        return getKey;
    }

    public static void set(String key, List value) {
        Jedis resources = null;
        try {
            resources = RedisPool.getResources();
            resources.set(key, String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
    }

    public static boolean exist(String key) {
        Jedis resource = null;
        boolean exist = false;
        try {
            resource = RedisPool.getResources();
            exist = resource.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
        return exist;
    }


    public static boolean exist(String key, String field) {
        Jedis resource = null;
        boolean exist = false;
        try {
            resource = RedisPool.getResources();
            exist = resource.hexists(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
        return exist;
    }

    public static void lpush(String key, List value) {
        Jedis resources = null;
        try {
            resources = RedisPool.getResources();
            resources.lpush(key, String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
    }

    public static String lpop(String key) {
        Jedis resources = null;
        String getKey = null;
        try {
            resources = RedisPool.getResources();
            getKey = resources.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
        return getKey;
    }

    //设置生命周期
    public static void expire(String key, int seconds) {
        Jedis resources = null;
        try {
            resources = RedisPool.getResources();
            resources.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
    }

    public static void set(String key, String value) {
        Jedis resources = null;
        try {
            resources = RedisPool.getResources();
            resources.set(key, String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
    }

    public static Long del(String key) {
        Jedis resource = null;
        Long delCount = 0L;
        try {
            resource = RedisPool.getResources();
            delCount = resource.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
        return delCount;
    }

    public static void setex(String key, int seconds, String value) {
        Jedis resources = null;
        try {
            resources = RedisPool.getResources();
            resources.setex(key, seconds, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (resources != null) {
                resources.close();
            }
        }
    }

    public static String hget(String key, String field) {
        Jedis resource = null;
        String result = "";
        try {
            resource = RedisPool.getResources();
            result = resource.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
        return result;
    }

    public static Long hdel(String key, String field) {
        Jedis resource = null;
        Long count = 0L;
        try {
            resource = RedisPool.getResources();
            count = resource.hdel(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
        return count;
    }

    public static void hset(String key, String field, String value) {
        Jedis resource = null;
        try {
            resource = RedisPool.getResources();
            resource.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != resource) {
                resource.close();
            }
        }
    }

}
