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

public class WolofalListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] noms = new String[] { "Ndaxam ap Mouride",
			"Yaaram bi", "Ndiouth Ndiath", "Maimunatoun Bintul Xadym",
			"Majmahu Wolofal (Partie 4)", "Majmahu Wolofal (Partie 3)",
			"Majmahu Wolofal (Partie 2)", "Majmahu Wolofal (Partie 1)",
			"Kharit boul tamal yaw sa boppu lébal", "Wolofalu Magal Yi",
			"Jazbul Majzoob" };

	public static final String[] auteurs = new String[] {
			"Serigne Mbaye Diakhaté", "Cheikh Abdoul Karim Samba Diarra Mbaye",
			"Cheikh Mussa Kâ", "Soxna Maîmouna Mbacké", "Serigne Mamor Kayré",
			"Serigne Mamor Kayré", "Serigne Mamor Kayré",
			"Serigne Mamor Kayré", "Cheikh Mbaye Diakhaté", "Cheikh Mussa Kâ",
			"Cheikh Abdoul Karim Samba Diarra Mbaye" };

	public static final String[] langues = new String[] { "Wolofal", "Wolofal",
			"Wolof", "Wolof", "Wolof", "Wolof", "Wolof", "Wolof", "Wolof",
			"Wolof", "Wolof" };

	public static final Integer[] images = { R.drawable.ndaxam,
			R.drawable.yarambi, R.drawable.ndiou, R.drawable.maimo,
			R.drawable.majmo, R.drawable.majmo, R.drawable.majmo,
			R.drawable.majmo, R.drawable.defaut, R.drawable.woma,
			R.drawable.majzob };

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
				urlPdf = "http://drouss.org/pdf/Ndaxam%20ap%20mouride.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/Yaarambi.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 2:
				urlPdf = "http://drouss.org/pdf/Ndiouth%20Ndiath.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 3:
				urlPdf = "http://drouss.org/pdf/Ma%C3%AFmunatounBintulXadym.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 4:
				urlPdf = "http://drouss.org/pdf/MajmahuWolofal-4.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 5:
				urlPdf = "http://drouss.org/pdf/MajmahuWolofal-3.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 6:
				urlPdf = "http://drouss.org/pdf/MajmahuWolofal-2.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 7:
				urlPdf = "http://drouss.org/pdf/MajmahuWolofal-1.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 8:
				urlPdf = "http://drouss.org/pdf/Kharit.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 9:
				urlPdf = "http://drouss.org/pdf/Wolofal-Magalyi.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 10:
				urlPdf = "http://drouss.org/pdf/JazbulMajzub.pdf";
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