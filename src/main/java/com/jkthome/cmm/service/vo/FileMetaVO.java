package com.jkthome.cmm.service.vo;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties({"bytes"})
public class FileMetaVO {

	private String fileName;
	private String fileSize;
	private String fileType;
	
	private byte[] bytes;
}
