package lunainc.org.login;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import custom_font.MyEditText;

public class UsernameActivityLogin extends AppCompatActivity {

    public TextView signUp;
    public ImageView next;
    public MyEditText username;
    public RelativeLayout mContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);

        signUp =(TextView)findViewById(R.id.signUp);
        next = (ImageView)findViewById(R.id.next);
        username = (MyEditText) findViewById(R.id.user);
        mContainer = (RelativeLayout) findViewById(R.id.container);





        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().isEmpty()){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Intent it = new Intent(UsernameActivityLogin.this, PassActivityLogin.class);
                            it.putExtra("username",username.getText().toString());
                            startActivity(it);
                            finish();
                        }
                    },1000);



                }else{
                    Snackbar.make(mContainer, "Rellene los campos necesarios", Snackbar.LENGTH_LONG).show();
                    username.setText(null);
                }






            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(UsernameActivityLogin.this,SignUpActivity.class);
                startActivity(it);
            }
        });

    }
}
