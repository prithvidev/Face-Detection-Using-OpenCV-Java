package com.fdetection;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class jfdetection {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String img = "images/aaa.jpg";
		Mat src = Imgcodecs.imread(img);
		String xmlfile = "xml/lbpcascade_frontalface_improved.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlfile);
		
		MatOfRect fd = new MatOfRect();
		cc.detectMultiScale(src, fd);
		System.out.println(String.format("Detected Faces: %d", fd.toArray().length));
		
		for(Rect rect: fd.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x  + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
		}
		
		Imgcodecs.imwrite("images/new.jpg", src);
		System.out.println("Image Detection Finished");
	}

}
