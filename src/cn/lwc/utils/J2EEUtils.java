package cn.lwc.utils;

public class J2EEUtils {
	/**
	 * 可以用来求分页的页数，x和y分别是总记录数和每页记录数
	 * @param x 
	 * @param y
	 * @return
	 */
	public static int  intCeil(int x,int y) {
		if(x%y==0){
			return x/y;
		}else{
			return x/y+1;
		}
	}

	
	public static int  startIndex(int currentPage,int pageRecordCount) {
		return (currentPage-1)*pageRecordCount;
	}

}
