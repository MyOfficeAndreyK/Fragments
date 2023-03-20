package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.fragmentABButton).setOnClickListener() {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentAView, FragmentAB.create(ColorGenerator.generateColor()), null)
                .addToBackStack(null)
                .commit()
        }

        val args = arguments?.getInt(ARG_NAME)
        if (args != null) {
            view.setBackgroundColor(args)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0)
                    childFragmentManager.popBackStack()
                else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }

    companion object {
         private const val ARG_NAME = "arg_color"

        fun create(color: Int): FragmentAA {
            val f = FragmentAA()
            val args = Bundle()
            args.putInt(ARG_NAME, color)
            f.arguments = args
            return f
        }
    }

}