package course.lab.fragmentdynamically;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment {
	public interface ListSelectionListener {
		public void onListSelection(int index);
	}
	private ListSelectionListener mListener;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (ListSelectionListener)activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement ListSelectionListener");
		}
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.title, QuoteViewActivity.mTitles));
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		getListView().setItemChecked(position, true);
		mListener.onListSelection(position);
	}
	
	
}
