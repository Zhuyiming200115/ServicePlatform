package com.Ching.util;

//字串工具类
public class StringUtil {
//判空
public static boolean isEmpty(String str) {
	//trim是把前后空格去掉
	if (str==null||"".equals(str.trim())) {
		return true;
	}
	else {
		return false;
	}
}	

//判非空
	public static boolean isNotEmpty(String str) {
		if (str==null&&"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
