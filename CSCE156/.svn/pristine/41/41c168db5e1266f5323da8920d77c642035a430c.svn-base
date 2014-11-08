package unl.cse.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {

	private final LinkedHashMap<K,V> map;
	private final int cacheSize;

	public LRUCache (int cacheSize) {
		this.cacheSize = cacheSize;
		int hashTableCapacity = (int)Math.ceil(cacheSize / 0.75f) + 1;
		map = new LinkedHashMap<K,V>(hashTableCapacity, 0.75f, true) {
			private static final long serialVersionUID = 1;
			@Override protected boolean removeEldestEntry (Map.Entry<K,V> eldest) {
				return size() > LRUCache.this.cacheSize; }
			};
	}

	public V get (K key) {
		return map.get(key); 
	}
	
	public void put (K key, V value) {
		map.put (key, value); 
	}

	public void clear() {
		map.clear(); 
	}

	@Override
	public String toString() {
		return this.map.toString();
	}

} // end class LRUCache