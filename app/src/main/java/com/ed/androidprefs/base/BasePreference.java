package com.ed.androidprefs.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.ed.androidprefs.R;
import com.ed.androidprefs.utils.AttributeResolver;

public abstract class BasePreference extends LinearLayout {
	protected final Context context;

	public BasePreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		initCommonEntryViewProperties();
	}

	public BasePreference(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context = context;
		initCommonEntryViewProperties();
	}

	private void initCommonEntryViewProperties() {
		if (isInEditMode()) return;

		AttributeResolver attrs = new AttributeResolver(context);

		setBackground(attrs.getDrawable(R.attr.selectableItemBackground));
		setGravity(Gravity.CENTER_VERTICAL);

		int height = attrs.getDimen(R.attr.listPreferredItemHeightSmall);
		setMinimumHeight(height);

		int paddingLeft = attrs.getDimen(R.attr.listPreferredItemPaddingLeft);
		int paddingRight = attrs.getDimen(R.attr.listPreferredItemPaddingRight);
		setPadding(paddingLeft, 0, paddingRight, 0);
	}
}
