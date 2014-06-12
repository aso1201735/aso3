package jp.ac.asojuku.original2014003;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 *  @param context 呼び出しコンテクスト
	 *  @param name 利用DB名
	 *  @param factory カーソルファクトリー
	 *  @param version DBバージョン
	 */
	public MySQLiteOpenHelper(Context context){

		super(context, "2010021201735.sqlite3", null, 1);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
		"Hitokoto(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , phrase TEXT)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table Hitokoto");
		onCreate(db);

	}
	/**
	 * 因数のフレーズをHitokotoテーブルにインサートするプライベートメソッド
	 * @param SQLiteDatabase インサート先DBのインスタンス変数
	 * @param inputMsg インサートするメッセージ
	 */

	public void insertHitokoto(SQLiteDatabase db, String inputMsg){

		String sqlstr = "insert into Hitokoto (phrase) " +"values(' " + inputMsg + " '); ";
				try {
					//トランザクション開始
					db.beginTransaction();
					db.execSQL(sqlstr);
					//トランザクション成功
					db.setTransactionSuccessful();
				}catch (SQLException e){
					Log.e("ERROR", e.toString());
				}finally {
					//トランザクション終了
					db.endTransaction();
				}
		return;
	}

	/**
	 *  引数のフレーズをHitokotoテーブルにインサートするプライベートメソッド
	 *  @param SQLiteDatabase インサート先DBのインスタンス変数
	 *  @param inputMsg インサートするメッセージ
	 */


}
