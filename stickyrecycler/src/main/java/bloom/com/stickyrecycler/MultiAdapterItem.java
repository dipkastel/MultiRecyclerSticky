package bloom.com.stickyrecycler;

import android.support.v7.widget.RecyclerView;

import java.util.List;

public interface MultiAdapterItem {
    int getTypeId();

    void setup(RecyclerView.ViewHolder holder);

    Object getItem();

}
