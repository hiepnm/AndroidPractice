package course.lab.fragmentstatic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuoteFragment extends Fragment {
	private TextView mQuoteView;
	private int mCurIndex = -1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.quote_view, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mQuoteView = (TextView)getActivity().findViewById(R.id.tvQuote);
	}
	public void showQuoteAtIndex(int newIndex) {
		if (newIndex < 0 || newIndex >= QuoteViewActivity.mQuotes.length) {
			return;
		}
		mCurIndex = newIndex;
		mQuoteView.setText(QuoteViewActivity.mQuotes[mCurIndex]);
	}
	public int getShowIndex() {
		// TODO Auto-generated method stub
		return mCurIndex;
	}
}
