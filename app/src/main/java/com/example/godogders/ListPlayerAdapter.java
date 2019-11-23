package com.example.godogders;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListPlayerAdapter extends  RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder> {
    private ArrayList<Player> listPlayer;

    public ListPlayerAdapter(ArrayList<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_player,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Player player = listPlayer.get(position);
        Glide.with(holder.itemView.getContext())
                .load(player.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.name.setText(player.getName());
        holder.noPlayer.setText("#" + player.getNoJersey());
        holder.playerPos.setText(player.getPosition());
        holder.batThrow.setText(player.getBat() + "/" + player.getThrowing());
        holder.heightPlayer.setText(player.getHeight());
        holder.weightPlayer.setText(player.getWeight() + " lbs");

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = listPlayer.get(position);
                Intent intent = new Intent(v.getContext(),DetailActivity.class);

                intent.putExtra("playerImg",player.getPhoto());
                intent.putExtra("playerName",player.getName());
                intent.putExtra("playerNickname",player.getNickname());
                intent.putExtra("playerNo",player.getNoJersey());
                intent.putExtra("playerPos",player.getPosition());
                intent.putExtra("playerAge",player.getAge());
                intent.putExtra("playerWeight",player.getWeight());
                intent.putExtra("playerHeight",player.getHeight());
                intent.putExtra("playerBat",player.getBat());
                intent.putExtra("playerThrow",player.getThrowing());

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        Button btnDetail;
        TextView name,noPlayer,playerPos,batThrow,heightPlayer,weightPlayer;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.player_img);
            name = itemView.findViewById(R.id.player_name);
            noPlayer = itemView.findViewById(R.id.player_no);
            playerPos = itemView.findViewById(R.id.player_pos);
            batThrow = itemView.findViewById(R.id.player_batThrow);
            heightPlayer = itemView.findViewById(R.id.player_height);
            weightPlayer = itemView.findViewById(R.id.player_weight);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }

    }
}
