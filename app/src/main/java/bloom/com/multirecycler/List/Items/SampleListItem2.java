package bloom.com.multirecycler.List.Items;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bloom.com.multirecycler.List.Holders.SampleItemViewHolder2;
import bloom.com.multirecycler.entities.item;
import bloom.com.stickyrecycler.MultiAdapterItem;

public class SampleListItem2 implements MultiAdapterItem {
    item item;
    SampleItemViewHolder2 itemHolder;


    public void setItem(item item) {
        this.item = item;
    }

    @Override
    public int getTypeId() {
        return 1;
    }

    @Override
    public void setup(RecyclerView.ViewHolder holder) {
        itemHolder = (SampleItemViewHolder2) holder;
        if (itemHolder != null) {
            itemHolder.sampleText.setText(item.getText());
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
