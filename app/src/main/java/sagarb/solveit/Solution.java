package sagarb.solveit;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;
    private TextView equationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        changeStatusBarColor();
        listView = (ListView)findViewById(R.id.solutionListView);
        equationTextView = (TextView)findViewById(R.id.equationTextView);

        equationTextView.setText(getIntent().getStringExtra("EQUATION") + " = 0");

        String solution = getIntent().getStringExtra("SOLUTION");
        if(!solution.contains("Error"))
            solution = solution.substring(1,solution.length()-1);

        String[] solutions = solution.split(",");

        customAdapter = new CustomAdapter(this,R.layout.list_row,solutions);
        listView.setAdapter(customAdapter);
    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
