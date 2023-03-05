package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class FragmentBB : Fragment(R.layout.fragment_b_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.sendColorButton).setOnClickListener {
            val colorBundle = Bundle()
            colorBundle.putInt("color", ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult("sentColor", colorBundle)
            // To close this fragment
            if (requireActivity().findViewById<FragmentContainerView>(R.id.main2FragmentContainer) != null)
                requireActivity().onBackPressed()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (parentFragmentManager.backStackEntryCount > 0)
                    parentFragmentManager.popBackStack()
                else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }
}