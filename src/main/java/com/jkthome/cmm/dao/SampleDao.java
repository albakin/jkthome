package com.jkthome.cmm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jkthome.cmm.service.vo.SampleVO;

@Repository("sampleDao")
public class SampleDao {
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession = null;
	
	/**
	 * @Method 설명 : Sample 
	 * @param sample
	 * @return
	 */
	public List<SampleVO> listSample(SampleVO sample) {
		return sqlSession.selectList("sample.listSample", sample);
	}
}
