package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity2 : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragmentLayout: FragmentContainerView? = findViewById(R.id.baContainer)
        if (fragmentLayout != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.baContainer, FragmentBA::class.java, null)
                .replace(R.id.bbContainer, FragmentBB::class.java, null)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main2FragmentContainer, FragmentBA::class.java, null)
                .addToBackStack(null)
                .commit()
        }
    }
}