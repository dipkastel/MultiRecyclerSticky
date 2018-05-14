package bloom.com.stickyrecycler;

import android.content.Context;

import java.util.List;


public class StickyListLayoutManager extends StickyLayoutManager {

    public StickyListLayoutManager(Context context, List<MultiAdapterItem> headerHandler) {
        super(context, headerHandler);
    }

    @Override
    public void scrollToPosition(int position) {
        super.scrollToPositionWithOffset(position, 0);
    }
}
