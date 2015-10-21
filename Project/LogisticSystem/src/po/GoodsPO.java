package po;

public class GoodsPO {
	
		
		/**
		 * ������
		 */
		private String barcode;
		
		/**
		 * ����
		 */
		private String areacode;
		
		/**
		 * Ŀ�ĵ�
		 */
		private String destination;
		
		/**
		 * �ź�
		 */
		private int rownumber;
		
		/**
		 * �ܺ�
		 */
		private int framenumber;
		/**
		 * λ��
		 */
		private int placenumber;
		
		/**
		 * ���캯��
		 * @param barcode
		 * @param areacode
		 * @param destination
		 * @param rownumber
		 * @param framenumber
		 * @param placenumber
		 */
		public GoodsPO(String barcode,String areacode,String destination,int rownumber,int framenumber,int placenumber){
			this.barcode = barcode;
			this.destination = destination;
			this.areacode = areacode;
			this.rownumber = rownumber;
			this.framenumber = framenumber;
			this.placenumber= placenumber;
		}

		public String getBarcode() {
			return barcode;
		}

		public String getAreacode() {
			return areacode;
		}

		public String getDestination() {
			return destination;
		}

		public int getRownumber() {
			return rownumber;
		}

		public int getFramenumber() {
			return framenumber;
		}

		public int getPlacenumber() {
			return placenumber;
		}

	}


