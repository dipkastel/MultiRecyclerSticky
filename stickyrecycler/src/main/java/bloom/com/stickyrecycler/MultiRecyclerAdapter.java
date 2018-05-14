package bloom.com.stickyrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


public class MultiRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MultiAdapterItem {

    List<MultiAdapterItem> homeItems = new ArrayList<>();
    Context context;
    List<MultiItem> stikyItems;
    LayoutInflater layoutInflater;

    public MultiRecyclerAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setItems(List<MultiAdapterItem> homeItems,List<MultiItem> stikyItems) {
        this.homeItems = homeItems;
        this.stikyItems = stikyItems;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        for (MultiItem item : stikyItems){
            if(viewType==item.getViewType()){
                try {
                    view = layoutInflater.inflate(item.getHolderView(), parent, false);
                }catch (Exception e){
                    Log.e("MultiRecyclerAdapter : ","can not inflate view");
                }
                try {
                    Class cl = null;
                    cl = Class.forName(item.getHolderPackage());
                    Constructor con = cl.getConstructor(View.class);
                    Object Holder = con.newInstance(view);
                    return (RecyclerView.ViewHolder) Holder;
                } catch (Exception e) {
                    Log.e("MultiRecyclerAdapter : ","can not get class and create holder");
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            MultiAdapterItem homeItem = homeItems.get(position);
            homeItem.setup(holder);
        } catch (Exception e) {
            Log.e("MultiRecyclerAdapter : ","can not bind view");
        }
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return homeItems.get(position).getTypeId();
    }

    public void delete(MultiAdapterItem item) {
        int removeItemIndex = homeItems.indexOf(item);
        homeItems.remove(removeItemIndex);
        notifyItemRemoved(removeItemIndex);

    }


    @Override
    public int getTypeId() {
        return 0;
    }

    @Override
    public void setup(RecyclerView.ViewHolder holder) {

    }


    @Override
    public Object getItem() {
        return null;
    }

}
