package com.mscharhag.groovytodo.activities

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mscharhag.groovytodo.R

class ToDoListAdapter extends ArrayAdapter {

    ToDoListAdapter(Context context, int resource) {
        super(context, resource)
    }

    @Override
    View getView(int position, View convertView, ViewGroup parent) {
        def item = getItem(position)

        def inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        View rowView = inflater.inflate(R.layout.todo_list_item, parent, false)

        def titleView = rowView.findViewById(R.id.todo_title)
        titleView.text = item.title

        def descriptionView = rowView.findViewById(R.id.todo_description)
        descriptionView.text = item.description
        return rowView;
    }
}