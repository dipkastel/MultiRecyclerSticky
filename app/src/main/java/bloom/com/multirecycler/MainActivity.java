package bloom.com.multirecycler;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bloom.com.multirecycler.List.Items.SampleListItem;
import bloom.com.multirecycler.List.Items.SampleListItem2;
import bloom.com.multirecycler.List.Items.HeaderItem;
import bloom.com.multirecycler.entities.item;
import bloom.com.stickyrecycler.MultiAdapterItem;
import bloom.com.stickyrecycler.MultiItem;
import bloom.com.stickyrecycler.MultiRecyclerAdapter;
import bloom.com.stickyrecycler.StickyHeaderListener;
import bloom.com.stickyrecycler.StickyLinearLayoutManager;
import bloom.com.stickyrecycler.StickyListLinearLayoutManager;

public class MainActivity extends AppCompatActivity implements SampleListItem.ItemClickListener ,SampleListItem2.ItemClickListener ,HeaderItem.ItemClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        // create List of items
        String[] List = {"Apple","Apricot","Banana","Bilberry","Blackberry","Blackcurrant","Blueberry","Coconut","Currant","Cherry","Cherimoya","Clementine","Cloudberry ","Date","Damson","Durian","Elderberry","Fig","Feijoa","Gooseberry","Grape","Grapefruit","Huckleberry","Jackfruit","Jambul","Jujube","Kiwifruit","Kumquat","Lemon","Lime","Loquat","Lychee","Mango","Melon","Cantaloupe","Honeydew","Watermelon","Rock melon","Nectarine","Orange","Passionfruit","Peach","Pear","Plum","Plumcot","Prune","Pineapple","Pomegranate","Pomelo","Purple mangosteen","Raisin","Raspberry","Rambutan","Redcurrant","Satsuma","Strawberry","Tangerine","Tomato","Ugli Fruit"};
        List<item> items = new ArrayList<>();
        for(int i=0;i< List.length;i++){
            if(i%7==0){
                //set header
                item item = new item(true,2,List[i]);
                items.add(item);
            }
            item item = new item(false,i%2,List[i]);
            items.add(item);

        }


        List<MultiItem> multiItems = new ArrayList<>();
        MultiItem multiItem = new MultiItem(0,R.layout.item_sample,"bloom.com.multirecycler.List.Holders.SampleItemViewHolder");
        multiItems.add(multiItem);

        MultiItem multiItem2 = new MultiItem(1,R.layout.item_sample2,"bloom.com.multirecycler.List.Holders.SampleItemViewHolder2");
        multiItems.add(multiItem2);

        MultiItem multiItem3 = new MultiItem(2,R.layout.item_header,"bloom.com.multirecycler.List.Holders.headerItemViewHolder");
        multiItems.add(multiItem3);



        //fill Adapter
        List<MultiAdapterItem> homeItems = new ArrayList<>();
        for (item item : items) {
            if(item.type==0){
                SampleListItem sampleListItem = new SampleListItem();
                sampleListItem.setItem(item);
                sampleListItem.setItemClickListener(this);
                homeItems.add((MultiAdapterItem) sampleListItem);
            }
            else if(item.type ==1){
                SampleListItem2 sampleListItem2 = new SampleListItem2();
                sampleListItem2.setItem(item);
                sampleListItem2.setItemClickListener(this);
                homeItems.add((MultiAdapterItem) sampleListItem2);
            }else if(item.type == 2){

                HeaderItem headerItem = new HeaderItem();
                headerItem.setItem(item);
                headerItem.setItemClickListener(this);
                homeItems.add(headerItem);
            }
        }



        StickyLinearLayoutManager layoutManager = new StickyListLinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, homeItems);
        //    layoutManager.elevateHeaders(true); // Default elevation of 5dp
        // You can also specify a specific dp for elevation
        layoutManager.elevateHeaders(-1);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setStickyHeaderListener(new StickyHeaderListener() {
            @Override
            public void headerAttached(View headerView, int adapterPosition) {
            }

            @Override
            public void headerDetached(View headerView, int adapterPosition) {
            }
        });







        //Set Adapter
        MultiRecyclerAdapter multiRecyclerAdapter = new MultiRecyclerAdapter(this);
        multiRecyclerAdapter.setItems(homeItems,multiItems);
        recyclerView.setAdapter(multiRecyclerAdapter);

    }

    @Override
    public void onSearchItemClick(item homeItem) {

        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.main),
                homeItem.getText(), Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
