package entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CakeDB {
    private static Map<String, Cake> cake = new LinkedHashMap<String, Cake>();
    static {//模拟数据库中的记录
        cake.put("1001", new Cake("1001", "A类：巧克力蛋糕"));
        cake.put("1002", new Cake("1002", "B类：水果沙拉蛋糕"));
        cake.put("1003", new Cake("1003", "C类：慕斯蛋糕"));
        cake.put("1004", new Cake("1004", "D类：奶油蛋糕"));
        cake.put("1005", new Cake("1005", "E类：干果蛋糕"));
    }
    // 获得所有的蛋糕
    public static Collection<Cake> getAll() {
        return cake.values();
    }
    // 根据指定的id获蛋糕
    public static Cake getCake(String id) {
        return cake.get(id);
    }
}

