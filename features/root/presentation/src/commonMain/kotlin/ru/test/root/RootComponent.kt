package ru.test.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.test.startup.root.StartupRootComponent

interface RootComponent {
    sealed interface Child {
        data class StartupRoot(val component: StartupRootComponent) : Child
    }

    val stack: Value<ChildStack<*, Child>>
}