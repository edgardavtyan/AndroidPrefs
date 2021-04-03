package com.ed.androidprefs.color;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ed.androidprefs.databinding.EntryColorBinding;

import lombok.Setter;

public class ColorSelectionEntry implements View.OnClickListener {

	private final EntryColorBinding binding;

	private @Setter OnClickListener onClickListener;

	interface OnClickListener {
		void onEntryClick();
	}

	public ColorSelectionEntry(Context context, LinearLayout view) {
		binding = EntryColorBinding.inflate(LayoutInflater.from(context), view);
		view.setOnClickListener(this);
	}

	public void setTitle(String title) {
		binding.title.setText(title);
	}

	public void setColor(int color) {
		binding.color.setColor(color);
	}

	@Override
	public void onClick(View v) {
		if (onClickListener != null) {
			onClickListener.onEntryClick();
		}
	}
}
