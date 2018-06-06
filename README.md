# StickyRecycler


![Image of StickyRecycler](https://github.com/dipkastel/StickyRecycler/blob/master/ScreenShots/20180513_120456.gif?raw=true)

###  recycler
###  Multiple item type
###  sticky Header

Gradle installation :



Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.dipkastel:StickyRecycler:1.0.9'
    		implementation "com.android.support:recyclerview-v7:27.1.1"
	}
        
------


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

