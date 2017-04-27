package dk.tv2.eveapi.Evegetonline;

import dk.tv2.eveapi.holders.Eveimg;
import dk.tv2.eveapi.holders.Evejitatrit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cfr on 24-04-2017.
 */

public interface EveGetSell {
    //https://crest-tq.eveonline.com/inventory/types/35/

 // String idchange= "https://crest-tq.eveonline.com/inventory/types/35/";



    @GET("/market/10000002/orders/sell/")
    Call<Evejitatrit> sell_List(@Query("type") String type );

@GET ("/market/types/")
    Call <Eveimg> find_img();

}
