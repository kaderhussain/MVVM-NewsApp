package com.example.mvvm_news_app

import android.app.Application
import com.example.mvvm_news_app.di.component.ApplicationComponent
import com.example.mvvm_news_app.di.module.ApplicationModule
import javax.inject.Inject

class NewsApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var workManagerHelper: WorkManagerHelper

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
        workManagerHelper.setupWorker()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // Needed to replace the component with a test specific one
    fun setTestComponent(applicationComponent: ApplicationComponent){
        this.applicationComponent = applicationComponent
    }

}
