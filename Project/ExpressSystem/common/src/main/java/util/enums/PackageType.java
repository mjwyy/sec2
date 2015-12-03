package util.enums;

/**
 * Created by kylin on 15/12/3.
 */
public enum PackageType {

    /**
     * 纸箱价格
     */
    PaperBox("PaperBox"),
    /**
     * 木箱价格
     */
    WoodenBox("WoodenBox"),
    /**
     * 快递袋价格
     */
    Bag("Bag");

    private String type;

    PackageType(String s) {
        type = s;
    }

    @Override
    public String toString() {
        return this.type;
    }

    public static PackageType getPackageType(String type) {
        for(PackageType packageType : values()){
            if(packageType.toString().equals(type) )
                return packageType;
        }
        return null;
    }
}
