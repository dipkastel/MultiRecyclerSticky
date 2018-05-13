package bloom.com.stickyrecycler;

import android.content.Context;

import java.util.List;

import bloom.com.stickyrecycler.MultiAdapterItem;

public final class TopSnappedStickyLayoutManager extends StickyLayoutManager {

    public TopSnappedStickyLayoutManager(Context context, List<MultiAdapterItem> headerHandler) {
        super(context, headerHandler);
    }

    @Override
    public void scrollToPosition(int position) {
        super.scrollToPositionWithOffset(position, 0);
    }
}
