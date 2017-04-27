package dk.tv2.eveapi.holders;

/**
 * Created by cfr on 24-04-2017.
 */

public class Item /*implements Comparable<Item>*/ {

    private double price;
    private int volume;
    private Type type;

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        return super.equals(obj);
//    }

    public Type getType() {
        return type;
    }


  /*  @Override
    public int compareTo(@NonNull Item o) {
        if(price < o.getPrice()) {
            return -1;
        } else if(price == o.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }*/
   public double getTotalPrice ()
   {
      double total = price * volume;

       return total;
   }
}
