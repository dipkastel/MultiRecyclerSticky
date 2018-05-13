# StickyRecycler


###  recycler
###  Multiple item type
###  sticky Header

installation

------

======

1->create List of MultiItem :

        List<MultiItem> multiItems = new ArrayList<>();

2->add any item used in current recycler :

        MultiItem multiItem = new MultiItem();
        multiItem.setViewType(0);
        multiItem.setHolderPackage("bloom.com.multirecycler.List.Holders.SampleItemViewHolder");
        multiItem.setHolderView(R.layout.item_sample);
        multiItems.add(multiItem);
        
3->fill adapter

                SampleListItem sampleListItem = new SampleListItem();
                sampleListItem.setItem(item);
                sampleListItem.setItemClickListener(this);
                homeItems.add((MultiAdapterItem) sampleListItem);
                
4->set layout manager

        StickyLayoutManager layoutManager = new StickyListLayoutManager(MainActivity.this, homeItems);
        
5->shadow options

        layoutManager.elevateHeaders(<shadow size in dp>);
        -1 ----> no shadow
        
  
6->set adapter

        MultiRecyclerAdapter multiRecyclerAdapter = new MultiRecyclerAdapter(this);
        multiRecyclerAdapter.setItems(homeItems,multiItems);
        recyclerView.setAdapter(multiRecyclerAdapter);
        
        
------

for sticky header item

        implements StickyHeader,MultiAdapterItem 
        
other list items 
        
        implements MultiAdapterItem 

------

