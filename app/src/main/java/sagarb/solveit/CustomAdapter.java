package sagarb.solveit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import sagarb.solveit.R;

/**
 * Created by Dell on 19-03-2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private String[] data;
    private Activity context;
    private int resource;

    public CustomAdapter(Activity context, int resource, String[] data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View view, ViewGroup prarent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(resource,null,true);
        TextView solution_text_view = (TextView) rowView.findViewById(R.id.list_row_text_view);
        solution_text_view.setText(data[position].toLowerCase());
        return rowView;
    }
}
