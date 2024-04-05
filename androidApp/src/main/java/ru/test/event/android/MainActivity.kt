package ru.test.event.android

import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.arkivanov.decompose.defaultComponentContext
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf
import ru.test.root.RootComponent
import ru.test.root.ui.RootScreen

/**
 * Использование [ComponentActivity] вызывает ошибку:
 * ClassCastException: com.example.app.MainActivity cannot be cast to androidx.fragment.app.FragmentActivity
 * Временным решением яв-ся использование [FragmentActivity]:
 * https://github.com/icerockdev/moko-permissions/issues/106#issuecomment-1990348270
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val systemBarStyle = SystemBarStyle.light(
            scrim = Color.TRANSPARENT,
            darkScrim = Color.TRANSPARENT
        )
        enableEdgeToEdge(
            statusBarStyle = systemBarStyle,
            navigationBarStyle = systemBarStyle,
        )
        val root = get<RootComponent> { parametersOf(defaultComponentContext()) }
        setContent {
            RootScreen(
                component = root
            )
        }
    }
}