package com.tab28.drouss;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TariqListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] noms = new String[] {
			"Les Dons du Digne de Reconnaissance", "L´Abreuvement du commensal" };

	public static final String[] auteurs = new String[] {
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba" };
	public static final String[] langues = new String[] { "Français",
			"Français" };

	public static final Integer[] images = { R.drawable.dondigne,
			R.drawable.abre };

	ListView listView;
	List<RowItem> rowItems;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste);
		setHeader(getString(R.string.HomeActivityTitle), false, true);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < noms.length; i++) {
			RowItem item = new RowItem(images[i], noms[i], auteurs[i],
					langues[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(R.id.list);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this,
				R.layout.list_item, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (isOnline()) {
			String urlPdf = null;
			Intent i = new Intent(getApplicationContext(), PdfDrouss.class);
			switch (position) {
			case 0:
				urlPdf = "http://drouss.org/pdf/Les%20Dons%20du%20Digne%20de%20Reconnaissance.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/Irwanu-Nadim.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			default:
				break;
			}
		} else {
			Toast.makeText(this, this.getString(R.string.no_connection),
					Toast.LENGTH_LONG).show();
		}

	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected()) {
			return true;
		}
		return false;
	}
}