package android.com.delta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by srinu on 2/8/2016.
 */
public class RegisterActivity extends Activity {

    Button btn_register2;
    EditText edit_uname,edit_userid,edit_pwd,edit_phoneNum;
    String userName,userId,password,phoneNum;

    public static SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        loginPreferences = getSharedPreferences("loginPrefs",	Context.MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        edit_uname=(EditText)findViewById(R.id.et_uname);
        edit_userid=(EditText)findViewById(R.id.et_uid);
        edit_pwd=(EditText)findViewById(R.id.et_pwd);
        edit_phoneNum=(EditText)findViewById(R.id.et_phone);


        btn_register2=(Button)findViewById(R.id.btn_register2);
        btn_register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=edit_uname.getText().toString();
                userId=edit_userid.getText().toString();
                password=edit_pwd.getText().toString();
                phoneNum=edit_phoneNum.getText().toString();

                loginPrefsEditor.putString("username", userName);
                loginPrefsEditor.putString("userId", userId);
                loginPrefsEditor.putString("Password", password);
                loginPrefsEditor.putString("phoneNum", phoneNum);
                loginPrefsEditor.commit();

                Toast.makeText(getApplicationContext(), "Registered sucessfully...", Toast.LENGTH_LONG).show();

                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}
