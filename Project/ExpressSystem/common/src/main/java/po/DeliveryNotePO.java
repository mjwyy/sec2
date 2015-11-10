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
	 * 客户姓名
	 */
	private String senderName;

	/**
	 * 客户地址
	 */
	private String senderAddress;

	/**
	 * 客户单位地址
	 */
	private String senderWorkPlace;

	/**
	 * 客户电话（手机）号码
	 */
	private String senderTeleNumber;

	/**
	 * 寄件件数
	 */
	private String number;

	/**
	 * 货物实际重量
	 */
	private double weight;

	/**
	 * 货物体积
	 */
	private double volume;

	/**
	 * 货物内件品名
	 */
	private String name;

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

    public DeliveryNotePO(String senderName, String senderAddress, String senderWorkPlace,
                          String senderTeleNumber, String number, double weight, double volume,
                          String name, DeliverCategory category, double packPrice, String barCode) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderWorkPlace = senderWorkPlace;
        this.senderTeleNumber = senderTeleNumber;
        this.number = number;
        this.weight = weight;
        this.volume = volume;
        this.name = name;
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

    public String getSenderWorkPlace() {
        return senderWorkPlace;
    }

    public void setSenderWorkPlace(String senderWorkPlace) {
        this.senderWorkPlace = senderWorkPlace;
    }

    public String getSenderTeleNumber() {
        return senderTeleNumber;
    }

    public void setSenderTeleNumber(String senderTeleNumber) {
        this.senderTeleNumber = senderTeleNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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