/**
 * 
 */
package com.albert.utils;

/** 
* @ClassName: StringUtils 
* @Description: 
* @author albert
* @date 2017年4月27日 下午3:21:33 
*  
*/
public class StringUtils {
	/**
	 * 判断字符串是否为数字（不是小数）
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
	  for (int i = 0; i < str.length(); i++)
	  {  
	    System.out.println(str.charAt(i));
	    if (!Character.isDigit(str.charAt(i)))
	    {
	        return false;
	      }
	  }
	  return true;
	}
}
