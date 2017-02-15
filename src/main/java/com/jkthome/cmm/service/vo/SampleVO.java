package com.jkthome.cmm.service.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("sampleVO")
public class SampleVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private String salary;
	private String commissionPct;
	private String managerId;
	private String departmentId;
}
