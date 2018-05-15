package bloom.com.stickyrecycler;

import android.content.Context;

import java.util.List;


public class StickyListLinearLayoutManager extends StickyLinearLayoutManager {

    public StickyListLinearLayoutManager(Context context, List<MultiAdapterItem> headerHandler) {
        super(context, headerHandler);
    }
    public StickyListLinearLayoutManager(Context context, int orientation, List<MultiAdapterItem> headerHandler) {
        super(context, orientation,false,headerHandler);
    }

    @Override
    public void scrollToPosition(int position) {
        super.scrollToPositionWithOffset(position, 0);
    }
}
