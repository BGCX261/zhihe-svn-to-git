package org.lps.entity;

// Generated 2010-9-24 20:25:38 by Hibernate Tools 3.3.0.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.Length;

@Entity
@Table(name = "om_employee", catalog = "ls")
@SQLDelete(sql="update om_employee set EMP_CODE='1' where emp_Id=?")
public class OmEmployee implements java.io.Serializable {

	/**
	
	 人员编号
	 */
	private long empId;

	/**
	
	 人员代码
	 */
	private String empCode;

	/**
	
	 操作员编号（对应操作员表的操作员编号，允许为空）
	 */
	private Long operatorId;

	/**
	
	 操作员登录号（对应操作员表的操作员登录号，允许为空（冗余字段））
	 */
	private String userId;

	/**
	
	 人员姓名
	 */
	private String empName;

	/**
	
	 人员全名（英文全名）
	 */
	private String realName;

	/**
	
	 性别
	 */
	private String sex;

	/**
	
	 出生日期
	 */
	private Date birthDate;

	/**
	
	 基本岗位
	 */
	private Long position;

	/**
	
	 状�1�7�1�7
	 */
	private String status;

	/**
	
	 证件类型
	 */
	private String certificateType;

	/**
	
	 证件号码
	 */
	private String certificateNo;

	/**
	
	 入职日期
	 */
	private Date entryDate;

	/**
	
	 离职日期
	 */
	private Date departureDate;

	/**
	
	 办公电话
	 */
	private String officePhone;

	/**
	
	 办公地址
	 */
	private String officeAddress;

	/**
	
	 办公邮编
	 */
	private String officeZipcode;

	/**
	
	 办公邮件
	 */
	private String officeEmail;

	/**
	
	 传真号码
	 */
	private String faxNo;

	/**
	
	 手机号码
	 */
	private String mobileNo;

	/**
	
	 MSN号码
	 */
	private String msnNo;

	/**
	
	 家庭电话
	 */
	private String homePhone;

	/**
	
	 家庭地址
	 */
	private String homeAddress;

	/**
	
	 家庭邮编
	 */
	private String homeZipcode;

	/**
	
	 私人电子邮箱
	 */
	private String privateEmail;

	/**
	
	 政治面貌
	 */
	private String politicalLandscape;

	/**
	
	 职级
	 */
	private String degree;

	/**
	
	 直接主管
	 */
	private Long directSupervisor;

	/**
	
	 可授权角艄1�7
	 */
	private String specialty;

	/**
	
	 工作描述
	 */
	private String workDesc;

	/**
	
	 注册日期
	 */
	private Date regDate;

	/**
	
	 创建时间
	 */
	private Date createDate;

	/**
	
	 朄1�7新更新时闄1�7
	 */
	private Date lastModifyDate;

	/**
	
	 如果是多个机构，则机构编号之间用,分割
	 */
	private String orgidList;

	/**
	
	 主机构编叄1�7
	 */
	private Long orgId;

	/**
	
	 备注
	 */
	private String notes;

	/**
	
	 DN
	 */
	private String dn;

	public OmEmployee() {
	}

	public OmEmployee(long empId) {
		this.empId = empId;
	}

	public OmEmployee(long empId, String empCode, Long operatorId,
			String userId, String empName, String realName, String sex,
			Date birthDate, Long position, String status,
			String certificateType, String certificateNo, Date entryDate,
			Date departureDate, String officePhone, String officeAddress,
			String officeZipcode, String officeEmail, String faxNo,
			String mobileNo, String msnNo, String homePhone,
			String homeAddress, String homeZipcode, String privateEmail,
			String politicalLandscape, String degree, Long directSupervisor,
			String specialty, String workDesc, Date regDate, Date createDate,
			Date lastModifyDate, String orgidList, Long orgId, String notes,
			String dn) {
		this.empId = empId;
		this.empCode = empCode;
		this.operatorId = operatorId;
		this.userId = userId;
		this.empName = empName;
		this.realName = realName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.position = position;
		this.status = status;
		this.certificateType = certificateType;
		this.certificateNo = certificateNo;
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.officePhone = officePhone;
		this.officeAddress = officeAddress;
		this.officeZipcode = officeZipcode;
		this.officeEmail = officeEmail;
		this.faxNo = faxNo;
		this.mobileNo = mobileNo;
		this.msnNo = msnNo;
		this.homePhone = homePhone;
		this.homeAddress = homeAddress;
		this.homeZipcode = homeZipcode;
		this.privateEmail = privateEmail;
		this.politicalLandscape = politicalLandscape;
		this.degree = degree;
		this.directSupervisor = directSupervisor;
		this.specialty = specialty;
		this.workDesc = workDesc;
		this.regDate = regDate;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.orgidList = orgidList;
		this.orgId = orgId;
		this.notes = notes;
		this.dn = dn;
	}

