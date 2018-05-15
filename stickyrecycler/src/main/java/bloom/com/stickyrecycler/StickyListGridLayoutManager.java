package bloom.com.stickyrecycler;

import android.content.Context;
import android.util.AttributeSet;

import java.util.List;


public class StickyListGridLayoutManager extends StickyGridLayoutManager {


    public StickyListGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public StickyListGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public StickyListGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }
}
