package com.exempleux;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.exempleux.adapter.EleveAdapter;
import com.exempleux.bean.Eleve;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    //Composants graphiques
    private ImageView iv_menu;
    private TextView tv_title;
    private ImageView iv_open;
    private LinearLayout ll_extension;
    private Switch sw_region;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private Button bt_valider;
    private ListView lv;

    //Autre
    private EleveAdapter eleveAdapter;
    private ArrayList<Eleve> eleveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_open = (ImageView) findViewById(R.id.iv_open);
        ll_extension = (LinearLayout) findViewById(R.id.ll_extension);
        sw_region = (Switch) findViewById(R.id.sw_region);
        rb_1 = (RadioButton) findViewById(R.id.rb_0);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        bt_valider = (Button) findViewById(R.id.bt_valider);
        lv = (ListView) findViewById(R.id.lv);

        rb_1.setOnClickListener(this);
        rb_2.setOnClickListener(this);
        rb_3.setOnClickListener(this);
        bt_valider.setOnClickListener(this);

        eleveList = new ArrayList<Eleve>();
        eleveAdapter = new EleveAdapter(this, eleveList);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(eleveAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if (v == rb_1) {
        }
        else if (v == rb_2) {
            // Handle clicks for rb_2
        }
        else if (v == rb_3) {
            // Handle clicks for rb_3
        }
        else if (v == bt_valider) {

            if (rb_1.isChecked()) {
                fillList(rb_1.getId());
            }
            else if (rb_2.isChecked()) {
                fillList(rb_2.getId());
            }
            else if (rb_3.isChecked()) {
                fillList(rb_3.getId());
            }
        }
    }

    private void fillList(int id) {
        eleveList.clear();

        if (id == R.id.rb_0) {
            eleveList.add(new Eleve("Carol", "Willick"));
            eleveList.add(new Eleve("Emily", "Waltham"));
            eleveList.add(new Eleve("Elizabeth", "Stevens"));
            eleveList.add(new Eleve("Charlie", "Wheeler"));
            eleveList.add(new Eleve("Elizabeth", "Hornswaggle"));
            eleveList.add(new Eleve("Rachel", "Green"));
        }
        else if (id == R.id.rb_2) {
            eleveList.add(new Eleve("Alexa", "Leskeys"));
            eleveList.add(new Eleve("Robin", "Scherbatsky"));
            eleveList.add(new Eleve("Blah", "blah"));
            eleveList.add(new Eleve("Tracy", "Mc Connell"));
            eleveList.add(new Eleve("Stella", "Zinman"));
            eleveList.add(new Eleve("Zoey", "Van Smoot"));
        }
        else {
            eleveList.add(new Eleve("Priya", "Koothrappalit"));
            eleveList.add(new Eleve("Penny", ""));
        }

        eleveAdapter.notifyDataSetChanged();
    }
}
