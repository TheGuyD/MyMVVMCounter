package il.theguyd.mymvvmcounter;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    MutableLiveData<Integer> counter = new MutableLiveData<>();


    public void increaseCounter(View view) {
        int counter = this.counter.getValue() != null ? this.counter.getValue() : 0;
        counter++;
        this.counter.setValue(counter);
    }


    public LiveData<Integer> getCounter() {
        return this.counter;
    }
}
