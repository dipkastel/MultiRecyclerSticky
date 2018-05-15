package bloom.com.stickyrecycler;

public class MultiItem {
    int ViewType;
    int HolderView;
    String HolderPackage;

    public MultiItem(int viewType, int holderView, String holderPackage) {
        ViewType = viewType;
        HolderView = holderView;
        HolderPackage = holderPackage;
    }

    public int getHolderView() {
        return HolderView;
    }

    public void setHolderView(int holderView) {
        HolderView = holderView;
    }

    public int getViewType() {
        return ViewType;
    }

    public String getHolderPackage() {
        return HolderPackage;
    }

    public void setHolderPackage(String holderName) {
        HolderPackage = holderName;
    }

    public void setViewType(int viewType) {
        ViewType = viewType;
    }
}
