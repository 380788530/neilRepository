package com.neil.apkUtil.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import com.neil.apkUtil.domain.ApkInfo;
import com.neil.apkUtil.domain.ApkResp;


public class ApkUtil {

	private static final Logger logger = Logger.getLogger(ApkUtil.class);

	private static final Namespace NS = Namespace
			.getNamespace("http://schemas.android.com/apk/res/android");

	public static List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

	public static Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public static void getApkInfo(String apkPath) {
		ApkInfo apkInfo = new ApkInfo();
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		try {
			document = builder.build(getXmlInputStream(apkPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();// 跟节点-->manifest
		apkInfo.setVersionCode(root.getAttributeValue("versionCode", NS));
		apkInfo.setVersionName(root.getAttributeValue("versionName", NS));
		apkInfo.setApkPackage(root.getAttributeValue("package", NS));
		Element elemUseSdk = root.getChild("uses-sdk");// 子节点-->uses-sdk
		apkInfo.setMinSdkVersion(elemUseSdk.getAttributeValue("minSdkVersion",
				NS));
		List listPermission = root.getChildren("uses-permission");// 子节点是个集合
		List permissions = new ArrayList();
		for (Object object : listPermission) {
			String permission = ((Element) object)
					.getAttributeValue("name", NS);
			permissions.add(permission);
		}
		apkInfo.setUses_permission(permissions);

		String s = root.getAttributes().toString();
		String c[] = s.split(",");
		ApkResp apkResp = new ApkResp();
		for (String a : c) {
			if (a.contains("versionCode")) {
				apkResp.setVersionCode(a.substring(
						a.indexOf("versionCode=\"") + 13, a.lastIndexOf("\"")));
			}
			if (a.contains("versionName")) {
				apkResp.setVersionName(a.substring(
						a.indexOf("versionName=\"") + 13, a.lastIndexOf("\"")));
			}
			if (a.contains("package")) {
				apkResp.setPackageName(a.substring(a.indexOf("package=\"") + 9,
						a.lastIndexOf("\"")));
			}
		}
		System.out.println("versionCode>>>:"+apkResp.getVersionCode());
		System.out.println("versionName>>>:"+apkResp.getVersionName());
		map.put("versionCode", apkResp.getVersionCode());
		map.put("versionName", apkResp.getVersionName());
		mapList.add(map);
		logger.info("apk mapList>>>>>>>>>>>>>" + mapList.toString());
//		File file = new File(apkPath);
//		System.gc();
//		boolean deleteFlag = file.delete();

//		logger.info("apk文件是否删除>>>>>>>>>>>>>" + deleteFlag);
	}

	private static InputStream getXmlInputStream(String apkPath) {
		InputStream inputStream = null;
		InputStream xmlInputStream = null;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(apkPath);
			ZipEntry zipEntry = new ZipEntry("AndroidManifest.xml");
			inputStream = zipFile.getInputStream(zipEntry);
			AXMLPrinter xmlPrinter = new AXMLPrinter();
			xmlPrinter.startPrinf(inputStream);
			xmlInputStream = new ByteArrayInputStream(xmlPrinter.getBuf()
					.toString().getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				inputStream.close();
				zipFile.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return xmlInputStream;
	}

	public static String getInputStream() {
		// String requestUrl =
		// "http://127.0.0.1:8080/gateway2server/download/labi_xs_20160929_v3.0.9e.apk";
		String requestUrl = "http://www.labifenqi.com/download/labi_xs_20160929_v3.0.9e.apk";

		BufferedInputStream bis = null;
		HttpURLConnection httpConn = null;
		long lastModified = 0L;
		try {
			try {
				// 创建url对象
				URL urlObj = new URL(requestUrl);
				// 创建HttpURLConnection对象，通过这个对象打开跟远程服务器之间的连接
				httpConn = (HttpURLConnection) urlObj.openConnection();
				httpConn.setDoInput(true);
				httpConn.setRequestMethod("GET");
				httpConn.setConnectTimeout(5000);
				httpConn.setDefaultUseCaches(false);
				httpConn.connect();

				if (httpConn.getResponseCode() == 200) {
					lastModified = httpConn.getLastModified();
					// 服务器有响应后，会将访问的url页面中的内容放进inputStream中，使用httpConn就可以获取到这个字节流
					// 服务器比本地时间新
					if (mapList.size() == 0 || lastModified != (Long) mapList.get(0).get("myLastModified")) {

						Date serverDate = new Date(lastModified);
						String serverLastTie = Tools.formatyyyyMMddhhmmss(serverDate);
						logger.info("getInputStream>>>获取服务器上传Apk时间>>>>>>>>>>>>" + serverLastTie);
						if (mapList.size() == 0) {
							logger.info("getInputStream>>>本地Apk没有缓存时间>>>>>>>>>>>>");
						} else {
							Date myDate = new Date(
									Long.valueOf((String) mapList.get(2).get(
											"myLastModified")));
							String myLastTime = Tools.formatyyyyMMddhhmmss(myDate);
							logger.info("getInputStream>>>获取本地Apk缓存时间>>>>>>>>>>>>"
									+ myLastTime);
						}

						bis = new BufferedInputStream(httpConn.getInputStream());
						saveApkLastModified(bis);
						map.put("myLastModified", lastModified);
						return "1";
					} else {
						logger.info("getInputStream>>>时间一致,未更新>>>>>>>>>>>>");
						return "0";
					}

				}
			} finally {
				if (bis != null)
					bis.close();
				if (httpConn != null)
					httpConn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public static void saveApkLastModified(BufferedInputStream bis)
			throws FileNotFoundException, IOException {
		String realPath ="";
		BufferedInputStream bufis = new BufferedInputStream(bis);
		 File f = new File(realPath);
		 // 如果没有的话就创建目录
		 if (!f.exists()) {
		 f.mkdirs();
		 }
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(realPath + "labifenqi.apk"));
		byte[] b = new byte[bufis.available()];
		int len = 0;
		while ((len = bufis.read(b)) != -1) {
			out.write(b, 0, len);
		}
		out.flush();
		bufis.close();
		out.close();

	}

	public static List<Map<String, Object>> getMapApk()
			throws FileNotFoundException, IOException {

		return mapList;
	}

}
