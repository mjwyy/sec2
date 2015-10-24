package vo;

/**
 * 期初建账使用的仓库信息VO
 * 
 * @author kylin
 *
 */
public class CommodityInfoVO {

	/**
	 * 仓库名称
	 */
	private String name;
	
	/**
	 * 仓库最大库存量
	 */
	private int maxSize;
	
	/**
	 * 仓库当前库存量
	 */
	private int currentSize;
	
	public CommodityInfoVO(String name, int maxSize, int currentSize) {
		super();
		this.name = name;
		this.maxSize = maxSize;
		this.currentSize = currentSize;
	}

	public String getName() {
		return name;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public int getCurrentSize() {
		return currentSize;
	}
}
