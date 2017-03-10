package com.tab28.drouss;

/**
 * @author Paresh N. Mayani
 * http://www.technotalkative.com
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends DashBoardActivity {
	/** Called when the activity is first created. */
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setHeader(getString(R.string.HomeActivityTitle), false, true);
		AlertDialog alertDialog1 = new AlertDialog.Builder(this).create();
		// Setting Dialog Title
		alertDialog1.setTitle("ASSALAMOUHALEYKOUM!");
		// Setting Dialog Message
		alertDialog1
				.setMessage(Html
						.fromHtml("<center>NOTRE CREDO: Oeuvrer pour Cheikh Ahmadou Bamba Khadimou Rassoul. <br/>Nous demandons à toute personne utilisant cette application de prier pour SERIGNE SALIOU MBACKE</center>"));
		// Setting Icon to Dialog
		alertDialog1.setIcon(R.drawable.serignesaliou);
		// Setting OK Button
		alertDialog1.setButton("OK!", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog closed
				Toast.makeText(getApplicationContext(), "DIEUREDIEUF!",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Showing Alert Message
		alertDialog1.show();

	}

	/**
	 * Button click handler on Main activity
	 * 
	 * @param v
	 */
	public void onButtonClicker(View v) {
		Intent intent;

		switch (v.getId()) {
		case R.id.thpub:
			intent = new Intent(this, ThesePubListViewActivity.class);
			startActivity(intent);
			break;

		case R.id.wolofal:
			intent = new Intent(this, WolofalListViewActivity.class);
			startActivity(intent);
			break;

		case R.id.tariq:
			intent = new Intent(this, TariqListViewActivity.class);
			startActivity(intent);

			break;

		case R.id.majalis:
			intent = new Intent(this, MajalisListViewActivity.class);
			startActivity(intent);
			break;

		case R.id.qassidas:
			intent = new Intent(this, QassidasListViewActivity.class);
			startActivity(intent);
			break;

//		case R.id.quran:
//			intent = new Intent(this, QuranListViewActivity.class);
//			startActivity(intent);
//			break;
		case R.id.autre:
			intent = new Intent(this, AutreListViewActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
