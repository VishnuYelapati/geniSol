package android.com.delta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_register1,btn_login1;
    EditText edit_uerId,edit_password;
    String userId,password;

    public static SharedPreferences loginPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edit_uerId=(EditText)findViewById(R.id.et_userid);
        edit_password=(EditText)findViewById(R.id.et_password);
        btn_register1=(Button)findViewById(R.id.btn_register1);
        btn_login1=(Button)findViewById(R.id.btn_login1);

        loginPreferences = getSharedPreferences("loginPrefs",	Context.MODE_PRIVATE);

        btn_register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userId=edit_uerId.getText().toString();
                password=edit_password.getText().toString();

                String uname=loginPreferences.getString("userId","");
                String pwd=loginPreferences.getString("Password","");
                if(userId.equals(uname)&&password.equals(pwd)) {
                    startActivity(new Intent(LoginActivity.this, ApkListActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid username,password",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
