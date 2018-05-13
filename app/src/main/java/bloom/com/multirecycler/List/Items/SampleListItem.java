package bloom.com.multirecycler.List.Items;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import bloom.com.multirecycler.List.Holders.SampleItemViewHolder;
import bloom.com.multirecycler.entities.item;
import bloom.com.stickyrecycler.MultiAdapterItem;

public class SampleListItem implements MultiAdapterItem {
    bloom.com.multirecycler.entities.item item;
    SampleItemViewHolder itemHolder;


    public void setItem(item item) {
        this.item = item;
    }

    @Override
    public int getTypeId() {
        return 0;
    }

    @Override
    public void setup(RecyclerView.ViewHolder holder) {
        itemHolder = (SampleItemViewHolder) holder;
        if (itemHolder != null) {
            itemHolder.sampleText.setText(item.getText());

//            itemHolder.TVIcon.setText(item.getIcontxt());
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemClickListener!=null){
                        itemClickListener.onSearchItemClick(item);
                    }
                }
            });
        }
    }

    @Override
    public Object getItem() {
        return item;
    }


    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onSearchItemClick(item homeItem);
    }
}
