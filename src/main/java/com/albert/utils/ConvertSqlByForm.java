package com.albert.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * 通过提交的表单动态生成where子句
 * 未免过度设计，这里约定优于配置。按照前端提交的参数键值对生成sql（HQL、JPQL等）语句，举例说明，比如GET请求 
 * http://url?name=archie&&type_like=test&&credate_between=2016-09-16&&credate_and=2017-09-09&&org_in=1,2,3&&source_notin=5,6,7&&fuck_except=123
 * 上面请求生成语句 where name=archie and type like '%test%' and credate between 2016-09-16 and 2017-09-09 and org in(1,2,3) and source not in(5,6,7);
 * 一般的查询功能基本能满足，这里先挖个坑，以后有空深入封装
 * 对于POST请求，只需把设置表单name属性，比如<input name="test" value="1234"/>,生成where子句 ： where  test=1234;
 * @author Administrator
 *
 */
public class ConvertSqlByForm {
	public final static String IN = "_in";
	public final static String NOT_IN = "_notin";
	public final static String BETWEEN = "_between";
	public final static String BETWEENAND = "_betweenand";
	public final static String AND = "_and";
	/**
	 * @param map 
	 * @return
	 */
	public static String convert(RequestMap map){
		if(map== null || map.size()==0) return "";
		Iterator it = map.map.entrySet().iterator();
		map.getJpql().append(" where 1=1 ");
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			if(StringUtils.isEmpty(value)) continue;
			if(key.endsWith(AND)){
				map.getJpql().append(" and "+key.substring(0, key.indexOf(AND))+"=? ");
				map.getParams().add(value);
				continue;
			}
			if(key.endsWith(IN)){
				map.getJpql().append(" and "+ key.substring(0, key.indexOf(IN))+" in ");
				strSplitByComma(map, value);
				continue;
			}
			if(key.endsWith(NOT_IN)){
				map.getJpql().append(" and "+ key.substring(0, key.indexOf(NOT_IN))+" not in ");
				strSplitByComma(map, value);
				continue;
			}
			if(key.endsWith(BETWEEN)){
				map.getJpql().append(" and "+key.substring(0, key.indexOf(BETWEEN))+" between ? ");
				map.getParams().add(DateUtils.getBeginDate(value));
				continue;
			}
			if(key.endsWith(BETWEENAND)){
				map.getJpql().append(" and ? ");
				map.getParams().add(DateUtils.getEndDate(value));
				continue;
			}
		}
		return map.getJpql().toString();
	}
	/**
	 * 用逗号分隔并生成
	 * @return
	 */
	public static void strSplitByComma(RequestMap map,String str){
		String[] split = str.split(",");
		StringBuilder jpql = map.getJpql();
		List<Object> params = map.getParams();
		jpql.append(" (");
		for(String val : split){
			jpql.append("?,");
			params.add(val);
		}
		jpql.deleteCharAt(jpql.lastIndexOf(","));
		jpql.append(") "); 
	}
	
}
