package com.ed.androidprefs.description_list;

import android.view.View;
import android.widget.TextView;

import com.ed.androidprefs.R2;
import com.ed.androidprefs.simple_list.SimpleListViewHolder;

import butterknife.BindView;

public class DescriptionListViewHolder extends SimpleListViewHolder {
	@BindView(R2.id.description) TextView descriptionView;

	public DescriptionListViewHolder(View itemView) {
		super(itemView);
	}

	public void setDescription(String description) {
		descriptionView.setText(description);
	}
}
