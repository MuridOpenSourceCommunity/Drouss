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

public class QassidasListViewActivity extends DashBoardActivity implements
		OnItemClickListener {

	public static final String[] noms = new String[] { "Xaatimatou Mounajaat",
			"Waqani Midadi Yassourou", "Diaalibatul Marakhib", "Sindiidi",
			"Muntaxabaat", "Muqadimatoul Khidma", "Irda'ulWaalidayni",
			"Niaanu Serigne bi", "Chakuru Raafihu", "Mouhammadine",
			"Astahfiroullaaha Bihi","Matlabou Chifa-i" };

	public static final String[] auteurs = new String[] {
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba", "Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba",
			"Cheikh Ahmadou Bamba" };
	public static final String[] langues = new String[] { "Arabe", "Arabe",
			"Arabe", "Arabe", "Arabe", "Arabe", "Arabe", "Arabe", "Arabe",
			"Arabe", "Arabe" , "Arabe" };

	public static final Integer[] images = { R.drawable.xatima,
			R.drawable.waqani, R.drawable.jaalibatou, R.drawable.defaut,
			R.drawable.muntaqabat, R.drawable.xidma, R.drawable.irda,
			R.drawable.defaut, R.drawable.defaut, R.drawable.defaut,
			R.drawable.defaut,
			R.drawable.matla };

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
				urlPdf = "http://drouss.org/pdf/XaatimatouMounajaat.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;

			case 1:
				urlPdf = "http://drouss.org/pdf/WMY.pdf";
				i.putExtra("url", urlPdf);
				startActivity(i);
				break;
			case 2:
				urlPdf = "http://drouss.org/pdf/Jaalibatoul%20Maraxib.pdf";
				startActivity(i);
				break;
			case 3:
				urlPdf = "http://drouss.org/pdf/Sindiidi.pdf";
				startActivity(i);
				break;
			case 4:
				urlPdf = "http://drouss.org/pdf/Muntaxabaat.pdf";
				startActivity(i);
				break;
			case 5:
				urlPdf = "http://drouss.org/pdf/Mouxadimatoul-xidma(s-Bousso-Imam-Touba-Moko-Bind).pdf";
				startActivity(i);
				break;
			case 6:
				urlPdf = "http://drouss.org/pdf/Irda-ulWaalidayni.pdf";
				startActivity(i);
				break;
			case 7:
				urlPdf = "http://drouss.org/pdf/Niaanu-Serigne-bi.pdf";
				startActivity(i);
				break;
			case 8:
				urlPdf = "http://drouss.org/pdf/ChakuruRaafihu.pdf";
				startActivity(i);
				break;
			case 9:
				urlPdf = "http://drouss.org/pdf/Mouhammadine.pdf";
				startActivity(i);
				break;
			case 10:
				urlPdf = "http://drouss.org/pdf/Matlabou%20Chifa.pdf";
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