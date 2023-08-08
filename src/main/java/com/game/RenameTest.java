package com.game;

import java.io.File;

public class RenameTest {
	
	public static void main(String[] args) {
		String rootPath = "C:\\dev\\works\\html\\img";
		String targetPath = "C:\\dev\\works\\html\\ing\\cards\\";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		int num = 0;
		for(File dir : dirs) {
			//System.out.print(dir.getName() + ",");
			//System.out.println(dir.isDirectory());
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					//System.out.println(file.getName());
					/*
					 * String name = file.getName(); System.out.println(name);
					 */
					/*
					 * if(name.contains("Th")) { continue; } name = name.substring(0,2);
					 * System.out.println(name); if("1a".equals(name)) { name = "01"; }else
					 * if(name.contains("_")) { name = "0" + name.substring(0,1); }
					 * //System.out.println(name); String path = file.getParent() +
					 * "\\" + name + ".png"; System.out.println(path); file.renameTo(new
					 * File(path));
					 */
					/*
					 * File targetFile = new File(targetPath + (num++) + ".png");
					 * file.renameTo(targetFile);
					 */
					/*for(file.getName().contains("Th")){
						continue;
					}*/
					File targetFile = new File(targetPath + (num++) + ".png");
					file.renameTo(targetFile);
				}
			}
		}
	}

}
