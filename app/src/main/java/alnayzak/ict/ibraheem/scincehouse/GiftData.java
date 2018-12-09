package alnayzak.ict.ibraheem.scincehouse;

public class GiftData {

    private String giftName;
    private String giftDescription;
    private int giftImage;
    private String giftmain;

    public GiftData(int ImageSRC, String Title, String Discription, String MainPoints) {
        this.giftName = Title;
        this.giftDescription = Discription;
        this.giftImage = ImageSRC;
        this.giftmain = MainPoints;
    }

    public String getGiftName() {
        return giftName;
    }

    public String getGiftMain() {
        return giftmain;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public int getGiftImage() {
        return giftImage;
    }
}