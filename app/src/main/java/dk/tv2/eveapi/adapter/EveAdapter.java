package dk.tv2.eveapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;

import dk.tv2.eveapi.R;
import dk.tv2.eveapi.Regne.Soter;
import dk.tv2.eveapi.holders.Evejitatrit;
import dk.tv2.eveapi.holders.Item;

/**
 * Created by cfr on 24-04-2017.
 */

public class EveAdapter extends RecyclerView.Adapter<EveAdapter.holder>  {

    private Evejitatrit tritlist ;
    private LayoutInflater inflater ;
    private Context context;



    public EveAdapter(Context context){

        this.inflater = LayoutInflater.from(context);
        this.context = context;


    }


    public void updateAdapter(Evejitatrit items){

        this.tritlist = items;

//        List<Comparable> compareList = new ArrayList<>();
//        compareList.add(new Item());



//        tritlist.getItems().sort(new Soter());
//        Collections.sort(tritlist.getItems());

        Collections.sort(tritlist.getItems(), new Soter());
        this.tritlist.getItems().get(0).getPrice();

//        String a = "thomas";
//        String b = "thomas";
//
//        int a = 2;
//        int b = 2;
//
//        List<Integer> mylist = new ArrayList<>();
//        mylist.add(b);
//
//
//        if(a==b){
//
//        }
//
//        if(a.equals(b)){
//
//        }
//
//
//        Item itemA = new Item();
//        Item itemB = new Item();
//
//        if(itemA.equals(itemB)) {
//
//        }
        notifyDataSetChanged();


    }

    @Override

    public holder onCreateViewHolder(ViewGroup parent , int viewType){

    View view = inflater.inflate(R.layout.evelist, parent, false);
        return new holder(view);
        }

    @Override
    public void onBindViewHolder(holder holder, final int position){

    Item item = tritlist.getItems().get(position);
    holder.price.setText(String.valueOf(item.getPrice() + " Isk"));
    holder.itemname.setText(item.getType().getName());
    holder.volume.setText( String.valueOf(item.getVolume()));
        holder.total.setText((String.valueOf(item.getTotalPrice() + " Iskgit status")));
     // EveimgType imgname = eveimgitem.getItems().get(position);
        //imgname.g


    Glide.with(context).load(tritlist.getIcon().getHref()).into(holder.imgid);


    }
    @Override
    public int getItemCount(){


    if(tritlist != null && tritlist.getItems() != null){

        return tritlist.getItems().size();

    }

    return 0;
    }




    class holder extends RecyclerView.ViewHolder{


        private TextView itemname;
        private ImageView imgid;
        private TextView price;
        private TextView volume;
        private View container;
        private TextView total;

        public holder(View eve){

            super(eve);





            itemname = (TextView) eve.findViewById(R.id.itemname);
           // itemimg = (ImageView) eve.findViewById(R.id.itemimg);
            price = (TextView) eve.findViewById(R.id.price);
            volume = (TextView) eve.findViewById(R.id.quantity);
            container = eve.findViewById(R.id.tritrow);
            imgid = (ImageView) eve.findViewById(R.id.itemimg);
            total = (TextView ) eve.findViewById(R.id.total1);
        }






    }



}
