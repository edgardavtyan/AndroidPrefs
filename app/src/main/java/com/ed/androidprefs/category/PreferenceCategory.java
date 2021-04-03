package com.ed.androidprefs.category;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ed.androidprefs.databinding.CategoryBinding;

public class PreferenceCategory extends LinearLayout {
	private CategoryBinding binding;

	public PreferenceCategory(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public PreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	public void setTextColor(int color) {
		binding.heading.setTextColor(color);
	}

	private void init(Context context, AttributeSet attrs) {
		binding = CategoryBinding.inflate(LayoutInflater.from(context));
		setOrientation(VERTICAL);

		PreferenceCategoryModel model = new PreferenceCategoryModel(context, attrs);
		binding.heading.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
		binding.heading.setTextColor(model.getColor());
		binding.heading.setText(model.getTitle());
	}
}
