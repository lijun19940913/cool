package firsttest.lijun.com.firsttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

public class SecendActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView edit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        Intent intent=getIntent();
        String text=intent.getStringExtra("data");
        edit=(TextView) findViewById(R.id.TextView1);
        String inputText=load();
        edit.setText(inputText);
        if (!TextUtils.isEmpty(inputText)){
            edit.setText(inputText);
            Toast.makeText(this,"restoring is suceeded",Toast.LENGTH_SHORT).show();
        }
        button=(Button) findViewById(R.id.button2);
        button.setOnClickListener(this);

    }

    public String load(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button2:
                Intent intent=new Intent(SecendActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
