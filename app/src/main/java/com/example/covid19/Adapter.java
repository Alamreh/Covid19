package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
   private Context context;
    private List<Model> userlist;
    Adapter(Context context,List<Model> userlist){

        this.context=context;
        this.userlist=userlist;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=LayoutInflater.from( parent.getContext() ).inflate( R.layout.testing ,parent,false);

        return  new viewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
         Model data=userlist.get( position );
         holder.cityname.setText( data.getCityname() );
         holder.to_cured.setText( data.getInRec() );
         holder.total.setText( data.getTotal() );
         holder.active.setText( data.getActive() );
         holder.to_active.setText( data.getInActive() );
         holder.deaths.setText( data.getDeath() );
         holder.cured.setText( data.getCured() );
         holder.to_deaths.setText( data.getInDEc() );
    }


    @Override
    public int getItemCount() {
        return  userlist.size();
    }


    public static  class viewHolder extends RecyclerView.ViewHolder{
        private TextView cityname,active,confirm,to_active,cured,to_cured,deaths,to_deaths,total;

        public viewHolder(@NonNull View itemView) {
            super( itemView );
            cityname=itemView.findViewById( R.id.state );
             active=itemView.findViewById( R.id.active );
            // confirm=itemView.findViewById( R.id. );
             to_active=itemView.findViewById( R.id.incactive );
             cured=itemView.findViewById( R.id.cured );
             to_cured=itemView.findViewById( R.id.inccured );
             deaths=itemView.findViewById( R.id.death );
             to_deaths=itemView.findViewById( R.id.incdeath );
            total=itemView.findViewById( R.id.total );
        }


    }
}
