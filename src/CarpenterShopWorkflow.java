import datastructures.Item;
import java.util.Scanner;

public class CarpenterShopWorkflow {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            String[] scanned = sc.nextLine().split(" ");
            CarpenterShop shop = new CarpenterShop(scanned);

            int len = Integer.parseInt(sc.nextLine());
            if(len<1 || len>(long)Math.pow(2,32)-1)
                throw new Exception();
            for (int i = 0; i < len - 1; i++) {
                shop.workOnItem(new Item(Long.parseLong(sc.nextLine())));
            }
            String s = sc.nextLine();
            System.out.println(s);
            System.out.println(shop.workOnItem(new Item(Long.parseLong(s))));
        } catch(Exception e){
            System.out.println("INPUT_ERROR");
        }
    }

}
