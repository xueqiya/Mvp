package com.yiya.mvp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yiya.mvp.R;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    private List list;

    public HomeAdapter(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LinearLayout.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(list.get(i)+"");
        return view;
    }
}
