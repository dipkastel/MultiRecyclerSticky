package bloom.com.multirecycler.entities;

public class item {
    public boolean isheader;
    public int type;
    public String text;

    public item(boolean isheader,int type, String text) {
        this.isheader = isheader;
        this.type = type;
        this.text = text;
    }


    public boolean isIsheader() {
        return isheader;
    }

    public void setIsheader(boolean isheader) {
        this.isheader = isheader;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
