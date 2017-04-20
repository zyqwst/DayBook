/**
 * 
 */
package com.albert.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;
import com.albert.domain.table.Dictionary;
import com.albert.domain.view.QueryBook;
import com.albert.service.CommonService;
import com.albert.utils.BookException;
import com.albert.utils.ConvertSqlByForm;
import com.albert.utils.Page;
import com.albert.utils.RequestMap;
import com.albert.utils.Value;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController implements ErrorController {
	@Resource
	private CommonService commonService;
	@RequestMapping(value={"/","index"})
	public String index(HttpServletRequest request){
		System.out.println(request.getRequestURI());
		return "系统已成功启动";
	}
	
	@RequestMapping(value = "/dictionary")
	public RestEntity dictionary(HttpServletRequest request,Long typeid){
		try {
			System.out.println("web获取");
			List<Dictionary> list =  commonService.findAll(Dictionary.class, " where typeid=? ", new Value().add(typeid).getParams());
			return RestEntity.success(list);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	
	private static final String ERROR_PATH = "/error";  
	   
	 @RequestMapping(value=ERROR_PATH)  
    public RestEntity error404(){  
        return RestEntity.failed("错误的资源路径", "404");  
    }
	 
	 

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}  
   
}
