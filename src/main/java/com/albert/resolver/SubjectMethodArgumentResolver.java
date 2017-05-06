package com.albert.resolver;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.albert.annotation.Subject;
import com.albert.domain.Constants;
import com.albert.domain.table.User;
import com.albert.service.CommonService;
import com.albert.utils.BookException;

@Component
public class SubjectMethodArgumentResolver implements HandlerMethodArgumentResolver{
	private final static Logger logger = LoggerFactory.getLogger(SubjectMethodArgumentResolver.class); 
	@Resource
	private CommonService commonService;
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		logger.debug("当前用户id:"+Constants.CURRENT_USER_ID);
		Object obj = webRequest.getAttribute(Constants.CURRENT_USER_ID,  RequestAttributes.SCOPE_REQUEST);
		if(obj==null) throw new BookException("request中未存入当前主题的ID");
		Long userId = (Long) obj;
		User curr_user = commonService.findEntityById(User.class, userId);
		if(curr_user == null) throw new BookException(Constants.CURRENT_USER_ID+":当前主题ID未找到主题信息");
		return curr_user;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(Subject.class)) {
            return true;
        }
        return false;
	}

}
