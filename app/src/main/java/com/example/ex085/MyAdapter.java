package com.example.ex085;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String[] data;
    Context context;
    RadioButton rB1, rB2;
    TextView tV1, tV2;
    public MyAdapter(Context context,TextView tV1, TextView tV2, String[] data, RadioButton rB1, RadioButton rB2){
        this.data=data;
        this.context=context;
        this.tV1=tV1;
        this.tV2=tV2;
        this.rB1=rB1;
        this.rB2=rB2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.custom_adp, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tV7.setText(data[position]);
        holder.mainLayout.setOnClickListener(view -> {
            int pos=holder.getAdapterPosition();
            tV1.setText(""+(pos+1) );
            double sum=0;
            for (int i=0; i<=pos; i++){
                sum+=Double.parseDouble(data[i]);
            }
            tV2.setText(""+(sum));
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tV7;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            tV7=itemView.findViewById(R.id.tV7);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