	@Id
	@Column(name = "EMP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	@Column(name = "EMP_CODE", length = 30)
	@Length(max = 30)
	public String getEmpCode() {
		return this.empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	@Column(name = "OPERATOR_ID", precision = 18, scale = 0)
	public Long getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name = "USER_ID", length = 30)
	@Length(max = 30)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "EMP_NAME", length = 50)
	@Length(max = 50)
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name = "REAL_NAME", length = 50)
	@Length(max = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "POSITION", precision = 10, scale = 0)
	public Long getPosition() {
		return this.position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CERTIFICATE_TYPE")
	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	@Column(name = "CERTIFICATE_NO", length = 20)
	@Length(max = 20)
	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENTRY_DATE", length = 10)
	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEPARTURE_DATE", length = 10)
	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@Column(name = "OFFICE_PHONE", length = 12)
	@Length(max = 12)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "OFFICE_ADDRESS")
	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Column(name = "OFFICE_ZIPCODE", length = 10)
	@Length(max = 10)
	public String getOfficeZipcode() {
		return this.officeZipcode;
	}

	public void setOfficeZipcode(String officeZipcode) {
		this.officeZipcode = officeZipcode;
	}

	@Column(name = "OFFICE_EMAIL", length = 128)
	@Length(max = 128)
	public String getOfficeEmail() {
		return this.officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	@Column(name = "FAX_NO", length = 14)
	@Length(max = 14)
	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	@Column(name = "MOBILE_NO", length = 14)
	@Length(max = 14)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "MSN_NO", length = 16)
	@Length(max = 16)
	public String getMsnNo() {
		return this.msnNo;
	}

	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}

	@Column(name = "HOME_PHONE", length = 12)
	@Length(max = 12)
	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "HOME_ADDRESS", length = 128)
	@Length(max = 128)
	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Column(name = "HOME_ZIPCODE", length = 10)
	@Length(max = 10)
	public String getHomeZipcode() {
		return this.homeZipcode;
	}

	public void setHomeZipcode(String homeZipcode) {
		this.homeZipcode = homeZipcode;
	}

	@Column(name = "PRIVATE_EMAIL", length = 128)
	@Length(max = 128)
	public String getPrivateEmail() {
		return this.privateEmail;
	}

	public void setPrivateEmail(String privateEmail) {
		this.privateEmail = privateEmail;
	}

	@Column(name = "POLITICAL_LANDSCAPE")
	public String getPoliticalLandscape() {
		return this.politicalLandscape;
	}

	public void setPoliticalLandscape(String politicalLandscape) {
		this.politicalLandscape = politicalLandscape;
	}

	@Column(name = "DEGREE")
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "DIRECT_SUPERVISOR", precision = 10, scale = 0)
	public Long getDirectSupervisor() {
		return this.directSupervisor;
	}

	public void setDirectSupervisor(Long directSupervisor) {
		this.directSupervisor = directSupervisor;
	}

	@Column(name = "SPECIALTY", length = 1024)
	@Length(max = 1024)
	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Column(name = "WORK_DESC", length = 512)
	@Length(max = 512)
	public String getWorkDesc() {
		return this.workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REG_DATE", length = 10)
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_MODIFY_DATE", length = 10)
	public Date getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	@Column(name = "ORGID_LIST", length = 128)
	@Length(max = 128)
	public String getOrgidList() {
		return this.orgidList;
	}

	public void setOrgidList(String orgidList) {
		this.orgidList = orgidList;
	}

	@Column(name = "ORG_ID", precision = 10, scale = 0)
	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(name = "NOTES", length = 512)
	@Length(max = 512)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "DN", length = 250)
	@Length(max = 250)
	public String getDn() {
		return this.dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

}
