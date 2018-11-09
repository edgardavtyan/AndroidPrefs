package com.ed.androidprefs.simple_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.ed.androidprefs.R;
import com.ed.androidprefs.base.ListModel;
import com.ed.androidprefs.utils.ArrayUtils;

import java.util.List;

import lombok.Cleanup;
import lombok.Getter;

public class SimpleListModel extends ListModel {
	private final @Getter String key;
	private final @Getter String title;
	private final @Getter String summary;
	private final @Getter String defaultValue;
	private final @Getter List<String> entries;
	private final @Getter List<String> values;

	public SimpleListModel(Context context, AttributeSet attributeSet) {
		super(context);

		@Cleanup("recycle")
		@SuppressLint("Recycle")
		TypedArray attrs = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleListPref);
		key = attrs.getString(R.styleable.SimpleListPref_cp_key);
		title = attrs.getString(R.styleable.SimpleListPref_cp_title);
		summary = attrs.getString(R.styleable.SimpleListPref_cp_summary);
		defaultValue = attrs.getString(R.styleable.SimpleListPref_cp_defaultValue);
		entries = ArrayUtils.asStringList(attrs.getTextArray(R.styleable.SimpleListPref_cp_entries));
		values = ArrayUtils.asStringList(attrs.getTextArray(R.styleable.SimpleListPref_cp_entryValues));
	}
}
