package com.example.saurav.gridviewimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Integer[] mThumbIds = {
            R.drawable.gingerbread, R.drawable.honeycomb,
            R.drawable.icecream, R.drawable.jellybean,
            R.drawable.lollipop, R.drawable.kitkat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, mThumbIds));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, " " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;
        String[] result;
        Integer[] imageId;
        private LayoutInflater inflater = null;

        public ImageAdapter(Context c, Integer[] mthumbIds) {
            mContext = c;
            imageId = mThumbIds;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class Holder {
            ImageView imageview;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.custom_row, null);
            holder.imageview = (ImageView) rowView.findViewById(R.id.imageView1);

            holder.imageview.setImageResource(imageId[position]);

            return rowView;
        }
    }
}
