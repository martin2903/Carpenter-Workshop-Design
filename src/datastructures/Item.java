package datastructures;

public class Item {
    private long key;
    private Item precedingItem;
    private Item nextItem;

    public Item(long key) throws Exception{
        if(key<1 || key> (long)Math.pow(2,32)-1)
            throw new Exception("Item key value is invalid");
        this.key=key;
    }
    Item(){ }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public Item getPrecedingItem() {
        return precedingItem;
    }

    public void setPrecedingItem(Item precedingItem) {
        this.precedingItem = precedingItem;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }
}
