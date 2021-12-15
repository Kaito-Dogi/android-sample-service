package app.doggy.servicesample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    // MediaPlayerの変数
    private lateinit var sheepBleat: MediaPlayer

    // MediaPlayerのループを切り替える．
    private var isLooping = true

    // サービスが最初に作成された時に呼び出される．
    // onStartCommand()やonBind()の前に呼び出される．
    override fun onCreate() {
        super.onCreate()
        Log.d(SERVICE_LOG, "onCreate() @MyService")

        sheepBleat = MediaPlayer.create(this, R.raw.sheep_bleat)
        sheepBleat.isLooping = isLooping
        sheepBleat.setOnCompletionListener {
            Log.d(SERVICE_LOG, "stopSelf() @MyService")
            stopSelf()
        }
    }

    // 他のコンポーネント（アクティビティなど）がサービスの開始をリクエストするためにstartService()を呼び出した時に呼び出される．
    // このメソッドが実行されるとサービスが開始され，バックグラウンドで無期限に動作出来る．
    // このメソッドを実行した場合，作業完了時にstopSelf()かstopService()を呼び出して自身でサービスを停止する必要がある．
    // 逆に，サービスがstopSelf()を使って自身で停止するか，他のコンポーネントがstopService()を呼び出して停止するまでサービスは動作し続ける．
    // ただしAndroid 8.0（APIレベル26, Oreo)以降ではアプリがバックグラウンドに移行して1分ほどでサービスが停止してしまう．
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(SERVICE_LOG, "onStartCommand() @MyService")

        sheepBleat.start()

        return super.onStartCommand(intent, flags, startId)
    }

    // サービスが使用されなくなり破棄されるときに呼び出される．
    override fun onDestroy() {
        super.onDestroy()

        sheepBleat.stop()
        sheepBleat.reset()
        sheepBleat.release()

        Log.d(SERVICE_LOG, "onDestroy() @MyService")
    }

    // 他のコンポーネントがサービスにバインドするためにbindService()を呼び出した時に呼び出される．
    // バインドを許可しない場合はnullを返す．
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    companion object {
        private const val SERVICE_LOG = "serviceLog"
    }
}