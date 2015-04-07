package course.lab.fragmentdynamically;

import course.lab.fragmentdynamically.TitleFragment.ListSelectionListener;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class QuoteViewActivity extends Activity implements ListSelectionListener{
	private static int MATCH_PARENT=LinearLayout.LayoutParams.MATCH_PARENT;
	public static String[] mTitles;
	public static String[] mQuotes;
	public QuoteFragment mQuoteFragment;
	public FrameLayout mFlTitle;
	public FrameLayout mFlQuote;
	private FragmentManager mFragmentManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mTitles = getResources().getStringArray(R.array.titles);
		mQuotes = getResources().getStringArray(R.array.quotes);
		setContentView(R.layout.main);
		mFlTitle = (FrameLayout)findViewById(R.id.flTitle);
		mFlQuote = (FrameLayout)findViewById(R.id.flQuote);
		mQuoteFragment = new QuoteFragment();
		mFragmentManager = getFragmentManager();
		FragmentTransaction  fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.flTitle, new TitleFragment());
		fragmentTransaction.commit();
		mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
			@Override
			public void onBackStackChanged() {
				setLayout();
			}
		});
		
	}
	public void setLayout() {
		if (mQuoteFragment.isAdded()) {
			mFlTitle.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 1f));
			mFlQuote.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 2f));
		} else {
			mFlTitle.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
			mFlQuote.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
		}
		
	}
	@Override
	public void onListSelection(int index) {
		if (!mQuoteFragment.isAdded()) {
			FragmentTransaction ftransaction = mFragmentManager.beginTransaction();
			ftransaction.add(R.id.flQuote, mQuoteFragment);
			ftransaction.addToBackStack(null);
			ftransaction.commit();
			mFragmentManager.executePendingTransactions();
		}
		if (mQuoteFragment.getCurIndex() != index) {
			mQuoteFragment.showQuoteAtIndex(index);
		}
	}
	
}
