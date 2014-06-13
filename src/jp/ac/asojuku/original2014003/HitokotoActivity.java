package jp.ac.asojuku.original2014003;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class HitokotoActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitokoto_activity);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		//画面(Activity)に渡されたインテントを取得
		Intent intent = this.getIntent();
		//intentから、Extraに混入させた値をキーワードで取得
		String strHitokoto = intent.getStringExtra("hitokoto");

		//取得したStringを、TxtViewにセット
		TextView txvHITOKOTO = (TextView)findViewById(R.id.txvHITOKOTO);
		txvHITOKOTO.setText(strHitokoto);
	}

}
