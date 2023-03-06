package mx.edu.itsuruapan.admnistracionderedes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterListarPlanes extends RecyclerView.Adapter<ListAdapterListarPlanes.ViewHolder> {
    private List<ListElementListar> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterListarPlanes(List<ListElementListar> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapterListarPlanes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_plan_listar, null);
        return new ListAdapterListarPlanes.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterListarPlanes.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElementListar> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idL, name, description, cuantity, clas, user;

        ViewHolder(View itemView){
            super(itemView);
            //idL = itemView.findViewById(R.id.idInv);
            name = itemView.findViewById(R.id.nombrePlanL);
            description = itemView.findViewById(R.id.descripcionPlanL);
        }
        //algo
        void bindData(final ListElementListar item){
            //idL.setText(item.getId());
            name.setText(item.getName());
            description.setText(item.getDescription());
            //cuantity.setText(item.getCuantity());
            //clas.setText(item.getClas());
            //user.setText(item.getUser());
        }
    }
}
