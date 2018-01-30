package nyc.c4q.randomuserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.randomuserapp.Model.UserModel;

public class RandomUserAdapter extends RecyclerView.Adapter {

        private List<UserModel> userModels;

        public RandomUserAdapter (List<UserModel> userModels){
                this.userModels = userModels;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder (RecyclerView.ViewHolder holder,int position){
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.bind(userModels.get(position));

        }

        @Override
        public int getItemCount () {
            return userModels.size();
        }
}
