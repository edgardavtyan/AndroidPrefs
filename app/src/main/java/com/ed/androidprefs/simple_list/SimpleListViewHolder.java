package com.ed.androidprefs.simple_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ed.androidprefs.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;
import lombok.Setter;

public class SimpleListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	protected @Getter @Setter String value;
	protected @Setter OnHolderClickListener onHolderClickListener;

	@BindView(R2.id.radio_button) RadioButton radioButton;
	@BindView(R2.id.title) TextView titleView;

	public interface OnHolderClickListener {
		void onHolderClick(String value);
	}

	public SimpleListViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		itemView.setOnClickListener(this);
	}

	public void setChecked(boolean checked) {
		radioButton.setChecked(checked);
	}

	public void setTitle(String title) {
		titleView.setText(title);
	}

	@Override
	public void onClick(View v) {
		if (onHolderClickListener != null) {
			onHolderClickListener.onHolderClick(value);
		}
	}
}
