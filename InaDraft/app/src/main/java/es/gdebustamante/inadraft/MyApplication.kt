package es.gdebustamante.inadraft

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Clase base que se ejecuta nada más comenzar la app, su único proposito es dar el contexto de esta para prevenir memory leaks
 */
@HiltAndroidApp
class MyApplication : Application()