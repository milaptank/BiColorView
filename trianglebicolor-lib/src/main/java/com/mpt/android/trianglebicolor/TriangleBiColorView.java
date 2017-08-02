package com.mpt.android.trianglebicolor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;


/**
 * @author Milap Tank
 *         for WebMob Technologies
 *         Email:milaptank@gmail.com
 * @desc TriangleBiColorView.java  is for
 * @since 1/8/17  5:30 PM
 */
public class TriangleBiColorView extends LinearLayout {
    private TriangleView triViewTopColor;
    private TriangleView triViewBottomColor;
    private LayoutParams params;
    int size = 15;
    Context context;

    public TriangleBiColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public TriangleBiColorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        triViewTopColor = new TriangleView(context);
        triViewTopColor.setId(R.id.triViewTopColor);
        triViewTopColor.setDirection(TriangleView.Direction.UP);

        triViewBottomColor = new TriangleView(context);
        triViewBottomColor.setId(R.id.triViewBottomColor);
        triViewBottomColor.setDirection(TriangleView.Direction.DOWN);

        addView(triViewTopColor);
        addView(triViewBottomColor);

        int topColor = Color.GRAY;
        int bottomColor = Color.BLACK;
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.TriangleBiColorView,
                    0, 0);
            try {
                topColor = a.getInt(R.styleable.TriangleBiColorView_topColor, Color.GRAY);
                bottomColor = a.getInt(R.styleable.TriangleBiColorView_bottomColor, Color.BLACK);
                size = (int) a.getDimension(R.styleable.TriangleBiColorView_size, 15);

            } catch (Exception e) {
            } finally {
                a.recycle();
            }
            params = new LayoutParams(size * 2, size);
            triViewTopColor.setLayoutParams(params);
            triViewBottomColor.setLayoutParams(params);
            triViewBottomColor.setColor(bottomColor);
            triViewTopColor.setColor(topColor);
        }
    }

    public void setTopColor(int color) {
        color = ContextCompat.getColor(context, color);
        triViewTopColor.setColor(color);
    }

    public void setBottomColor(int color) {
        color = ContextCompat.getColor(context, color);
        triViewBottomColor.setColor(color);
    }

    public void setSize(int size) {
        params = new LayoutParams(size * 2, size);
        triViewTopColor.setLayoutParams(params);
        triViewBottomColor.setLayoutParams(params);
    }

    public void setBiColorClickListener(OnClickListener triangleClickListener) {
        triViewBottomColor.setOnClickListener(triangleClickListener);
        triViewTopColor.setOnClickListener(triangleClickListener);
    }


}

