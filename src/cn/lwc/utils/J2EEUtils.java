package cn.lwc.utils;

public class J2EEUtils {
	/**
	 * �����������ҳ��ҳ����x��y�ֱ����ܼ�¼����ÿҳ��¼��
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
