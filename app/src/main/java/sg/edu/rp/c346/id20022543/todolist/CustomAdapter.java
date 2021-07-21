package sg.edu.rp.c346.id20022543.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id; //layout id
    ArrayList<ToDoItem> toDoList;  //pass in the data and store it

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {     //getView() calls for every item in the listview
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentList = toDoList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentList.getTitle());
        tvDate.setText(currentList.toString());

        return rowView;
    }

}

