package com.bookSystem.Tools;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

public class InterfaceControl {

	public static void setLocationCentre(JFrame j) {
		// TODO Auto-generated method stub
        int windowWidth = j.getWidth();
        int windowHeigh = j.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenW = screenSize.width;
        int screenH = screenSize.height;
        ((Window) j).setLocation(screenW/2-windowWidth/2, screenH/2-windowHeigh/2);
	}
}
