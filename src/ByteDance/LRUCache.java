package ByteDance;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-07
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
