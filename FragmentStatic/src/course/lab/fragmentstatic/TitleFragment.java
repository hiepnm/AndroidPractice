package course.lab.fragmentstatic;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.title_item, QuoteViewActivity.mTitles));
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		getListView().setItemChecked(position, true);
		QuoteViewActivity host=(QuoteViewActivity)getActivity();
		if (host.mFgQuote.getShowIndex() != position) {
			host.mFgQuote.showQuoteAtIndex(position);
		}
	}
	
}
