import androidx.compose.ui.window.ComposeUIViewController
import com.totowka.kmp.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
