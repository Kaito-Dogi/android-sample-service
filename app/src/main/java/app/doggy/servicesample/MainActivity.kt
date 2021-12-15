package app.doggy.servicesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.doggy.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.startButton.setOnClickListener {
            val myServiceIntent = Intent(this, MyService::class.java)
            Log.d(SERVICE_LOG, "startService() @MainActivity")
            startService(myServiceIntent)
        }

        binding.stopButton.setOnClickListener {
            val myServiceIntent = Intent(this, MyService::class.java)
            Log.d(SERVICE_LOG, "stopService() @MainActivity")
            stopService(myServiceIntent)
        }
    }

    companion object {
        private const val SERVICE_LOG = "serviceLog"
    }
}