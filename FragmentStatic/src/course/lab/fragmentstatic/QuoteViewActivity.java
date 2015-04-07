package course.lab.fragmentstatic;

import android.app.Activity;
import android.os.Bundle;

public class QuoteViewActivity extends Activity {
	public static String[] mTitles;
	public static String[] mQuotes;
	public QuoteFragment mFgQuote;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTitles = getResources().getStringArray(R.array.Titles);
		mQuotes = getResources().getStringArray(R.array.Quotes);
		mFgQuote = (QuoteFragment)getFragmentManager().findFragmentById(R.id.fgQuote);
	}
}
