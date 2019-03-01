package com.example.systena.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
MainActivityというActivityがAppCompatActivityというクラスを継承している
public→これで宣言したクラス、変数、メソッドはJavaアプリケーション内のどこからでもアクセス可能（アクセス修飾子 制限をかける）
extends→継承 MainActiｖityはAppCompatActivityを継承している！！
AppCompatActivity→スーパークラス(親クラス
 */
public class MainActivity extends AppCompatActivity {
    /*
    変数型String(文字列入れることが出来る型）+変数名message = "HELLO!"という文字列を格納
    final→修飾子 1度しか代入できない変数にする （massageはここでHALLOと決めたので後で他の文字列を入れ直すことが出来ない
     */
    final String massage = "HELLO!";
    //okmassage変数名に文字列OKを格納
    String okmassage = "OK";
    //negativemassage変数名に文字列キャンセルを格納
    String negativemassage = "キャンセル";
    String Alertdialog_Title = "確認";
    String Alertdialog_Message = "表示しますか";

    /*変数名statusを宣言 アプリが起動した状態を「true」と定義 変数はa,bとかではなく意味のある変数名を名付ける
      boolean型 trueかfalseしか入らない！！
     */
    boolean status = true;

    //スーパークラスのメソッドをサブクラスで書き直すこと （AppCompatActivityのメソッドをMainActibityで書き直す）
    @Override
    //起動時の動作
    protected void onCreate(Bundle savedInstanceState) {

        //画面の破壊時に savedInstanceState(状態を保存しておくハコ）が作られる
        super.onCreate(savedInstanceState);
        //setContentViewメソッド onCreateメソッドの中で実行する この文が実行されることでテキスト部品が配置される
        // ()内はID XMLファイルで作成したレイアウトを表すIDを指定している
        setContentView(R.layout.activity_main);
        // toastbuttonにidであるtoastbuttonを紐づけ
        final Button toastbutton = findViewById(R.id.toastbutton);

        //toastbuttonにリスナクラスを実装（クリックイベントを受け取るようにする為に「View 」クラスで用意されているsetOnClickListenar」メソッドを使う
        toastbutton.setOnClickListener(new View.OnClickListener() {
            //アクセス修飾子+戻り値なし+メソッド名クリック （View 型+ｖを変数にしている）
            public void onClick(View v) {
                //
                Toast toast = Toast.makeText(MainActivity.this, massage, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        //textViewにtextViewのidを紐付け
        final TextView textView = (TextView) findViewById(R.id.textView);
        //AlertdialogbuttonにAlertdialogbuttonのidを紐付け
        final Button Alertdialogbutton = findViewById(R.id.alertdialogbutton);
        //OnClickListenerインタ-フェイスを実装したクラスのオブジェクトを指定 イベント発生時に「onClick」が呼び出される
        Alertdialogbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //AlertDirlogを作成するための機能を提供する「Builder」クラスのインスタンスを取得 引数にContentインスタンスを指定
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                //タイトルを設定
                alertDialog.setTitle(Alertdialog_Title);
                //メッセージを設定
                alertDialog.setMessage(Alertdialog_Message);
                /*肯定的な選択肢となるボタンを設定 OKを表示する DirlogIntefece→イベントが発生したダイアログ
                 onClickされた際にOKのテキストを表示 */
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    //OnClickメソッドに DirlogIntrfaceを引数に設定
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //toastという変数に内部Toastクラス。makeTextを代入
                        Toast toast = Toast.makeText(MainActivity.this, okmassage, Toast.LENGTH_LONG);
                        //トーストの呼び出し
                        toast.show();
                    }
                });
                /*否定的な選択肢となるボタンを設定 キャンセルを表示 DirlogIntefece→イベントが発生したダイアログ
                onClickされた際にのテキストを表示*/
                alertDialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = Toast.makeText(MainActivity.this, negativemassage, Toast.LENGTH_LONG);
                        toast.show();

                    }
                });
                //アートダイアログの呼び出し
                alertDialog.create().show();
            }

        });

        final Button Colorbutton =  findViewById(R.id.colorbutton);
        //OnClickListenerインタ-フェイスを実装したクラスのオブジェクトを指定 イベント発生時に「onClick」が呼び出される
        Colorbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                if (status) {
                    Colorbutton.setBackgroundColor(Color.BLUE);
                    Alertdialogbutton.setBackgroundColor(Color.BLUE);
                    toastbutton.setBackgroundColor(Color.BLUE);
                    Colorbutton.setTextColor(Color.WHITE);
                    Alertdialogbutton.setTextColor(Color.WHITE);
                    toastbutton.setTextColor(Color.WHITE);
                    //クリックしたら色が変わる→デフォルトのtrueではなくなるので statusはfalseに定義し直す
                    status = false;
                } else {
                    Colorbutton.setBackgroundColor(Color.GREEN);
                    Alertdialogbutton.setBackgroundColor(Color.GREEN);
                    toastbutton.setBackgroundColor(Color.GREEN);
                    Colorbutton.setTextColor(Color.BLACK);
                    Alertdialogbutton.setTextColor(Color.BLACK);
                    toastbutton.setTextColor(Color.BLACK);
                    //クリックしたら色が変わる→デフォルトに戻るtrueになるので statusはtrueに定義しなおす
                    status = true;

                }

            }

        });

    }

    }




