package com.coderscampus.lesson4;

public class MyPair<K, V> {

	private K key;
	private V value;
	
	public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
	
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "MyPair [key=" + key + ", value=" + value + "]";
    }
}
