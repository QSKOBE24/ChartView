package com.guosen.chartview.component;



import com.guosen.chartview.data.Entry;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


/**
 * View that can be displayed when selecting values in the chart. Extend this
 * class to provide custom layouts for your markers.
 *  当选中某个值时需要展示的弹出小图标，继承自相对布局
 * @author Philipp Jahoda
 */
public abstract class MarkerView extends RelativeLayout {

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     * 
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MarkerView(Context context, int layoutResource) {
        super(context);
        setupLayoutResource(layoutResource);
    }

    /**
     * Sets the layout resource for a custom MarkerView.
     * 用一个布局文件来设定MarkerView的背景样式
     * @param layoutResource
     */
    private void setupLayoutResource(int layoutResource) {

        View inflated = LayoutInflater.from(getContext()).inflate(layoutResource, this);

        inflated.setLayoutParams(new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        inflated.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

        // measure(getWidth(), getHeight());
        inflated.layout(0, 0, inflated.getMeasuredWidth(), inflated.getMeasuredHeight());
    }

    /**
     * Draws the MarkerView on the given position on the screen with the given
     * Canvas object.
     * 
     * @param canvas
     * @param posx
     * @param posy
     */
    public void draw(Canvas canvas, float posx, float posy) {

        // take offsets into consideration
        posx += getXOffset();
        posy += getYOffset();

        // translate to the correct position and draw
        canvas.translate(posx, posy);
        draw(canvas);
        canvas.translate(-posx, -posy);
    }

    /**
     * This method enables a specified custom MarkerView to update it's content
     * everytime the MarkerView is redrawn.
     * 
     * @param e The Entry the MarkerView belongs to. This can also be any
     *            subclass of Entry, like BarEntry or CandleEntry, simply cast
     *            it at runtime.
     * @param dataSetIndex the index of the DataSet the selected value is in
     */
    public abstract void refreshContent(Entry e, int dataSetIndex);

    /**
     * Use this to return the desired offset you wish the MarkerView to have on
     * the x-axis. By returning -(getWidth() / 2) you will center the MarkerView
     * horizontally.
     * 
     * @return
     */
    public abstract int getXOffset();

    /**
     * Use this to return the desired position offset you wish the MarkerView to
     * have on the y-axis. By returning -getHeight() you will cause the
     * MarkerView to be above the selected value.
     * 
     * @return
     */
    public abstract int getYOffset();
}
