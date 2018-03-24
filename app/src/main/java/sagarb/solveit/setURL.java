package sagarb.solveit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class setURL extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_url);
        editText = (EditText) findViewById(R.id.inputURL);
        editText.setText(URLs.ip);
        button = (Button) findViewById(R.id.submitURL);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URLs.ip = editText.getText().toString();
                URLs.UPLOAD_URL="http://"+URLs.ip+":3000/imgupload";
                Toast.makeText(getApplicationContext(),"URL is:"+ URLs.UPLOAD_URL,Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),CameraScanner.class));
            }
        });
    }
}
