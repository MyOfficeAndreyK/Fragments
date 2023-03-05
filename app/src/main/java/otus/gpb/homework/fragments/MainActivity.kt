package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.fragmentButton).setOnClickListener() {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentA::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        findViewById<Button>(R.id.secondMainActivity).setOnClickListener() {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i);
        }
    }
}