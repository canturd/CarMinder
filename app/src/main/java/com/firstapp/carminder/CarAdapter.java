package com.firstapp.carminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    @NonNull
    List<AutoUser> cars;

    public CarAdapter(@NonNull List<AutoUser> cars) { this.cars = cars; }

    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.carName.setText(cars.get(position).getName());
        holder.carMake.setText(cars.get(position).getMake());
        holder.carModel.setText(cars.get(position).getModel());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView carName;
        public TextView carModel;
        public TextView carMake;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.nameDis);
            carModel = itemView.findViewById(R.id.modelDis);
            carMake = itemView.findViewById(R.id.makeDis);
        }
    }
}
