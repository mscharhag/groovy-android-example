package com.mscharhag.groovytodo.activities

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.mscharhag.groovytodo.R

class ToDoListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_list)
        setListAdapter(new ToDoListAdapter(this, R.layout.todo_list_item))
    }

    @Override
    protected void onResume() {
        super.onResume()
        /*  With Java this would look like this:
            ArrayAdapter<ToDo> adapter = (ArrayAdapter<ToDo>) getListAdapter();
            adapter.clear()
            adapter.addAll((ToDoApplication) getApplication()).getToDos());
            adapter.notifyDataSetChanged()
        */

        listAdapter.clear()
        listAdapter.addAll(application.toDos)
        listAdapter.notifyDataSetChanged()
    }

    @Override
    boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo_list_menu, menu);
        return true;
    }

    @Override
    boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_item) {
            startActivity(new Intent(this, CreateNewTodoActivity.class))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}