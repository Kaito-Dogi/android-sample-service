package app.doggy.servicesample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    // サービスが最初に作成された時に呼び出される．
    // onStartCommand()やonBind()の前に呼び出される．
    override fun onCreate() {
        super.onCreate()
        Log.d(SERVICE_LOG, "========== onCreate() ==========")
    }

    // 他のコンポーネント（アクティビティなど）がサービスの開始をリクエストするためにstartService()を呼び出した時に呼び出される．
    // このメソッドが実行されるとサービスが開始され，バックグラウンドで無期限に動作出来る．
    // このメソッドを実行した場合，作業完了時にstopSelf()かstopService()を呼び出して自身でサービスを停止する必要がある．
    // 逆に，サービスがstopSelf()を使って自身で停止するか，他のコンポーネントがstopService()を呼び出して停止するまでサービスは動作し続ける．
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(SERVICE_LOG, "========== onStartCommand ==========")
        return super.onStartCommand(intent, flags, startId)
    }

    // サービスが使用されなくなり破棄されるときに呼び出される．
    override fun onDestroy() {
        super.onDestroy()
        Log.d(SERVICE_LOG, "========== onDestroy() ==========")
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