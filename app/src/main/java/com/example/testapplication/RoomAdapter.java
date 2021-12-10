package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> implements Filterable
{
    private Context context;
    private ArrayList<Room> roomList;
    private ArrayList<Room> filteredRooms;
    private Filter filter;

    //Setters
    public void setDonorList(ArrayList<Room> roomList)
    {
        this.roomList = roomList;
        this.filteredRooms = this.roomList;
    }


    //Constructor
    public RoomAdapter(Context context, ArrayList<Room> roomsList)
    {
        this.context = context;
        this.roomList = roomsList;
        filteredRooms = roomsList;
        filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence)
        {
            FilterResults results = new FilterResults();
            if(charSequence == null || charSequence.length() == 0)
            {
                results.values = roomList;
                results.count = roomList.size();
                return results;
            }

            ArrayList<Room> filteredResults  = new ArrayList<Room>();
            for(int i = 0; i < roomList.size(); i++)
            {
                if(roomList.get(i).getName().toLowerCase().contains(charSequence.toString().toLowerCase()))
                    filteredResults.add(roomList.get(i));
            }

            results.values = filteredResults;
            results.count = filteredResults.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults)
        {
            filteredRooms = (ArrayList<Room>) filterResults.values;
            notifyDataSetChanged();
        }
    };
    }

    //For recycler view implementation
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room,
                parent, false);
        return new RoomAdapter.ViewHolder(view);
    }

    //For recycler view implementation
    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, int position)
    {
        Room r = filteredRooms.get(position);

        holder.roomName.setText(r.getName());
        holder.lastMessage.setText(r.getLastMessage().getText());
        holder.time.setText(r.getLastMessage().getTimestamp().getHours() + "");
    }

    @Override
    public int getItemCount() {
        return filteredRooms.size();
    }

    //For Filterable implementation
    @Override
    public Filter getFilter()
    {
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView roomName;
        public TextView lastMessage;
        public TextView time;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            roomName = itemView.findViewById(R.id.room_name);
            lastMessage = itemView.findViewById(R.id.last_msg);
            time = itemView.findViewById(R.id.time);
        }
    }
}
