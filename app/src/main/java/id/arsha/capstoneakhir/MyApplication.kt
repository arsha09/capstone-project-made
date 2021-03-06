package id.arsha.capstoneakhir

import android.app.Application
import id.arsha.core.di.databaseModule
import id.arsha.core.di.networkModule
import id.arsha.core.di.repositoryModule
import id.arsha.capstoneakhir.di.useCaseModule
import id.arsha.capstoneakhir.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}