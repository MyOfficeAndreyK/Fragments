package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_a_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments?.getInt(ARG_NAME)
        if (args != null) {
            view.setBackgroundColor(args)
        }
    }

    companion object {
        private const val ARG_NAME = "arg_color"

        fun create(color: Int): FragmentAB {
            val f = FragmentAB()
            val args = Bundle()
            args.putInt(ARG_NAME, color)
            f.arguments = args
            return f
        }
    }
}