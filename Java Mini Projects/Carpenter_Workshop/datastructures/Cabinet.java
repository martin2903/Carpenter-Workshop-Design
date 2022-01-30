package carpenter_workshop.datastructures;
import java.util.HashMap;

public class Cabinet{
    private Item head;
    private Item tail;
    private HashMap<Long, Item> storageMap;
    private int capacity;
    private int size;

    public Cabinet(int cabinetCapacity) throws Exception{
        if(cabinetCapacity<1||cabinetCapacity>1023)
            throw new Exception();
        capacity=cabinetCapacity;
        size=0;
        head = new Item();
        tail =new Item();
        head.setNextItem(tail);
        tail.setPrecedingItem(head);
        storageMap=new HashMap<>();
    }
    public void addToFront(Item newItem){
        if(size+1>capacity)
            return;
        size++;
        newItem.setNextItem(head.getNextItem());
        newItem.setPrecedingItem(head);
        newItem.getNextItem().setPrecedingItem(newItem);
        head.setNextItem(newItem);
        storageMap.put(newItem.getKey(),newItem);
    }


    public Item takeArbitraryItem(long itemKey){
        size--;
        Item itemToRemove = storageMap.remove(itemKey);
        itemToRemove.getPrecedingItem().setNextItem(itemToRemove.getNextItem());
        itemToRemove.getNextItem().setPrecedingItem(itemToRemove.getPrecedingItem());
        return itemToRemove;
    }

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getTail() {
        return tail;
    }

    public void setTail(Item tail) {
        this.tail = tail;
    }

    public HashMap<Long, Item> getStorageMap() {
        return storageMap;
    }

    public void setStorageMap(HashMap<Long, Item> storageMap) {
        this.storageMap = storageMap;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Item removeFromTail(){
        return takeArbitraryItem(tail.getPrecedingItem().getKey());
    }

}
