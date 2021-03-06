package com.ed.androidprefs.simple_list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.ed.androidprefs.base.BaseDialog;
import com.ed.androidprefs.base.BasePreference;
import com.ed.androidprefs.base.SummaryEntry;
import com.ed.androidprefs.utils.PixelConverter;

public class SimpleListPreference
		extends BasePreference
		implements SummaryEntry.OnClickListener {

	private SummaryEntry entryView;
	private BaseDialog dialogView;
	private SimpleListPresenter presenter;

	public SimpleListPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPreference(attrs);
	}

	public SimpleListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPreference(attrs);
	}

	public void openDialog() {
		dialogView.show();
	}

	public void closeDialog() {
		dialogView.dismiss();
	}

	public void setTitle(String title) {
		entryView.setTitle(title);
		dialogView.setTitle(title);
	}

	public void setSummary(String summary, String currentPref) {
		entryView.setSummary(summary, currentPref);
	}

	public void setDialogButtonsColor(int color) {
		dialogView.setButtonsColor(color);
	}

	@Override
	public void onEntryClick() {
		presenter.onEntryClicked();
	}

	private void initPreference(AttributeSet attrs) {
		entryView = initEntryView();
		SimpleListModel model = new SimpleListModel(context, attrs);

		if (isInEditMode()) {
			entryView.setTitle(model.getTitle());
			entryView.setSummary(model.getSummary(), model.getDefaultValue());
			return;
		}

		presenter = new SimpleListPresenter(this, model);
		dialogView = initDialogView(presenter);
		presenter.onViewsInit();
	}

	private SummaryEntry initEntryView() {
		SummaryEntry entryView = new SummaryEntry(context, this);
		entryView.setOnClickListener(this);
		return entryView;
	}

	private BaseDialog initDialogView(SimpleListPresenter presenter) {
		RecyclerView list = new RecyclerView(context);
		list.setLayoutManager(new LinearLayoutManager(context));
		list.setAdapter(new SimpleListAdapter(context, presenter));
		list.setPadding(0, PixelConverter.dpToPx(8), 0, 0);

		BaseDialog dialog = new BaseDialog(context);
		dialog.setView(list);
		return dialog;
	}
}
