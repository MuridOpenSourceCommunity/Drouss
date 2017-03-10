package com.tab28.drouss;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
 
public class QuranListViewActivity extends DashBoardActivity implements
        OnItemClickListener {
 
    public static final String[] noms = new String[] { "Strawberry",
            "Banana", "Orange" };
 
    public static final String[] auteurs = new String[] {
        "It is an aggregate accessory fruit",
        "It is the largest herbaceous flowering plant", "Citrus Fruit" };
    public static final String[] langues = new String[] {
        "Français",
        "Anglais", "Wolof" };
 
    public static final Integer[] images = { 
    	R.drawable.thpubmouridiya, R.drawable.defaut  };
 
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
            RowItem item = new RowItem(images[i], noms[i], auteurs[i], langues[i]);
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
    }
}