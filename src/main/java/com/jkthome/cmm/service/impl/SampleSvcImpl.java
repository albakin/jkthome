package com.jkthome.cmm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jkthome.cmm.dao.SampleDao;
import com.jkthome.cmm.service.SampleSvc;
import com.jkthome.cmm.service.vo.SampleVO;

@Service("sampleSvc")
public class SampleSvcImpl implements SampleSvc {
	
	@Autowired
	@Qualifier("sampleDao")
	SampleDao sampleDao = null;

	@Override
	public List<SampleVO> listSample(SampleVO sample) {
		List<SampleVO> sampleList = sampleDao.listSample(sample);
		return sampleList;
	}

}
