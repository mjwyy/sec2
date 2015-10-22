/**
 * ����ļ���
 * @author wqy
 * @date 2015/10/17
 */
package po;

public class DeliveryNoteInputPO {
/**
 * �ͻ�����
 */
private String senderName;

/**
 * �ͻ���ַ
 */
private String senderAddress;

/**
 * �ͻ���λ��ַ
 */
private String senderWorkPlace;

/**
 * �ͻ��绰���ֻ�������
 */
private String senderTeleNumber;

/**
 * �ļ�����
 */
private String number;

/**
 * ����ʵ������
 */
private double weight;

/**
 * �������
 */
private double volume;

/**
 * �����ڼ�Ʒ��
 */
private String name;

/**
 * �������
 */
private String category;

/**
 * ��װ����
 */
private double packPrice;

/**
 * ����������
 */
private String barCode;

public DeliveryNoteInputPO(String senderName, String senderAddress, String senderWorkPlace, String senderTeleNumber,
		String number, double weight, double volume, String name, String category, double packPrice,
		String barCode) {
	super();
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

public String getSenderName() {
	return senderName;
}

public String getSenderAddress() {
	return senderAddress;
}

public String getSenderWorkPlace() {
	return senderWorkPlace;
}

public String getSenderTeleNumber() {
	return senderTeleNumber;
}

public String getNumber() {
	return number;
}

public double getWeight() {
	return weight;
}

public double getVolume() {
	return volume;
}

public String getName() {
	return name;
}

public String getCategory() {
	return category;
}

public double getPackPrice() {
	return packPrice;
}

public String getBarCode() {
	return barCode;
}

}
