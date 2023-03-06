package mx.edu.itsuruapan.admnistracionderedes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterListar extends RecyclerView.Adapter<ListAdapterListar.ViewHolder> {
    private List<ListElementListar> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterListar(List<ListElementListar> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapterListar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element_listar, null);
        return new ListAdapterListar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterListar.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElementListar> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idL, name, description, cuantity, clas, user;

        ViewHolder(View itemView){
            super(itemView);
            idL = itemView.findViewById(R.id.idInv);
            name = itemView.findViewById(R.id.nombreInv);
            cuantity = itemView.findViewById(R.id.canInv);
        }
        //algo
        void bindData(final ListElementListar item){
            idL.setText(item.getId());
            name.setText(item.getName());
            //description.setText(item.getDescription());
            cuantity.setText(item.getCuantity());
            //clas.setText(item.getClas());
            //user.setText(item.getUser());
        }
    }
}
