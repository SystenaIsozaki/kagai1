package com.example.systena.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
final String massage = "HELLO!" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button toastbutton = findViewById(R.id.toastbutton);
        toastbutton.setOnClickListener (new View.OnClickListener(){
            public void  onClick(View v){
                Toast toast = Toast.makeText(MainActivity.this,massage,Toast.LENGTH_LONG);
                toast.show();
            }
        });
        //textViewにtextViewのidを紐付け
        final TextView textView = (TextView)findViewById(R.id.textView);
        //button2にbutton2のidを紐付け
        Button button2 =  findViewById(R.id.button2);
        //OnClickListenerインタ-フェイスを実装したクラスのオブジェクトを指定 イベント発生時に「onClick」が呼び出される
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //AlertDirlogを作成するための機能を提供する「Builder」クラスのインスタンスを取得 引数にContentインスタンスを指定
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                //タイトルを設定
                alertDialog.setTitle("確認");
                //メッセージを設定
                alertDialog.setMessage("表示しますか");
                /*肯定的な選択肢となるボタンを設定 OKを表示する DirlogIntefece→イベントが発生したダイアログ
                 onClickされた際にOKのテキストを表示 */
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("OK");
                    }
                });
                /*否定的な選択肢となるボタンを設定 キャンセルを表示 DirlogIntefece→イベントが発生したダイアログ
                onClickされた際にOKのテキストを表示*/
                alertDialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("キャンセル");

                    }
                });
                //アートダイアログの呼び出し
                alertDialog.create().show();
        }
        });


    }
}



