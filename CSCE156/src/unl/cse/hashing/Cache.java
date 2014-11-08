package unl.cse.hashing;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {

	private final Map<K, V> map;
	
	public Cache() {
		//this.map = Collections.synchronizedMap(new HashMap<K, V>());
		this.map = new HashMap<K,V>();
	}
	
	public void put(K key, V value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException("Neither key nor value are allowed to be null");
		}
		this.map.put(key, value);
	}
	
	public boolean containsKey(K key) {
		return this.map.containsKey(key);
	}
	
	public boolean containsValue(V value) {
		return this.map.containsValue(value);
	}
	
	public int size() {
		return this.map.size();
	}
	
	public V get(K key) {
		return this.map.get(key);
	}
}
