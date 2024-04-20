package il.theguyd.mymvvmcounter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import il.theguyd.mymvvmcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //setup data binding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Important for LiveData to update the UI automatically
        activityMainBinding.setLifecycleOwner(this);

        //initialize ViewModel that will be lifecycle aware and save state during orientation change
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //bind variables (bind data)
        activityMainBinding.setMyViewModel(myViewModel);

///////// you can also delete the bind on the layout on the text view id txtNumericScore and implement onChange ///////////
//        //observing live data
//        myViewModel.getCounter().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer counter) {
//                activityMainBinding.txtNumericScore.setText(String.valueOf(counter));
//            }
//        });
    }
}