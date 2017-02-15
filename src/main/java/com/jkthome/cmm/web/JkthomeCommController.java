package com.jkthome.cmm.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkthome.cmm.annotation.AnnotationCheck;
import com.jkthome.cmm.service.SampleSvc;
import com.jkthome.cmm.service.vo.SampleVO;

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
@Controller
public class JkthomeCommController {
	/** log */
	private static Logger logger = LoggerFactory.getLogger(JkthomeCommController.class);
	
	@Autowired
	@Qualifier("sampleSvc")
	SampleSvc sampleSvc = null;
	
	@ResponseBody
	@AnnotationCheck
	@RequestMapping("/sample")
	public Object index(ModelMap model) throws Exception {
		String arg0 = "==================={} logger sample ================";
		logger.info(arg0, "info");
		logger.warn(arg0, "warn");
		logger.error(arg0, "error");
		HashMap<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("testKey", "testValue");
		
		List<SampleVO> sampleList =  sampleSvc.listSample(new SampleVO());
		
		rtnMap.put("sampleList", sampleList);
		
		
		return rtnMap;
	}

}
