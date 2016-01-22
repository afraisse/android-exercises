package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Step1Fragment extends Fragment {

    private TextView textView;
    private Button nextButton;
    private Step0Fragment.OnNextStep0Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Step0Fragment.OnNextStep0Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step1, container, false);

        textView = (TextView) view.findViewById(R.id.step1TextView);
        nextButton = (Button) view.findViewById(R.id.nextButton_2);
        // TODO findViewById textView (TextView)
        // TODO findViewById nextButton (Button)
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO call onNext() from listener
                listener.onNext(1);
            }
        });
        return view;
    }


}
