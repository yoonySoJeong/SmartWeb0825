package com.koreait.smartapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public ArrayList<Book> list;
    public Context context;

    public CustomAdapter(Context content) {
        list = new ArrayList<>();
        this.context = content;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addItem(String bookCover, String title, String content) {
        list.add(new Book(bookCover, title, content));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.book_item, viewGroup, false);
        }
        ImageView book = view.findViewById(R.id.img_book);
        TextView title = view.findViewById(R.id.txt_title);
        TextView content = view.findViewById(R.id.txt_content);
        Book item = list.get(i);
        Log.i("runTranslate", item.getBookCover());
        Glide.with(getContext()).load(item.getBookCover().replace("\"", "")).placeholder(R.drawable.mic).into(book);
        title.setText(item.getTitle());
        content.setText(item.getContent());
        return view;
    }

}
