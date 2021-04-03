package com.ed.androidprefs.color;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ed.androidprefs.R;
import com.ed.androidprefs.databinding.ViewColorToggleBinding;

public class ColorToggleSelectedView extends FrameLayout {
	private ViewColorToggleBinding binding;

	public ColorToggleSelectedView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ColorToggleSelectedView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public void setChecked(boolean checked) {
		binding.checkIcon.setVisibility(checked ? VISIBLE : INVISIBLE);
	}

	public int getColor() {
		return binding.colorView.getColor();
	}

	public void setColor(int color) {
		binding.colorView.setColor(color);
	}

	@Override
	public void setLayoutParams(ViewGroup.LayoutParams params) {
		super.setLayoutParams(params);

		int padding = params.width / 8;
		binding.checkIcon.setPadding(padding, padding, padding, padding);
	}

	private void init(Context context) {
		binding = ViewColorToggleBinding.inflate(LayoutInflater.from(context), this);
		inflate(context, R.layout.view_color_toggle, this);
	}
}
