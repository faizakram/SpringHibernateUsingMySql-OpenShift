package com.Accer.FileUploading;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.Accer.ImageResizer.CompressImage;

@Component
@Scope("request")
public class FileUploadingInWindows {
	
	@Autowired
	private CompressImage compressImage;
	@Autowired
	private Random random;
	
	public String uploadUserProfileImage(MultipartFile file, String dirname) {
		Integer name = random.nextInt();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File("D:/apptest/Profile/" + File.separator + dirname);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name+".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				compressImage.imageCompress(160, 160, serverFile.toString());
				return "profilePic/"+name+".jpg";
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
		
	}
}
