import Foundation

struct PortfolioItemUiModel: Identifiable {
    public var id: String {
        return slug
    }

    public let title: String
    public let slug: String
    public let featuredImage: String
    public let excerpt: String
}
