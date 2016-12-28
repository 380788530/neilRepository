package com.neil.apkUtil.domain;

public class ApkResp {
	
	private String versionCode;
	
	private String versionName;
	
	private String packageName;

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String toString() {
		return "ApkResp [versionCode=" + versionCode + ", versionName="
				+ versionName + ", packageName=" + packageName + "]";
	}
	
	

}
