package com.github.ripple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class MySimpleRing extends View {

	private Paint mPaint;
	private Paint mCirclePaint;

	public MySimpleRing(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public MySimpleRing(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public MySimpleRing(Context context) {
		super(context);
		initView();
	}

	private void initView() {
		// 画线条的画笔
		mPaint = new Paint();
		mPaint.setColor(Color.GREEN);
		mPaint.setStrokeWidth(5);// 设置线条粗细

		// 画圆的画笔
		mCirclePaint = new Paint();
		mCirclePaint.setColor(Color.RED);
		mCirclePaint.setStyle(Style.STROKE);//空心圆
		mCirclePaint.setStrokeWidth(5);// 设置线条粗细
		mCirclePaint.setAntiAlias(true);// 去掉锯齿
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(200, 200);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// 画棋盘
		for (int i = 10; i < 200; i += 20) {
			canvas.drawLine(0, i, 200, i, mPaint);// 画水平线
			canvas.drawLine(i, 0, i, 200, mPaint);// 画竖直线
		}

		//移动画布
		canvas.translate(-20, -20);
		// 画圆
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, 50, mCirclePaint);// 参1,2是圆心坐标,参3:半径
	}

}
