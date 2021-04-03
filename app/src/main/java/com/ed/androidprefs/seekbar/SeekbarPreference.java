package com.ed.androidprefs.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.SeekBar;

import com.ed.androidprefs.base.BasePreference;
import com.ed.androidprefs.databinding.EntrySeekbarBinding;

public class SeekbarPreference extends BasePreference {

	private SeekbarPreferencePresenter presenter;
	private EntrySeekbarBinding binding;

	private SeekBar.OnSeekBarChangeListener onSeekbarChangeListener = new SeekBar.OnSeekBarChangeListener() {
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			presenter.onSeek(progress);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
		}
	};

	public SeekbarPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPref(attrs);
	}

	public SeekbarPreference(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPref(attrs);
	}

	public void setTitle(String title) {
		binding.title.setText(title);
	}

	public int getSeek() {
		return binding.seekbar.getProgress();
	}

	public void setSeek(int seek) {
		binding.seekbar.setProgress(seek);
	}

	public void setSeekText(String text) {
		binding.valueText.setText(text);
	}

	public void setMaxSeek(int maxValue) {
		binding.seekbar.setMax(maxValue);
	}

	public void setColor(int color) {
		binding.seekbar.setProgressColor(color);
		binding.seekbar.setThumbColor(color);
	}

	private void initPref(AttributeSet attrs) {
		binding = EntrySeekbarBinding.inflate(LayoutInflater.from(context), this);

		setOrientation(VERTICAL);
		setPadding(0, 0, 0, 0);
		binding.seekbar.setOnSeekBarChangeListener(onSeekbarChangeListener);

		SeekbarPreferenceModel model = new SeekbarPreferenceModel(context, attrs);

		if (isInEditMode()) {
			setTitle(model.getTitle());
			setSeek(model.getDefaultValue());
			setMaxSeek(model.getMaxValue());
			setSeekText(String.format(model.getFormat(), getSeek() * model.getMultiplier()));
			return;
		}

		presenter = new SeekbarPreferencePresenter(this, model);
		presenter.onInit();
	}
}
