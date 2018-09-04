package firsttest.lijun.com.firsttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.io.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=(EditText) findViewById(R.id.text1);
        button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    public void save(String inputText){
        FileOutputStream out=null;
        Writer writer=null;
        try{
            out=openFileOutput("data", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    protected void onDestory(){
        super.onDestroy();
        String inputText=edit.getText().toString();
        save(inputText);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                Intent intent=new Intent(MainActivity.this,SecendActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }

}
