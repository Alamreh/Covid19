package com.example.covid19;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     RecyclerView listView;
    public static List<Model>  modelList=new ArrayList<>();
     Model model;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listView=findViewById( R.id.listView );
   // listView.setLayoutManager( new LinearLayoutManager(this) );
       listView.setHasFixedSize( true );


       fetchData();

    }




        public  void fetchData(){
        String url = "https://data.covid19india.org/state_district_wise.json";
        StringRequest stringRequest=new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    Iterator<String > iterstates=jsonObject.keys();

                   iterstates.next();
                    while(iterstates.hasNext()){
                        String stateName=iterstates.next();

                        JSONObject districtJson=jsonObject.getJSONObject( stateName ).getJSONObject( "districtData" );
                        Iterator<String> iterdistrict=districtJson.keys();
                        while(iterdistrict.hasNext()){
                            String district=iterdistrict.next();
                            JSONObject distDataJson=districtJson.getJSONObject( district );
                            String active=distDataJson.getString( "active" );
                            String cured=distDataJson.getString( "recovered" );
                            String total=distDataJson.getString( "confirmed" );
                            String death=distDataJson.getString( "deceased" );

                            JSONObject delta=distDataJson.getJSONObject( "delta" );
                            String today_active=delta.getString( "confirmed" );
                            String today_deceased=delta.getString( "deceased" );
                            String today_recovered=delta.getString( "recovered" );
                            modelList.add( new Model( district,total,death,cured,active ,today_active,today_deceased,today_recovered) );
                        }

                        adapter=new Adapter( MainActivity.this,modelList );
                          listView.setAdapter( adapter );
                    }




                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(  MainActivity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );

//
//           // listView.setAdapter( adapter );
      listView.setLayoutManager( new LinearLayoutManager( this ) );
        RequestQueue requestQueue=Volley.newRequestQueue( this );
        requestQueue.add( stringRequest );

    }
}