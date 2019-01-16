package alnayzak.ict.ibraheem.scincehouse;

public class GiftData {

    private String giftName;
    private String giftDescription;
    private int giftImage;
    private String giftMain;

    public GiftData(int ImageSRC, String Title, String Description, String MainPoints) {
        this.giftName = Title;
        this.giftDescription = Description;
        this.giftImage = ImageSRC;
        this.giftMain = MainPoints;
    }

    public String getGiftName() {
        return giftName;
    }

    public String getGiftMain() {
        return giftMain;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public int getGiftImage() {
        return giftImage;
    }
}