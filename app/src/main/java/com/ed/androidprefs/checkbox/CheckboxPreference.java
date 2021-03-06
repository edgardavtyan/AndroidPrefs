package com.ed.androidprefs.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ed.androidprefs.R;
import com.ed.androidprefs.R2;
import com.ed.androidprefs.base.BasePreference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckboxPreference extends BasePreference implements View.OnClickListener {
	@BindView(R2.id.title) TextView titleView;
	@BindView(R2.id.checkbox) CheckBox checkboxView;

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
		titleView.setText(title);
	}

	public void setChecked(boolean checked) {
		checkboxView.setChecked(checked);
	}

	public void setCheckBoxColor(int color) {
		CompoundButtonCompat.setButtonTintList(checkboxView, ColorStateList.valueOf(color));
	}

	@Override
	public void onClick(View v) {
		presenter.onPrefClicked();
	}

	private void initPref(AttributeSet attrs) {
		LayoutInflater.from(context).inflate(R.layout.entry_checkbox, this, true);
		ButterKnife.bind(this);

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
