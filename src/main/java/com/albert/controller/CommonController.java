/**
 * 
 */
package com.albert.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albert.annotation.Authorization;
import com.albert.domain.RestEntity;
import com.albert.domain.table.Dictionary;
import com.albert.service.CommonService;
import com.albert.utils.BookException;
import com.albert.utils.Value;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {
	@Resource
	private CommonService commonService;
	
	@Authorization
	@RequestMapping(value = "/dictionary")
	public RestEntity dictionary(HttpServletRequest request,Long typeid){
		try {
			List<Dictionary> list =  commonService.findAll(Dictionary.class, " where typeid=? ", new Value().add(typeid).getParams());
			return RestEntity.success(list);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	
	   

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}  
   
}
