package johnv.checksplitter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class EvenSplitResultsFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_esresults, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText subtotal = view.findViewById(R.id.subtotalEText);
        subtotal.setText(String.format("%.2f", Global.Subtotal));
        subtotal.setEnabled(false);

        EditText addedTip = view.findViewById(R.id.addedTipEText);
        addedTip.setText(String.format("%.2f", Global.Tip_Total));
        addedTip.setEnabled(false);

        EditText grandTotal = view.findViewById(R.id.grandTotalEText);
        grandTotal.setText(String.format("%.2f", Global.Grand_Total));
        grandTotal.setEnabled(false);

        EditText eachPersonPays = view.findViewById(R.id.eachPersonPaysEText);
        eachPersonPays.setText(String.format("%.2f", Global.Grand_Total_Even_Split));
        eachPersonPays.setEnabled(false);


        view.findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EvenSplitResultsFragment.this)
                        .navigate(R.id.action_evenSplitResultsFragment_to_mainFragment);
            }
        });
    }
}
