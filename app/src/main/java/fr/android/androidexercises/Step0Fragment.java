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

import org.w3c.dom.Text;

public class Step0Fragment extends Fragment {

    private static final String step0 = "This is step 0";

    private OnNextStep0Listener listener;
    private TextView textView;
    private Button nextButton;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnNextStep0Listener) context;
        // TODO cast context to listener
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step0, container, false);

        textView = (TextView) view.findViewById(R.id.textView);
        nextButton = (Button) view.findViewById(R.id.nextButton_1);
        // TODO findViewById textView (TextView)
        // TODO findViewById nextButton (Button)
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO call onNext() from listener
                listener.onNext(0);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO setText(step0)
        textView.setText("This is step 0 !");
    }

    public interface OnNextStep0Listener {
        void onNext(int requestCode);
    }
}
