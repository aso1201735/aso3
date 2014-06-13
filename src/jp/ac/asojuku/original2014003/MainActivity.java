package jp.ac.asojuku.original2014003;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnOK = (Button)findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
		Button btnOK2 = (Button)findViewById(R.id.btnOK2);
		btnOK2.setOnClickListener(this);
		Button btnOK3 = (Button)findViewById(R.id.btnOK3);
		btnOK3.setOnClickListener(this);







		//クラスのフィールド変数がNULLなら、データベース空間オープン
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch (SQLiteException e){
			//異常終了
			return;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			Intent intent = null;
		switch(v.getId()){ //どのボタンが押されたか判定
			case R.id.btnOK2: //登録ボタン
				//エディットテキストからの入力内容を取り出す
				EditText etv = (EditText)findViewById(R.id.edtMsg);
				String inputMsg = etv.getText().toString();

				//inputMsgがnullでない、かつ、空でない場合のみ、if文内を実行
				if(inputMsg != null && !inputMsg.isEmpty()){
					//MySQLiteOpenHelperのインサートメソッドを呼び出し
					helper.insertHitokoto(sdb, inputMsg);
				}
				//入力欄をクリア
				etv.setText("");
				break;

			case R.id.btnOK:
				intent = new Intent(MainActivity.this,HitokotoActivity .class);
				startActivity(intent);
				break;

			case R.id.btnOK3:
				//MySQLiteOpenHelperのセレクト一言メソッドを呼び出して一言をランダムに取得
				String strHitokoto = helper.selectRandomHitokoto(sdb);

				//インテントのインスタンス作成
				intent = new Intent(MainActivity.this, HitokotoActivity.class);
				//インテントに一言を混入
				intent.putExtra("hitokoto", strHitokoto);

				//次画面のアクティビティ起動
				startActivity(intent);
				break;





	}

	}
}
