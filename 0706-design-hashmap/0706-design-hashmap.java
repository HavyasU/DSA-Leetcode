class MyHashMap extends HashMap<Integer,Integer>{

    public MyHashMap() {
        super();
    }
    public int get(int val){
        if(super.get(val)!=null){
            return super.get(val);
        }
        return -1;
    }
   
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */