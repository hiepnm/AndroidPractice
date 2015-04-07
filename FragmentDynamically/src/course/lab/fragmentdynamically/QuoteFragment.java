package course.lab.fragmentdynamically;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuoteFragment extends Fragment {
	private int mCurIndex = -1;
	private int mQuotesLength;
	private TextView mTvQuote;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.quote, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mQuotesLength = QuoteViewActivity.mQuotes.length;
		mTvQuote = (TextView)getActivity().findViewById(R.id.tvQuote);
	}
	public void showQuoteAtIndex(int newIndex) {
		if (newIndex < 0 || newIndex >= mQuotesLength) {
			return;
		}
		mCurIndex = newIndex;
		mTvQuote.setText(QuoteViewActivity.mQuotes[mCurIndex]);
	}
	public int getCurIndex() {
		return mCurIndex;
	}
}
