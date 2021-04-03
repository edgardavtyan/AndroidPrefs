package com.ed.androidprefs.description_list;

import android.view.View;

import com.ed.androidprefs.databinding.ListitemDescriptionBinding;
import com.ed.androidprefs.simple_list.SimpleListViewHolder;

public class DescriptionListViewHolder extends SimpleListViewHolder {
	private final ListitemDescriptionBinding binding;

	public DescriptionListViewHolder(View itemView) {
		super(itemView);
		binding = ListitemDescriptionBinding.bind(itemView);
	}

	public void setDescription(String description) {
		binding.description.setText(description);
	}
}
