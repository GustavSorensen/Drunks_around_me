package dk.au.mad21fall.group6.drunksaroundme.Views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dk.au.mad21fall.group6.drunksaroundme.R;
import dk.au.mad21fall.group6.drunksaroundme.models.Person;


public class PartyRoomAdapter extends RecyclerView.Adapter<PartyRoomAdapter.PartyRoomViewholder> {

    public interface IPersonItemClickedListener{
        void onPersonClicked (int index);
    }

    private IPersonItemClickedListener listener;

    private ArrayList<Person> personList;

    public PartyRoomAdapter(IPersonItemClickedListener listener){
        this.listener = listener;
    }

    public void updatePersonList(ArrayList<Person> lists){
        personList = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PartyRoomAdapter.PartyRoomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_joined_members, parent, false);
        PartyRoomViewholder vh = new PartyRoomViewholder(v, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PartyRoomAdapter.PartyRoomViewholder holder, int position) {
        holder.txtPersonName.setText(personList.get(position).getName());
        //TODO: Sæt billede og promille
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class PartyRoomViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgProfilePicture;
        TextView txtPersonName, txtPerMille;

        IPersonItemClickedListener listener;

        public PartyRoomViewholder (@NonNull View itemView, IPersonItemClickedListener personItemClickedListener){
            super(itemView);

            imgProfilePicture = itemView.findViewById(R.id.imgPerson);
            txtPersonName = itemView.findViewById(R.id.txtName);
            txtPerMille = itemView.findViewById(R.id.txtPerMilleNumber);

            listener = personItemClickedListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onPersonClicked(getAdapterPosition());
        }
    }

}
