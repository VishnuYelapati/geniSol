package android.com.delta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by srinu on 2/9/2016.
 */
public class UpdateChecker extends Activity {

    Button btn_check_update,btn_graph;
    TextView tv_package_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_checker);

        btn_check_update=(Button)findViewById(R.id.btn_chek_update);
        btn_graph=(Button)findViewById(R.id.btn_graph);
        tv_package_name=(TextView)findViewById(R.id.tv_package_name);

        btn_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateChecker.this,Graph.class));
            }
        });

        btn_check_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateChecker.this,WebViewActivity.class));
            }
        });
    }
}
