package com.app.uicore.splash;

/**
 * 视差动画播放时参数的控制
 */
public class ParallaxViewTag {
	protected float xIn;
	protected float xOut;
	protected float yIn;
	protected float yOut;
	protected float alphaIn;
	protected float alphaOut;
	
	
	@Override
	public String toString() {
		return "ParallaxViewTag [index=" +  ", xIn=" + xIn + ", xOut="
				+ xOut + ", yIn=" + yIn + ", yOut=" + yOut + ", alphaIn="
				+ alphaIn + ", alphaOut=" + alphaOut + "]";
	}

	
}
