package com.ed.androidprefs.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.ed.androidprefs.base.BasePreference;
import com.ed.androidprefs.databinding.EntryCheckboxBinding;


public class CheckboxPreference extends BasePreference implements View.OnClickListener {

	private EntryCheckboxBinding binding;
	private CheckboxPreferencePresenter presenter;

	public CheckboxPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPref(attrs);
	}

	public CheckboxPreference(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPref(attrs);
	}

	public void setTitle(String title) {
		binding.title.setText(title);
	}

	public void setChecked(boolean checked) {
		binding.checkbox.setChecked(checked);
	}

	public void setCheckBoxColor(int color) {
		CompoundButtonCompat.setButtonTintList(binding.checkbox, ColorStateList.valueOf(color));
	}

	@Override
	public void onClick(View v) {
		presenter.onPrefClicked();
	}

	private void initPref(AttributeSet attrs) {
		binding = EntryCheckboxBinding.inflate(LayoutInflater.from(context), this);

		setOrientation(HORIZONTAL);
		setOnClickListener(this);

		CheckboxPreferenceModel model = new CheckboxPreferenceModel(context, attrs);

		if (isInEditMode()) {
			setTitle(model.getTitle());
			setChecked(model.getDefaultValue());
			return;
		}

		presenter = new CheckboxPreferencePresenter(this, model);
		presenter.onInit();
	}
}
