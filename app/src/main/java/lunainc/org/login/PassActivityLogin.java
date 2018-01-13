package lunainc.org.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import custom_font.MyEditText;

public class PassActivityLogin extends AppCompatActivity {

   public TextView signUp;
   public ImageView back;
   public RelativeLayout mContainer;
   public MyEditText mPass;
   public ImageView completeLogin;
   public ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        back = (ImageView)findViewById(R.id.back);

        signUp = (TextView)findViewById(R.id.signUp);
        mContainer = (RelativeLayout) findViewById(R.id.container);
        mPass = (MyEditText) findViewById(R.id.password);
        completeLogin = (ImageView) findViewById(R.id.dSig);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(PassActivityLogin.this,UsernameActivityLogin.class);
                startActivity(it);


            }
        });


        final String username = getIntent().getStringExtra("username");

        //verified data for intent
        if (username.isEmpty()){
            Snackbar.make(mContainer, "Error al recuperar los datos intentelo de nuevo más tarde", Snackbar.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent it= new Intent(PassActivityLogin.this,UsernameActivityLogin.class);
                    startActivity(it);
                    finish();

                }
            },2000);

        }

        completeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mPass.getText().toString().isEmpty() ){

                    if (username.equals("juan") && mPass.getText().toString().equals("juan")){


                        mProgress = new ProgressDialog(PassActivityLogin.this);
                        mProgress.setTitle("Iniciando sesión");
                        mProgress.setMessage("Espere un momento por favor");
                        mProgress.setCanceledOnTouchOutside(false);
                        mProgress.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mProgress.dismiss();

                                Intent menuActivity = new Intent(PassActivityLogin.this, MenuActivity.class);
                                startActivity(menuActivity);
                                finish();
                            }
                        },2000);



                    }else{
                        Snackbar.make(mContainer, "Nombre de usuario o contraseña incorrectos", Snackbar.LENGTH_LONG).show();
                    }



                }else {

                    Snackbar.make(mContainer, "Rellene todos los campos", Snackbar.LENGTH_LONG).show();
                }
            }
        });




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PassActivityLogin.this,SignUpActivity.class);
                startActivity(it);
            }
        });
    }
}
