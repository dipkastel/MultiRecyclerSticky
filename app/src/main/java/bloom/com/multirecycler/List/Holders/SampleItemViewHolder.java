package bloom.com.multirecycler.List.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bloom.com.multirecycler.R;


public class SampleItemViewHolder extends RecyclerView.ViewHolder {
    public TextView sampleText;

    public SampleItemViewHolder(View itemView) {
        super(itemView);
        sampleText = itemView.findViewById(R.id.sample_text);
    }
}
