import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    @State private var showingSheet = false

	var body: some View {
        NavigationView {
            ScrollView {
                VStack {
                    if (viewModel.portfolioItems.isEmpty) {
                        Text("⏳ Loading ...")
                            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
                    }

                    ForEach(viewModel.portfolioItems) { portfolioItem in
                        NavigationLink(destination: WebsiteWebView(url: "https://tinaciousdesign.com/portfolio/\(portfolioItem.slug)?minimal=1")) {
                            VStack {
                               // Image
                               AsyncImage(url: URL(string: portfolioItem.featuredImage)) { result in
                                   result.image?
                                       .resizable()
                                       .scaledToFill()
                               }

                               // Title
                               Text(portfolioItem.title)
                                   .font(.system(size: 20, weight: .black))
                                   .frame(maxWidth: .infinity, alignment: .leading)
                                   .padding(
                                       EdgeInsets(
                                           top: 10,
                                           leading: 20,
                                           bottom: 0,
                                           trailing: 10
                                       )
                                   )

                               // Summary (HTML)
                               Text(portfolioItem.excerpt.replaceHtmlEntities())
                                   .font(.system(size: 16))
                                   .frame(maxWidth: .infinity, alignment: .leading)
                                   .padding(
                                       EdgeInsets(
                                           top: 0,
                                           leading: 20,
                                           bottom: 40,
                                           trailing: 10
                                       )
                                   )
                           }
                       }
                        .buttonStyle(PlainButtonStyle())
                    }
                }
            }
        }
	}
}

extension ContentView {
    class ViewModel : ObservableObject {
        @Published var portfolioItems: [PortfolioItemUiModel]

        init() {
            self.portfolioItems = []

            ApiUtils().getPortfolioItems { items, error in
                if let items = items {
                    self.portfolioItems = items.map {
                        PortfolioItemUiModel(
                            title: $0.title,
                            slug: $0.slug,
                            featuredImage: $0.featuredImage.url,
                            excerpt: $0.excerptHtml
                        )
                    }
                } else {
                    print("Error: \(error)")
                }
            }
        }
    }
}
