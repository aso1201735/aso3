package jp.ac.asojuku.original2014003;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

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
			case R.id.btnOK3: //ボタンbtnOKが押された
				intent = new Intent(MainActivity.this, HitokotoActivity.class);
				startActivity(intent);



	}

	}
}
