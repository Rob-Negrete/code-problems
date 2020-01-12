import java.util.LinkedList;
import java.util.Iterator;

public class HashTableCustom <V>{

    private static final int MAX_ITEMS = 50;  
    private int size = 0;  

    LinkedList<Entry<V>>[] entries;

    @SuppressWarnings("unchecked")
    public HashTableCustom(){
        entries = new LinkedList[MAX_ITEMS];
    }

    long hash(V key){
        long _hash = key.hashCode();
        //System.out.println("hashCode: " + _hash);
        return _hash;
    }

    int calcIndex(V key){                
        long idx = hash(key) % MAX_ITEMS;
        if(idx < 0) idx *= -1;
        System.out.println("Calculated Index: " + idx + " for key: " + key);
        return (int) idx;
    }

    
    
    public void put(V value){
        int idx = calcIndex(value);
        addToList(entries[idx], new Entry<V>(value), idx);
        size++;
    }

    public V get(V value){
        int idx = calcIndex(value);
        EntryIterator<V> it = new EntryIterator<V>(entries[idx]);
        Entry<V> entry = null;
        while(it.hasNext()){            
            Entry<V> item = it.next();
            //System.out.println(item);
            if(item.value.equals(value)){
                entry = item;
                break;
            } 
        }
        if(entry == null) return null;
        return entry.value;        
    }
    

    public int size(){
        return size;
    }

    private void addToList(LinkedList<Entry<V>> list, Entry<V> entry, int idx){
        if(list == null){ 
            //System.out.println("Creating newlist for entries["+ idx +"]"); 
            list = new LinkedList<Entry<V>>(); 
        }
        list.add(entry);
        entries[idx] = list;
    }

}

class HashMapIterator <V> implements Iterator<LinkedList<Entry<V>>> {

    LinkedList <Entry<V>> list[];
    private int counter = 0;

    public HashMapIterator(LinkedList<Entry<V>> list[]){
        this.list = list;
    }

    public boolean hasNext(){
        if(list == null || list.length == 0) return false;
        return counter < list.length;
    }

    public LinkedList<Entry<V>> next(){
        if(list[counter] == null ) return null;        
        return list[counter++];
    }

}


class EntryIterator<V> implements Iterator<Entry<V>> {
    LinkedList<Entry<V>> list;
    private int counter = 0;
    
    public EntryIterator(LinkedList<Entry<V>> list){
        this.list = list;
    }

    public boolean hasNext(){
        //System.out.println("Counter: " + counter + " list.size(): " + list.size());
        if(list == null || list.isEmpty()) return false;
        return counter < list.size();
    }

    public Entry<V> next(){
        //if(list.get(counter) == null) return null;
        Entry<V> entry = list.get(counter);
        counter++;
        return entry;
    }    
}

class Entry <V> {

    V value;

    Entry (V value){        
        this.value = value;
    }

    public String toString(){
        String str = "'value' : '%s'";
        return String.format(str, value);
    }
}