package bloom.com.multirecycler.List.Items;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bloom.com.multirecycler.List.Holders.SampleItemViewHolder2;
import bloom.com.multirecycler.List.Holders.headerItemViewHolder;
import bloom.com.multirecycler.entities.item;
import bloom.com.stickyrecycler.MultiAdapterItem;
import bloom.com.stickyrecycler.StickyHeader;

public class HeaderItem implements StickyHeader,MultiAdapterItem {
    bloom.com.multirecycler.entities.item item;
    headerItemViewHolder itemHolder;


    public void setItem(bloom.com.multirecycler.entities.item item) {
        this.item = item;
    }

    @Override
    public int getTypeId() {
        return 2;
    }

    @Override
    public void setup(RecyclerView.ViewHolder holder) {
        itemHolder = (headerItemViewHolder) holder;
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
