import SwiftUI
import WebKit

struct CustomWebView: UIViewRepresentable {
    let url: URL

    func makeUIView(context: Context) -> WKWebView  {
       let wkwebView = WKWebView()
       let request = URLRequest(url: url)
       wkwebView.load(request)
       return wkwebView
    }

    func updateUIView(_ uiView: WKWebView, context: Context) {
    }
}

#Preview {
    CustomWebView(url: URL(string: "https://tinaciousdesign.com/portfolio/bitmoji?minimal=1")!)
        .edgesIgnoringSafeArea(.all)
}
