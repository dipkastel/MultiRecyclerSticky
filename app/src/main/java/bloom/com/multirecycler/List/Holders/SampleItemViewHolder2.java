package bloom.com.multirecycler.List.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import bloom.com.multirecycler.R;


public class SampleItemViewHolder2 extends RecyclerView.ViewHolder {
    public TextView sampleText;
    public View main;

    public SampleItemViewHolder2(View itemView) {
        super(itemView);
        sampleText = itemView.findViewById(R.id.sample_text);
        main = itemView.findViewById(R.id.main);
    }
}
