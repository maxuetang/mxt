package com.mxt.sign;

import java.util.Iterator;
import java.util.Map;
/**
 * 签名
 * @author maxuetang.cn
 * @date 2022-04-06
 */
public class SignHelper {
	/**
	 * 生成签名
	 * @param map:TreeMap
	 * @param key:商户密钥
	 * @return 签名字符串
	 */
	public static String sign(Map map, String key){
		map.remove("sign");
		Iterator <String>iter = map.keySet().iterator();
		StringBuffer sb = new StringBuffer();
		while(iter.hasNext()){
			sb.append(map.get(iter.next()));
		}
		return SHA256Util.createSHA256Str(sb.toString() + key);
	}
	/**
	 * 签名验证
	 * @param map:TreeMap
	 * @param key:商户密钥
	 * @param sign:签名字符串
	 * @return
	 */
	public static boolean checkSign(Map map, String key, String sign){
		if(map==null)return false;
		map.remove("sign");
		Iterator <String>iter = map.keySet().iterator();
		StringBuffer sb = new StringBuffer();
		while(iter.hasNext()){
			sb.append(map.get(iter.next()));
		}
		if(sb.length()<1)return false;
		return sign.equalsIgnoreCase(SHA256Util.createSHA256Str(sb.toString() + key));
	}
}