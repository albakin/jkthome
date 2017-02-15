package com.jkthome.cmm;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  공통 컨트롤러 
 * @author wildmaru
 * @since 2016.07.8
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------        --------    ---------------------------
 * </pre>
 */
@ControllerAdvice
public class JkthomeExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(JkthomeExceptionHandler.class);

	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
	private Object handleException(HttpServletRequest request, Exception e) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String errorMessage = ExceptionUtils.getMessage(e);
		logger.info(String.format("return value : %s", map.toString()));
		logger.info(String.format("error : %s", ExceptionUtils.getStackTrace(e) ));
		
		map.put("errorMessage", errorMessage);
		
		return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
	}
}
