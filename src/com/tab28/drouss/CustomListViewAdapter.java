package com.tab28.drouss;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

	Context context;

	public CustomListViewAdapter(Context context, int resourceId,
			List<RowItem> items) {
		super(context, resourceId, items);
		this.context = context;
	}

	/* private view holder class */
	private class ViewHolder {
		ImageView imageView;
		TextView txtAuteur;
		TextView txtNom;
		TextView txtLangue;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		RowItem rowItem = getItem(position);

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.txtNom = (TextView) convertView.findViewById(R.id.nom);
			holder.txtAuteur = (TextView) convertView.findViewById(R.id.auteur);
			holder.txtLangue = (TextView) convertView.findViewById(R.id.langue);
			holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		holder.txtNom.setText(rowItem.getNom());
		holder.txtAuteur.setText(rowItem.getAuteur());
		holder.txtLangue.setText(rowItem.getLangue());
		holder.imageView.setImageResource(rowItem.getImageId());

		return convertView;
	}
}