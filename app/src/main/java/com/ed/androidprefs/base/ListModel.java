package com.ed.androidprefs.base;

import android.content.Context;

import java.util.List;

public abstract class ListModel extends BaseModel {
	public ListModel(Context context) {
		super(context);
	}

	public abstract List<String> getValues();

	public boolean getPrefSelectedAtIndex(int position) {
		return getValues().get(position).equals(getCurrentPreference());
	}

	public void savePref(String value) {
		sharedPrefs.edit().putString(getKey(), value).apply();
	}
}
