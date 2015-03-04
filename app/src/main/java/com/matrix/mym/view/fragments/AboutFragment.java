package com.matrix.mym.view.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.matrix.mym.R;
import com.matrix.mym.utils.SystemFeatureChecker;

public class AboutFragment extends MymMainFragment {
	private TextView versionTextView;

	public AboutFragment() {
		super(R.string.about);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_about, container,
				false);
		initViews(rootView);


        Button button = (Button) rootView.findViewById(R.id.button_quiz);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent openBrowser =  new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.javacodegeeks.com"));
                startActivity(openBrowser);
                // do something
            }
        });
        return rootView;
	}

	private void initViews(View rootView) {
		versionTextView = (TextView) rootView.findViewById(R.id.tvVersion);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		versionTextView.setText(getString(R.string.version,
				SystemFeatureChecker.getAppVersionName(getActivity())));
	}
}
