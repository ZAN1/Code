package dk.tv2.eveapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import dk.tv2.eveapi.adapter.EveAdapter;
import dk.tv2.eveapi.controlers.EveControler;
import dk.tv2.eveapi.holders.Evejitatrit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclermain;
private EveAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclermain = (RecyclerView) findViewById(R.id.reclist);

        recyclermain.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EveAdapter(this);
        //

        recyclermain.setAdapter(adapter);


        EveControler controler = new EveControler();

        controler.getItems("34", new EveControler.EveCallBack() {
            @Override
            public void havedata(Evejitatrit evedata) {
                adapter.updateAdapter(evedata);
            }

            @Override
            public void fejl(String error, Throwable t) {

            }
        });






//erhjglsrhgshgjshgsdgjsdhgfsdhgsdfgh







    }





}
