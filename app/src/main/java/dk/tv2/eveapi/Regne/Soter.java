package dk.tv2.eveapi.Regne;

import java.util.Comparator;

import dk.tv2.eveapi.holders.Item;


/**
 * Created by cfr on 26-04-2017.
 */

public class Soter implements Comparator<Item> {




    @Override
    public int compare(Item o1, Item o2) {
       if(o1.getPrice() < o2.getPrice()  ) {

           return -1;
       }
       else if (o1.getPrice() == o2.getPrice()){

           return 0;

       }else{

           return 1;

       }
    }
}
