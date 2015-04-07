package course.lab.fragmentprogrammatic;

import course.lab.fragmentprogrammatic.TitleFragment.ListSelectionListener;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class QuoteViewActivity extends Activity implements ListSelectionListener{
	public static String[] mTitles;
	public static String[] mQuotes;
	public QuoteFragment mQuoteFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mTitles = getResources().getStringArray(R.array.titles);
		mQuotes = getResources().getStringArray(R.array.quotes);
		setContentView(R.layout.main);
		mQuoteFragment = new QuoteFragment();
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.flTitle, new TitleFragment());
		fragmentTransaction.add(R.id.flQuote, mQuoteFragment);
		fragmentTransaction.commit();
	}
	@Override
	public void onListSelection(int index) {
		if (mQuoteFragment.getCurIndex() != index) {
			mQuoteFragment.showQuoteAtIndex(index);
		}
	}
	
}
