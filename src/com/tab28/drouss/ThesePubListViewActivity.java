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

public class ThesePubListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] noms = new String[] { "Ocean of Wisdom",
			"Cheikh Ahmadou Bamba Mouridisme",
			"Les Aspects du Mouridisme au Sénégal",
			"Fighting The Greater Jihad",
			"Jaar-jaari-Boroom Tuubaa (Itineraries of Boroom Tuuba)",
			"Les quatre imâms", /* "Destinée du Mouridisme", "La Mouridiya", */
			"Marsiyya Seex Amadu Kabiir Mbay", "Educating the Murid",
			"Le Phenomene de La Desunion Au Sein de Certaines Organisations Religieuses" };

	public static final String[] auteurs = new String[] {
			"Cheikh Abdoulaye Dieye", "Alain Juillet", "Ibrahim Thiam",
			"Cheikh Anta Babou", "Serigne Mouhammadou Mahmoud Niang",
			"Messaoud Boudjenoun", /* "Madické Wade", */
			/* "Cheikh Mouhammadoul Mourtada ibn Cheikh Faty Fall", */
			"MBAYE, Cheikh Amadou Kabir", "Cheikh Anta Babou","Cheikh Mame Mor Mbacke Mourtada" };
	public static final String[] langues = new String[] { "Anglais",
			"Anglais et Français", "Français", "Anglais", "Anglais",
			"Français", /* "Français", "Arabe", */"Français", "Anglais","Français" };

	public static final Integer[] images = { R.drawable.ocean,
			R.drawable.cabdmou, R.drawable.defaut, R.drawable.figh,
			R.drawable.jaar, R.drawable.quatreimam, /* R.drawable.defaut, */
			/* R.drawable.mouridya */R.drawable.defaut, R.drawable.defaut, R.drawable.mam };

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
				urlPdf = "http://drouss.org/pdf/Ocean-of-Wisdom.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/GuideMouridisme.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 2:
				urlPdf = "http://drouss.org/pdf/AspectsMouridismeSenegal.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 3:
				urlPdf = "http://drouss.org/pdf/FightingtheGreaterJihad.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 4:
				urlPdf = "http://drouss.org/pdf/Jaar-jaariBoromTouba.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 5:
				urlPdf = "http://drouss.org/pdf/Les-Quatre-Imams-Fondateurs-Des-Ecoles-Sunnites-de-Messaoud-Boudjenoun%5b1%5d.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			/*
			 * case 7: // urlPdf = ""; i.putExtra("url", urlPdf);
			 * 
			 * // startActivity(i); break;
			 */

			case 6:
				urlPdf = "http://drouss.org/pdf/MarsiyaaSeexAmaduKabiirMbay.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 7:
				urlPdf = "http://drouss.org/pdf/Educating-the-Murid.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 8:
				urlPdf = "http://drouss.org/pdf/Le-Phenomene.pdf";
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