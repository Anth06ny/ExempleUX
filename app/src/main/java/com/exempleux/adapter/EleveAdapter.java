package com.exempleux.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.exempleux.R;
import com.exempleux.bean.Eleve;

import java.util.List;


public class EleveAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final List<Eleve> eleveBeanList;

    public EleveAdapter(final Context context, final List<Eleve> eleveBeanList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.eleveBeanList = eleveBeanList;
    }

    @Override
    public int getCount() {
        return eleveBeanList.size();
    }

    @Override
    public Eleve getItem(final int position) {
        return eleveBeanList.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View rowView = convertView;

        //---------------------
        // inflate
        //-------------------------
        final ViewHolder viewHolder;
        if (rowView == null) {
            //création
            rowView = mInflater.inflate(R.layout.eleve_cellule, null);

            viewHolder = new ViewHolder();
            viewHolder.ec_tv_nom = (TextView) rowView.findViewById(R.id.ec_tv_nom);
            viewHolder.ec_tv_prenom = (TextView) rowView.findViewById(R.id.ec_tv_prenom);

            rowView.setTag(viewHolder);
        }
        else {
            //recyclage
            viewHolder = (ViewHolder) rowView.getTag();
        }

        //---------------------
        // Remplissage
        //-------------------------

        final Eleve eleveBean = getItem(position);

        viewHolder.ec_tv_nom.setText(eleveBean.getNom());
        viewHolder.ec_tv_prenom.setText(eleveBean.getPrenom());
        viewHolder.eleveBean = eleveBean;

        return rowView;
    }

    //------------------
    // View Holder
    //------------------
    public static class ViewHolder {
        public TextView ec_tv_nom, ec_tv_prenom;
        public Eleve eleveBean;
    }

}
