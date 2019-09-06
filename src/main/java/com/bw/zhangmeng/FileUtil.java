package com.bw.zhangmeng;

import java.io.File;

import org.apache.log4j.Logger;


/** 
 * @author ����:zhangmeng
 * @version ����ʱ�䣺2019��7��8�� ����10:13:56 
 * �๦��˵�� 
 */
public class FileUtil {

	public static Logger log=Logger.getLogger(FileUtil.class);
	
	/**
	 * ��ȡ�ļ���չ��
	 * 
	 * @param fileName
	 * @return
	 */
	public  static String getSuffix(String fileName){
		int dotIndex=fileName.lastIndexOf('.');
		if (dotIndex<0) {
			return "";
					
		}
		//���һλ
		if (dotIndex>=fileName.length()) {
			return "";
		}
		return fileName.substring(dotIndex+1);
		
	}
	
	
	/**
	 * �����Ŀ¼����������ļ���������Ŀ¼Hon�����ļ���Ҫɾ��
	 * ʹ�õݹ飬�漰���ݣ��ж�Ŀ¼�Ĵ����ԣ��ж��Ƿ�ΪĿ¼���ļ���ɾ��
	 * @param fileName
	 */
	public static void delFilePath(String fileName){
		File file = new File(fileName);
		//�ļ���������ֱ�ӷ���
		if (!file.exists()) {
			return;
			
		}
		//������ļ�����ɾ���󷵻�
		if (file.isFile()) {
			log.info("ɾ���ļ�"+fileName);
			file.delete();
			return;
		}
		//�����Ŀ¼
		if (file.isDirectory()) {
			//�г�Ŀ¼�����е���Ŀ¼���ļ�
			String[] list = file.list();
			//���ÿһ��
			for (String subPath : list) {
				//����ɾ������
				delFilePath(fileName+"/"+subPath);
			}
			log.info("-------ɾ���ļ���"+fileName);
			file.delete();
			
		}
	}
	
	
	
	
	
}
