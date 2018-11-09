package com.ed.androidprefs.description_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ed.androidprefs.R;
import com.ed.androidprefs.simple_list.SimpleListViewHolder;

public class DescriptionListAdapter
		extends RecyclerView.Adapter<DescriptionListViewHolder>
		implements SimpleListViewHolder.OnHolderClickListener {

	private final Context context;
	private final DescriptionListPresenter presenter;

	public DescriptionListAdapter(Context context, DescriptionListPresenter presenter) {
		this.context = context;
		this.presenter = presenter;
	}

	@Override
	public DescriptionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.listitem_description, parent, false);
		return new DescriptionListViewHolder(view);
	}

	@Override
	public void onBindViewHolder(DescriptionListViewHolder holder, int position) {
		presenter.bindViewHolder(holder, position);
		holder.setOnHolderClickListener(this);
	}

	@Override
	public int getItemCount() {
		return presenter.getItemCount();
	}

	@Override
	public void onHolderClick(String value) {
		presenter.onListItemSelected(value);
		notifyDataSetChanged();
	}
}
