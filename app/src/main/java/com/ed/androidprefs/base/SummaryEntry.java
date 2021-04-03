package com.ed.androidprefs.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ed.androidprefs.R;
import com.ed.androidprefs.databinding.EntrySummaryBinding;

import lombok.Setter;

public class SummaryEntry implements View.OnClickListener {
	private final EntrySummaryBinding binding;

	private @Setter OnClickListener onClickListener;

	public interface OnClickListener {
		void onEntryClick();
	}

	public SummaryEntry(Context context, LinearLayout view) {
		binding = EntrySummaryBinding.inflate(LayoutInflater.from(context), view);
		LayoutInflater.from(context).inflate(R.layout.entry_summary, view, true);
		view.setOrientation(LinearLayout.VERTICAL);
		view.setOnClickListener(this);
	}

	public void setTitle(String title) {
		binding.title.setText(title);
	}

	public void setSummary(String summary, String currentPref) {
		binding.summary.setText(summary.replace("%s", currentPref));
	}

	@Override
	public void onClick(View v) {
		if (onClickListener != null) {
			onClickListener.onEntryClick();
		}
	}
}
