package bloom.com.multirecycler.List.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import bloom.com.multirecycler.R;


public class headerItemViewHolder extends RecyclerView.ViewHolder {
    public TextView sampleText;
    public View main;

    public headerItemViewHolder(View itemView) {
        super(itemView);
        sampleText = itemView.findViewById(R.id.sample_text);
        main = itemView.findViewById(R.id.main);
    }
}
