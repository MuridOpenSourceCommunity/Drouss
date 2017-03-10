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

public class MajalisListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] auteurs = new String[] {
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba" };
	public static final String[] noms = new String[] {
			"Silkoul Jawahir(Partie 1)", "Silkoul Jawahir(Partie 2)",
			"Silkoul Jawahir(Partie 3)", "Silkoul Jawahir(Partie 4)",
			"Silkoul Jawahir(Partie 5)",
			"La Voix de la Satisfaction des Besoins", "Munawwirou-s-Suduur",
			"Sahandatu Tulaab", "Jazbatu-ç-Çighar",
			"Le Viatique de la Jeunesse", "Le Viatique des Adolescents",
			"Le Joyau Précieux",
			"Les Vérous de l'Enfer et les Clefs du Paradis",
			"Les Dons du Très Saint", "L'Illumination des Coeurs",
			"Les Itinéraires du Paradis" };

	public static final String[] langues = new String[] { "Arabe", "Arabe",
			"Arabe", "Arabe", "Arabe", "Français", "Arabe", "Arabe", "Arabe",
			"Français", "Français", "Français", "Français", "Français",
			"Français", "Français" };

	public static final Integer[] images = { R.drawable.cilkou,
			R.drawable.cilkou, R.drawable.cilkou, R.drawable.cilkou,
			R.drawable.cilkou, R.drawable.voibe, R.drawable.munaw,
			R.drawable.cahan, R.drawable.jazabatou, R.drawable.viatijeu,
			R.drawable.viatiado, R.drawable.joypre, R.drawable.verrou,
			R.drawable.dontre, R.drawable.illu, R.drawable.itti };

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
				urlPdf = "http://drouss.org/pdf/SilkoulJawahir1.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/SilkoulJawahir2.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 2:
				urlPdf = "http://drouss.org/pdf/SilkoulJawahir3.pdf";
				startActivity(i);
				break;
			case 3:
				urlPdf = "http://drouss.org/pdf/SilkoulJawahir4.pdf";
				startActivity(i);
				break;
			case 4:
				urlPdf = "http://drouss.org/pdf/SilkoulJawahir5.pdf";
				startActivity(i);
				break;
			case 5:
				urlPdf = "http://drouss.org/pdf/Nahju.pdf";
				startActivity(i);
				break;
			case 6:
				urlPdf = "http://drouss.org/pdf/Munawwirou-s-Suduur.pdf";
				startActivity(i);
				break;

			case 7:
				urlPdf = "http://drouss.org/pdf/SahandatuTulaab.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 8:
				urlPdf = "http://drouss.org/pdf/Jazbatu-c-Cighar.pdf";
				startActivity(i);
				break;
			case 9:
				urlPdf = "http://drouss.org/pdf/LEVIATIQUEDELAJEUNESSE.pdf";
				startActivity(i);
				break;
			case 10:
				urlPdf = "http://drouss.org/pdf/ViatiquedesAdolescents.pdf";
				startActivity(i);
				break;
			case 11:
				urlPdf = "http://drouss.org/pdf/LeJoyauPrecieux.pdf";
				startActivity(i);
				break;
			case 12:
				urlPdf = "http://drouss.org/pdf/LES-VERROUS-DE-L-ENFER-ET-LES-CLEFS-DU-PARADIS.pdf";
				startActivity(i);
				break;
			case 13:
				urlPdf = "http://drouss.org/pdf/LES-DONS-DU-TR%c9S-SAINT.pdf";
				startActivity(i);
				break;
			case 14:
				urlPdf = "http://drouss.org/pdf/L-ILLUMINATION-DES-C%8cURS.pdf";
				startActivity(i);
				break;
			case 15:
				urlPdf = "http://drouss.org/pdf/Massalik.pdf";
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