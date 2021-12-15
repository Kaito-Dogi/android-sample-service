package app.doggy.servicesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.startButton.setOnClickListener {

        }

        binding.stopButton.setOnClickListener {

        }
    }
}