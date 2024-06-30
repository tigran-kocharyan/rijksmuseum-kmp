import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        KoinStarterKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ContentView: View {
    @State private var showContent = false
    var body: some View {
        let message = CommonInteractorHelper().getMessage()
        
        Text(message)
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
