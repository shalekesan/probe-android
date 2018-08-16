package org.openobservatory.ooniprobe.item;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.openobservatory.ooniprobe.R;
import org.openobservatory.ooniprobe.model.Network;
import org.openobservatory.ooniprobe.model.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import localhost.toolkit.widget.HeterogeneousRecyclerItem;

public class WebsiteItem extends HeterogeneousRecyclerItem<Result, WebsiteItem.ViewHolder> {
	public WebsiteItem(Result extra) {
		super(extra);
	}

	@Override public ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
		return new ViewHolder(layoutInflater.inflate(R.layout.item_websites, viewGroup, false));
	}

	@Override public void onBindViewHolder(ViewHolder viewHolder) {
		viewHolder.asnName.setText(Network.getAsnName(viewHolder.asnName.getContext(), extra.getMeasurement().network));
		viewHolder.startTime.setText(DateFormat.getDateFormat(viewHolder.startTime.getContext()).format(extra.start_time));
		viewHolder.failedMeasurements.setText(viewHolder.failedMeasurements.getContext().getString(R.string.decimal, extra.countMeasurement(null, true, null)) + " blockEd");
		viewHolder.okMeasurements.setText(viewHolder.okMeasurements.getContext().getString(R.string.decimal, extra.countMeasurement(true, null, false)) + " accesiblE");
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.asnName) TextView asnName;
		@BindView(R.id.startTime) TextView startTime;
		@BindView(R.id.failedMeasurements) TextView failedMeasurements;
		@BindView(R.id.okMeasurements) TextView okMeasurements;

		ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}