package johnv.checksplitter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText numOfGuests = view.findViewById(R.id.numOfGuestsEText);
        final EditText subtotal = view.findViewById(R.id.checkTotalEText);
        final EditText tipPercent = view.findViewById(R.id.tipPercentEText);
        final CheckBox splitEvenly = view.findViewById(R.id.splitEvenlyCheckBox);

        view.findViewById(R.id.splitCheckButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Global.Number_Of_Guests = Integer.valueOf(numOfGuests.getText().toString());
                    Global.Subtotal = Double.valueOf(subtotal.getText().toString());
                    double tPerc = Double.valueOf(tipPercent.getText().toString());

                    Global.Tip_Total = Global.Subtotal * (tPerc / 100);
                    Global.Grand_Total = Global.Subtotal + Global.Tip_Total;
                    if(splitEvenly.isChecked()) {
                        Global.Grand_Total_Even_Split = Global.Grand_Total / Global.Number_Of_Guests;

                        NavHostFragment.findNavController(MainFragment.this)
                                .navigate(R.id.action_mainFragment_to_evenSplitResultsFragment);
                    }

                } catch (NumberFormatException e1) {
                    Toast toast = Toast.makeText(view.getContext(), "Please enter valid numbers", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (Exception e2) {
                    Toast toast = Toast.makeText(view.getContext(), "An error has occurred", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        view.findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfGuests.setText("");
                subtotal.setText("");
                tipPercent.setText("");
            }
        });
    }
}
