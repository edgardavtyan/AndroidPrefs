package com.ed.androidprefs.simple_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ed.androidprefs.databinding.ListitemRadioBinding;

import lombok.Getter;
import lombok.Setter;

public class SimpleListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	private final ListitemRadioBinding binding;

	protected @Getter @Setter String value;
	protected @Setter OnHolderClickListener onHolderClickListener;

	public interface OnHolderClickListener {
		void onHolderClick(String value);
	}

	public SimpleListViewHolder(View itemView) {
		super(itemView);
		binding = ListitemRadioBinding.bind(itemView);
		binding.getRoot().setOnClickListener(this);
	}

	public void setChecked(boolean checked) {
		binding.radioButton.setChecked(checked);
	}

	public void setTitle(String title) {
		binding.title.setText(title);
	}

	@Override
	public void onClick(View v) {
		if (onHolderClickListener != null) {
			onHolderClickListener.onHolderClick(value);
		}
	}
}
