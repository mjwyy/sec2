/**
 * 输入寄件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import util.enums.DeliverCategory;

import java.io.Serializable;

public class DeliveryNotePO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 3326557217189374031L;

	/**
	 * 客户(寄件人)姓名
	 */
	private String senderName;

	/**
	 * 客户(寄件人)地址
	 */
	private String senderAddress;

	/**
	 * 客户(寄件人)电话（手机）号码
	 */
	private String senderTeleNumber;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人地址
     */
    private String receiverAddress;

    /**
     * 收件人电话（手机）号码
     */
    private String receiverTeleNumber;

    /**
     * 货物内件品名
     */
    private String name;

	/**
	 * 寄件件数
	 */
	private int goodsNumber;

	/**
	 * 货物实际重量
	 */
	private double weight;

	/**
	 * 货物体积
	 */
	private double volume;

	/**
	 * 快递种类
	 */
	private DeliverCategory category;

	/**
	 * 包装费用
	 */
	private double packPrice;

	/**
	 * 货物条形码
	 */
	private String barCode;

    public DeliveryNotePO(String senderName, String senderAddress, String senderTeleNumber, String receiverName,
                          String receiverAddress, String receiverTeleNumber, String name, int goodsNumber,
                          double weight, double volume, DeliverCategory category, double packPrice, String barCode) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderTeleNumber = senderTeleNumber;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverTeleNumber = receiverTeleNumber;
        this.name = name;
        this.goodsNumber = goodsNumber;
        this.weight = weight;
        this.volume = volume;
        this.category = category;
        this.packPrice = packPrice;
        this.barCode = barCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderTeleNumber() {
        return senderTeleNumber;
    }

    public void setSenderTeleNumber(String senderTeleNumber) {
        this.senderTeleNumber = senderTeleNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverTeleNumber() {
        return receiverTeleNumber;
    }

    public void setReceiverTeleNumber(String receiverTeleNumber) {
        this.receiverTeleNumber = receiverTeleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public DeliverCategory getCategory() {
        return category;
    }

    public void setCategory(DeliverCategory category) {
        this.category = category;
    }

    public double getPackPrice() {
        return packPrice;
    }

    public void setPackPrice(double packPrice) {
        this.packPrice = packPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}