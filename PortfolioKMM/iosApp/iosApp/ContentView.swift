import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

	var body: some View {
		Text(viewModel.text)
	}
}

extension ContentView {
    class ViewModel : ObservableObject {
        @Published var text = "Loading..."

        init() {
            ApiUtils().getPortfolioItems { items, error in
                if let items = items {
                    self.text = items.map { $0.title }.joined(separator: "")
//                    self.text = items.joined(separator: "")
                } else {
                    self.text = error?.localizedDescription ?? "unknown error"
                }

            }
        }
    }
}
