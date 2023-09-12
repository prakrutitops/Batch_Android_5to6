package tops.tech.realmex

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()

        Realm.init(this)
        var config = RealmConfiguration.Builder()
                        .name("user.db")
                        .schemaVersion(1)
                        .deleteRealmIfMigrationNeeded()
                        .build()

        Realm.setDefaultConfiguration(config)
    }
}