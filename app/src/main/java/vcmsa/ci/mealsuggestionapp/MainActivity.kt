package vcmsa.ci.mealsuggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val exitBtn: Button = findViewById(R.id.exitBtn)
        val suggestButton: Button = findViewById(R.id.suggestButton)
        val clearButton: Button = findViewById(R.id.ClearButton)
        val suggestionText: TextView = findViewById(R.id.suggestionText)

        suggestButton.setOnClickListener {

            val timeOfDay = inputTime.text.toString().trim().lowercase()

            val mealSuggestions =  when (timeOfDay) {
                "morning" -> "Breakfast try: Egg Muffins, Pancakes, Oatmeal, French Toast, Waffle  "
                "afternoon" -> "Afternoon try: Chickpea Salad Sandwich, Veggie Fried Rice, Spicy Rice Noodles, BBQ Chicken Pasta, Chicken Grilled Cheese"
                "night" -> "Dinner try: Parmesan Chicken Pasta, Mongolian Beef, Creamy shrimp Udon, Honey BBQ Chicken Wings, Chicken Curry"
                else -> null
            }

            if (mealSuggestions != null) {

                suggestionText.text = mealSuggestions

            }else{

                Toast.makeText(this,"Invalid input Please enter a valid day of time", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            inputTime.text.clear()
            suggestionText.text =""
        }
        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}