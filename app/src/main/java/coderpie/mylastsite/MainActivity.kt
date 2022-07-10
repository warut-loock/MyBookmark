package coderpie.mylastsite

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoShowKeyboard = findViewById<TextView>(R.id.editText_enter_Page)
        showSoftKeyboard(autoShowKeyboard)

        findViewById<Button>(R.id.button_save_and_close).setOnClickListener {
            val enterPage = findViewById<TextView>(R.id.editText_enter_Page).text.toString()
            finishAndRemoveTask()

            if (enterPage.isBlank()) {
                return@setOnClickListener
            } else {
                getSharedPreferences("side", Context.MODE_PRIVATE).edit()
                    .putString("momorypage", enterPage).apply()

            }
        }
    }
// Test Comment
    fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.textView_page).text =
            getSharedPreferences("side", Context.MODE_PRIVATE).getString("momorypage", "")
    }

}

