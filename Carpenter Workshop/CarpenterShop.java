import java.util.HashMap;
import datastructures.Item;
import datastructures.Cabinet;



class CarpenterShop{
    private Cabinet[] cabinets;
    private HashMap<Long,Item> outside;
    static int NUM_CABINETS;
    final static int NEW_ITEM = -1;
    final static int CONTAINED_ITEM = -2;

    public CarpenterShop(String[] cabinetsDescription) throws Exception{
        NUM_CABINETS= cabinetsDescription.length;
        if(NUM_CABINETS<1||NUM_CABINETS>63)
            throw new Exception("Invalid number of cabinets");
        cabinets = new Cabinet[NUM_CABINETS];
        outside=new HashMap<>();
        for(int i=0;i<NUM_CABINETS;i++){
            cabinets[i]=new Cabinet(Integer.parseInt(cabinetsDescription[i]));
        }
    }

    private int findContainingCabinet(long itemKey){
        for(int i=0;i<cabinets.length;i++){
            if(cabinets[i].getStorageMap().containsKey(itemKey))
                return i;
        }
        if(outside.containsKey(itemKey))
            return CONTAINED_ITEM;

        return NEW_ITEM;
    }

    public void addToClosestCabinet(Item item,int cabinetIndex){
        if(cabinetIndex==NUM_CABINETS){
            outside.put(item.getKey(),item);
            cabinets[cabinetIndex-1].getStorageMap().remove(item.getKey());
            return;
        }
        boolean exceededCapacity = cabinets[cabinetIndex].size()+1>cabinets[cabinetIndex].capacity();
        if(!exceededCapacity){
            cabinets[cabinetIndex].addToFront(item);
            return;
        }else{
            Item lastCabinetItem = cabinets[cabinetIndex].removeFromTail();
            cabinets[cabinetIndex].addToFront(item);
            addToClosestCabinet(lastCabinetItem,cabinetIndex+1);
        }
    }

    public String workOnItem(Item item){
        int itemLocation = findContainingCabinet(item.getKey());
        if(itemLocation>=0){
            cabinets[itemLocation].takeArbitraryItem(item.getKey());
            addToClosestCabinet(item,0);
            return String.valueOf(itemLocation+1);
        }
        else if(itemLocation==CONTAINED_ITEM){
            addToClosestCabinet(item,0);
            outside.remove(item.getKey());
            return "OUTSIDE";
        }
        else if(itemLocation==NEW_ITEM){
            addToClosestCabinet(item,0);
            return "NEW";
        }
        return "INPUT_ERROR";
    }
}