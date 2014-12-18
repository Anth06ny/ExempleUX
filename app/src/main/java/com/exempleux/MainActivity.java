package com.exempleux;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.exempleux.adapter.EleveAdapter;
import com.exempleux.bean.Eleve;
import com.exempleux.composant.LinearLayoutApparitionAnimation;
import com.exempleux.composant.MyWaintingDialog;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    //Composants graphiques
    private ImageView iv_menu;
    private TextView tv_title, tv_resume;
    private ImageView iv_open;
    private LinearLayoutApparitionAnimation ll_extension;
    private com.gc.materialdesign.views.Switch sw_region;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private TextView bt_valider;
    private ListView lv;
    private MyWaintingDialog progressDialog = null;

    //Autre
    private EleveAdapter eleveAdapter;
    private ArrayList<Eleve> eleveList;

    /* ---------------------------------
    // view
    // -------------------------------- */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_resume = (TextView) findViewById(R.id.tv_resume);
        iv_open = (ImageView) findViewById(R.id.iv_open);
        ll_extension = (LinearLayoutApparitionAnimation) findViewById(R.id.ll_extension);
        sw_region = (com.gc.materialdesign.views.Switch) findViewById(R.id.sw_region);
        rb_1 = (RadioButton) findViewById(R.id.rb_0);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        bt_valider = (TextView) findViewById(R.id.bt_valider);
        lv = (ListView) findViewById(R.id.lv);

        rb_1.setOnClickListener(this);
        rb_2.setOnClickListener(this);
        rb_3.setOnClickListener(this);
        iv_open.setOnClickListener(this);
        bt_valider.setOnClickListener(this);

        eleveList = new ArrayList<Eleve>();
        eleveAdapter = new EleveAdapter(this, eleveList);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(eleveAdapter);

        fillList(rb_1.getId());
        tv_resume.setText(rb_1.getText());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /* ---------------------------------
    // evenement
    // -------------------------------- */

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

            iv_open.performClick();

            new AsyncTask() {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    handler.sendEmptyMessage(MSG_START_PROGRESS_BLOCANT);

                }

                @Override
                protected Object doInBackground(Object[] params) {
                    SystemClock.sleep(3000);
                    return null;
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    if (rb_1.isChecked()) {
                        fillList(rb_1.getId());
                        tv_resume.setText(rb_1.getText());
                    }
                    else if (rb_2.isChecked()) {
                        fillList(rb_2.getId());
                        tv_resume.setText(rb_2.getText());
                    }
                    else if (rb_3.isChecked()) {
                        fillList(rb_3.getId());
                        tv_resume.setText(rb_3.getText());
                    }

                    handler.sendEmptyMessage(MSG_STOP_PROGRESS);
                }
            }.execute();

        }
        else if (v == iv_open) {
            if (ll_extension.getVisibility() != View.VISIBLE) {
                iv_open.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_left));
                ll_extension.setVisibility(View.VISIBLE);
            }
            else {
                iv_open.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_right));
                ll_extension.setVisibility(View.GONE);
            }
        }
    }

    /* ---------------------------------
    // handler
    // -------------------------------- */
    private static final int MSG_STOP_PROGRESS = 1;
    private static final int MSG_START_PROGRESS_BLOCANT = 2;

    /** Handler pemettant de gerer certains evenements. */
    private final Handler handler = new Handler() {

        @Override
        public void handleMessage(final Message msg) {

            switch (msg.what) {
                case MSG_START_PROGRESS_BLOCANT:
                    if (progressDialog == null) {
                        progressDialog = new MyWaintingDialog();
                    }

                    if (!progressDialog.isVisible()) {
                        progressDialog.show(getFragmentManager(), "MyWaintingDialog");
                    }

                    break;
                case MSG_STOP_PROGRESS:

                    if (progressDialog != null && progressDialog.isVisible()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                    break;

                default:
                    break;
            }
        }
    };

    /* ---------------------------------
    // private
    // -------------------------------- */

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
