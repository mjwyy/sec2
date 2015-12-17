/**
 * 
 * 查重
 * 条形码相同不应加入同一张表
 * */
package presentation.util;

import java.util.ArrayList;

import util.BarcodeAndState;

public class Chachong {
public static boolean isRepeat(ArrayList<String> array,String s){
	for(int i=0;i<array.size();i++){
		if(array.get(i).equals(s)){
			return true;
		}
	}
	return false;
	
}
public static boolean isRepeatState(ArrayList<BarcodeAndState> array,String s){
	for(int i=0;i<array.size();i++){
		if(array.get(i).getBarcode().equals(s)){
			return true;
		}
	}
	return false;
	
}
}
