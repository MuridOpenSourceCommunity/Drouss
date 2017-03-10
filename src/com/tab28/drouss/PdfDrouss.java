package com.tab28.drouss;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PdfDrouss extends DashBoardActivity{

	String myURL = null;
	private WebView webview;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pdf_drouss);
		setHeader(getString(R.string.HomeActivityTitle), false, true);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			myURL = extras.getString("url");
		}
		
		if (isOnline()) {
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebViewClient(new Callback());
		webview.loadUrl("https://docs.google.com/gview?url="+myURL);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setPluginState(PluginState.ON);
		} else {
			Toast.makeText(
					this,
					this.getString(R.string.no_connection),
					Toast.LENGTH_LONG).show();
		}
		
		final AlertDialog builder = new AlertDialog.Builder(this).create();
		builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("DROUSS");
        builder.setMessage("Veuillez patienter le temps que l'oeuvre se charge!");
        builder.setCancelable(true);


        builder.show();

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
            	builder.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 15000); // after 2 
	}


	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected()) {
			return true;
		}
		return false;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_about:
			openOptionsDialog();
			return true;
		case R.id.app_exit:
			exitOptionsDialog();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void exitOptionsDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.str_exit)
				.setMessage(R.string.app_exit_message)
				.setNegativeButton(R.string.str_no,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
							}
						})
				.setPositiveButton(R.string.str_ok,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								try {
									finalize();
								} catch (Throwable e) {
									e.printStackTrace();
								}
								System.exit(0);
							}
						}).show();
	}

	private void openOptionsDialog() {
		AboutDialog about = new AboutDialog(this);
		about.setTitle(Html.fromHtml(this.getString(R.string.app_about)));
		about.show();
	}

	private class Callback extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return (false);
		}
	}

}
