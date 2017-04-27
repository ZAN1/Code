package dk.tv2.eveapi.controlers;

import android.util.Log;

import dk.tv2.eveapi.Evegetonline.EveGetSell;
import dk.tv2.eveapi.holders.Eveimg;
import dk.tv2.eveapi.holders.Eveimgitem;
import dk.tv2.eveapi.holders.Evejitatrit;
import dk.tv2.eveapi.holders.Icon;
import dk.tv2.eveapi.holders.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cfr on 24-04-2017.
 */

public class EveControler {

    EveGetSell mservice;
        Icon micon;



public interface EveCallBack {

    void havedata(Evejitatrit evedata);
    void fejl (String error , Throwable t);

}
public interface EveimgCallBack{

    void haveimg(Icon eveimgdata);
    void noimg (String noimg, Throwable t);
}

    public EveControler(){



        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://crest-tq.eveonline.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         mservice = retro.create(EveGetSell.class);



    }

    public void getItems(final String id , final EveCallBack getitemsCallback) {

        udskriv(id, new EveControler.EveCallBack() {


            @Override
            public void havedata(final Evejitatrit evedata) {

                udskrivimg(id, new EveControler.EveimgCallBack() {

                    @Override
                    public void haveimg(Icon eveimgdata) {
                       evedata.setIcon(eveimgdata);
                    getitemsCallback.havedata(evedata);
                    }

                    @Override
                    public void noimg(String noimg, Throwable t) {
                        Log.e("blabla",noimg,t);
                        getitemsCallback.fejl("no image", t);
                    }
                });
               // adapter.updateAdapter(evedata);
            }

            @Override
            public void fejl(String error, Throwable t) {
                Log.e("LOG", error, t);

            }
        } );
    }





    private void udskrivimg (final String imgid , final EveimgCallBack imgcallback){
        Call<Eveimg> imgtype = mservice.find_img();
        imgtype.enqueue(new Callback<Eveimg>() {
            @Override
            public void onResponse(Call<Eveimg> call, Response<Eveimg> response) {

                Eveimg eveimg = response.body();


                for(Eveimgitem eve1 : eveimg.getItems())
                {

                    if(eve1.getType().getId_str().equals(imgid) ) {
                        imgcallback.haveimg(eve1.getType().getIcon());

                        Log.d("LOG", "img address: " + eve1.getType().getIcon().getHref());
                    }
                }
            }

            @Override
            public void onFailure(Call<Eveimg> call, Throwable t) {
                Log.d("blabla" , "didnt go as planned  " , t);
                imgcallback.noimg("der er en fejl" , t);
            }
        });

    }

    private void udskriv (String  id , final EveCallBack eveCallBack){

      /*udskrivimg(id, new EveControler.EveimgCallBack() {
            @Override
            public void haveimg(Icon eveimgdata) {
               micon = eveimgdata;

            }

            @Override
            public void noimg(String noimg, Throwable t) {
                Log.e("blabla",noimg,t);

            }
        });*/
        Call<Evejitatrit> selltrit = mservice.sell_List("https://crest-tq.eveonline.com/inventory/types/"+ id +"/");

        selltrit.enqueue(new Callback<Evejitatrit>() {


            @Override
            public void onResponse(Call<Evejitatrit> call, Response<Evejitatrit> response) {


                Evejitatrit tritlist = response.body();

                eveCallBack.havedata(tritlist);

                for (Item eve : tritlist.getItems()) {

                  if(eve.getType().getName() != null ) {
                      Log.i("#hg", "##########");
                      Log.d("blabla", "bla :  " + eve.getType().getName());


                      Log.d("blabla", "bla :  " + eve.getVolume());
                      Log.d("blabla", "bla :  " + eve.getPrice());
                  }
                }



            }


            @Override
            public void onFailure(Call<Evejitatrit> call, Throwable t) {

                Log.d("blabla" , "didnt go as planned  " , t);
                eveCallBack.fejl("der er en fejl" , t);
            }
        });



    }







}
