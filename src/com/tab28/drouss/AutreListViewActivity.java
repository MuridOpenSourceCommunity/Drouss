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

public class AutreListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] noms = new String[] { "Diazboul Mouride",
			"Muharram & Yawma Âchùrâ", "Recueil de Qutbas(jumuha)",
			"Recueil de Qutbas(Korité)", "Recueil de Qutbas(Tabaski)",
			"Khouratoul Ayni", "Le Message Coranique", "Le Coran",
			"Ramadan Mubârak", "Mubayyin Al Ishkal",
			"Itineraries of Boroom Tuuba", "Le Prophéte Mouhammad", "La Zakat",
			"Mame Diarra Bousso", "Chahrou Rajab",
			"Causeries de L'ASPIRANT Véridique","Recueils de Sermons" };

	public static final String[] auteurs = new String[] {
			"Cheikh Ibrahima Fall", "Drouss.org", "Serigne Sam Mbaye",
			"Serigne Sam Mbaye", "Serigne Sam Mbaye",
			"Cheikh Abo Madyana Shouhaïbou Mbacké", "Serigne Sam Mbaye",
			"Serigne Sam Mbaye", "Drouss.org", "Xaali Madiakhaté Kala",
			"Serigne Mouhammadou Mahmoud Niang", "Serigne Sam Mbaye",
			"Cheikhouna Lo Ngabou", "Cheikh Amadou Bamba Seye", "Drouss.org",
			"Cheikh Ibrahima Fall","Cheikh Mouhammadou Moustapha Mbacké" };
	public static final String[] langues = new String[] { "Français",
			"Français & Arabe", "Arabe", "Arabe", "Arabe", "Français",
			"Français", "Français", "Français", "Arabe", "Anglais", "Français",
			"Français & Arabe", "Français", "Français", "Français", "Français" };

	public static final Integer[] images = { R.drawable.jezboul,
			R.drawable.mouharam, R.drawable.qutba, R.drawable.qutbako,
			R.drawable.qutbatab, R.drawable.qurra, R.drawable.meco,
			R.drawable.lecoran, R.drawable.ramadane, R.drawable.moubayinul,
			R.drawable.itineborom, R.drawable.prophete, R.drawable.zakat,
			R.drawable.mamediarra, R.drawable.craj, R.drawable.cav , R.drawable.cmm };

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
				urlPdf = "http://drouss.org/pdf/DiazboulMouride.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/ChahrouMuharram..pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 2:
				urlPdf = "http://drouss.org/pdf/QutbaAlJumuha.pdf";
				i.putExtra("url", urlPdf);

				startActivity(i);
				break;
			case 3:
				urlPdf = "http://drouss.org/pdf/QutbaKorite.pdf";
				i.putExtra("url", urlPdf);

				startActivity(i);
				break;
			case 4:
				urlPdf = "http://drouss.org/pdf/QutbaTabaski.pdf";
				i.putExtra("url", urlPdf);

				startActivity(i);
				break;
			case 5:
				urlPdf = "http://drouss.org/pdf/KHOURATOUL%20AYNI.pdf";
				i.putExtra("url", urlPdf);

				startActivity(i);
				break;
			case 6:
				urlPdf = "http://drouss.org/pdf/LeMessageCoranique.pdf";
				i.putExtra("url", urlPdf);

				startActivity(i);
				break;

			case 7:
				urlPdf = "http://drouss.org/pdf/LeCORAN.pdf";

				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 8:
				// urlPdf = "";
				// i.putExtra("url", urlPdf);
				//
				// startActivity(i);
				break;
			case 9:
				// urlPdf = "";
				// i.putExtra("url", urlPdf);
				//
				// startActivity(i);
				break;
			case 10:
				urlPdf = "http://drouss.org/pdf/Jaar-jaariBoromTouba.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 11:
				urlPdf = "http://drouss.org/pdf/LE-PROPHETE-MOUHAMMAD(P.S.L.).pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 12:
				urlPdf = "http://drouss.org/pdf/La%20Zakat.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 13:
				urlPdf = "http://drouss.org/pdf/MameDiarraBousso.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 14:
				urlPdf = "http://drouss.org/pdf/ChahrouRajab.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 15:
				urlPdf = "http://drouss.org/pdf/RecueilsSermonsCheikhMoustapha.pdf";
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