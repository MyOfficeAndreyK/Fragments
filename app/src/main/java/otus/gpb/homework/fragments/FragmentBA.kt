package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_b_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.openBBButton)
        button?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main2FragmentContainer, FragmentBB::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("sentColor", this) {_, res ->
            view.setBackgroundColor(res.getInt("color"))
        }
    }
}