package com.guosen.chartview.component;

import android.graphics.Color;
import android.graphics.Typeface;

import com.guosen.chartview.util.Utils;

/**
 * This class encapsulates everything both Axis and Legend have in common.
 * X,Y轴和Legend类都共同的封装好的抽象类
 * @author QSKOBE24
 */
public abstract class ComponentBase {

    /** flag that indicates if this axis / legend is enabled or not 
     * 指示坐标轴或者是折线段说明是否可以编辑*/
    protected boolean mEnabled = true;

    /** the offset in pixels this axis labels have on the x-axis 
     * X轴上的数据和X轴线的距离*/
    protected float mXOffset = 5f;

    /** the offset in pixels this axis labels have on the Y-axis 
     * Y轴上显示的数据和Y轴的轴线的距离    上下偏移的距离*/
    protected float mYOffset = 5f;

    /** the typeface used for the labels 
     * 标签的类型样式*/
    protected Typeface mTypeface = null;

    /** the text size of the labels
     * 标签的字体大小 */
    protected float mTextSize = 10f;

    /** the text color to use for the labels 
     * 标签的颜色值,其实就是X轴,Y轴上的字体的颜色*/
    protected int mTextColor = Color.BLACK;

    public ComponentBase() {

    }

    /**
     * Returns the used offset on the x-axis for drawing the axis or legend
     * labels. This offset is applied before and after the label.
     * 
     * @return
     */
    public float getXOffset() {
        return mXOffset;
    }

    /**
     * Sets the used x-axis offset for the labels on this axis.
     * 
     * @param xOffset
     */
    public void setXOffset(float xOffset) {
        mXOffset = Utils.convertDpToPixel(xOffset);
    	//mXOffset = xOffset;
    }

    /**
     * Returns the used offset on the x-axis for drawing the axis labels. This
     * offset is applied before and after the label.
     * 
     * @return
     */
    public float getYOffset() {
        return mYOffset;
    }

    /**
     * Sets the used y-axis offset for the labels on this axis. For the legend,
     * higher offset means the legend as a whole will be placed further away
     * from the top.
     * 
     * @param xOffset
     */
    public void setYOffset(float yOffset) {
        mYOffset = Utils.convertDpToPixel(yOffset);
    	//mYOffset = yOffset;
    }

    /**
     * returns the Typeface used for the labels, returns null if none is set
     * 
     * @return
     */
    public Typeface getTypeface() {
        return mTypeface;
    }

    /**
     * sets a specific Typeface for the labels
     * 
     * @param tf
     */
    public void setTypeface(Typeface tf) {
        mTypeface = tf;
    }

    /**
     * sets the size of the label text in pixels min = 6f, max = 24f, default
     * 10f
     * 
     * @param size
     */
    public void setTextSize(float size) {

        if (size > 24f)
            size = 24f;
        if (size < 6f)
            size = 6f;

        mTextSize = Utils.convertDpToPixel(size);
    }

    /**
     * returns the text size that is currently set for the labels
     * 
     * @return
     */
    public float getTextSize() {
        return mTextSize;
    }

    /**
     * Sets the text color to use for the labels. Make sure to use
     * getResources().getColor(...) when using a color from the resources.
     * 
     * @param color
     */
    public void setTextColor(int color) {
        mTextColor = color;
    }

    /**
     * Returns the text color that is set for the labels.
     * 
     * @return
     */
    public int getTextColor() {
        return mTextColor;
    }

    /**
     * Set this to true if this component should be enabled (should be drawn),
     * false if not. If disabled, nothing of this component will be drawn.
     * Default: true
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    /**
     * Returns true if this comonent is enabled (should be drawn), false if not.
     * 
     * @return
     */
    public boolean isEnabled() {
        return mEnabled;
    }
}