package fr.android.androidexercises;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        boolean landscape = getResources().getBoolean(R.bool.landscape);

        View frame2 = findViewById(R.id.fragment2);

        if (landscape) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment2, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                    .commit();

            frame2.setVisibility(View.VISIBLE);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .commit();

            frame2.setVisibility(View.GONE);

        }

        // TODO replace Step0Fragment in containerFrameLayout
    }

    @Override
    public void onNext(int requestCode) {
        switch (requestCode) {
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment1, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                        .addToBackStack(Step0Fragment.class.getSimpleName())
                        .commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment1, new Step2Fragment(), Step2Fragment.class.getSimpleName())
                        .addToBackStack(Step1Fragment.class.getSimpleName())
                        .commit();
                break;
        }

        // TODO replace Step1Fragment in containerFrameLayout
    }

}
