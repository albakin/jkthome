package com.jkthome.cmm.service.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.03    박지욱          최초 생성
 *
 *  @author 공통서비스 개발팀 박지욱
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 */
@Getter
@Setter
public class LoginVO implements Serializable{
	
	private static final long serialVersionUID = -8274004534207618049L;
	
	/** 아이디 */
	private String id;
	/** 별명 */
	private String name;
	/** 이메일주소 */
	private String email;
	/** 비밀번호 */
	private String password;
	/** 사용자구분 */
	private String userSe;
	/** 고유아이디 */
	private String uniqId;
	/** 로그인 후 이동할 페이지 */
	private String url;
	/** 사용자 IP정보 */
	private String ip;
}
