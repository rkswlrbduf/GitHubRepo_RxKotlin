package blackstone.com.githubrepo_rxkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_owner.*

class OwnerActivity : AppCompatActivity() {

    private lateinit var mInput: TextView
    private lateinit var mNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner)

        mInput = input
        mNext = next

        mNext.setOnClickListener {
            val intent = Intent(this@OwnerActivity, MainActivity::class.java)
            intent.putExtra("owner", mInput.text)
            startActivity(intent)
        }

    }
}